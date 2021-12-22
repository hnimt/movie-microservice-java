package fpt.trainining.movietheatre.service.impl;

import fpt.trainining.movietheatre.dto.invoice.InvoiceConfirmReq;
import fpt.trainining.movietheatre.entity.*;
import fpt.trainining.movietheatre.exception.NotEnoughMoneyException;
import fpt.trainining.movietheatre.exception.ResourceNotFoundException;
import fpt.trainining.movietheatre.repository.InvoiceRepository;
import fpt.trainining.movietheatre.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final MemberService memberService;
    private final MovieService movieService;
    private final ScheduleService scheduleService;
    private final ShowDateService showDateService;
    private final ScheduleSeatService scheduleSeatService;
    private final TicketService ticketService;
    private final AccountService accountService;

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(String id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot found invoice"));
    }

    @Override
    public List<Invoice> findByAccountId(String accountId) {
        return invoiceRepository.findByAccountId(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot found invoices"));
    }

    @Override
    public List<Invoice> findByAccountName(String accountName) {
        Account account = accountService.findByUsername(accountName);
        return invoiceRepository.findByAccount(account)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot found invoices"));
    }

    /**
     * Confirm invoice from InvoiceConfirmReq return Invoice
     * @param req
     * @return Invoice
     */
    @Override
    @Transactional
    public Invoice confirmInvoice(InvoiceConfirmReq req, String username) {
        Invoice invoice = new Invoice();
        Account account = accountService.findByUsername(username);
        Member member = memberService.findByAccount(account);
        Movie movie = movieService.findById(req.getMovieId());
        ShowDate showDate = showDateService.findById(req.getShowTimeId());
        Schedule schedule = scheduleService.findById(req.getScheduleId());
        List<ScheduleSeat> scheduleSeats = scheduleSeatService.getScheduleSeatChangedStatus(req.getMovieId(), req.getShowTimeId(), req.getScheduleId(), req.getSeatNamesString());

        invoice.setAccount(account);
        invoice.setAddScore(req.getAddScore());
        invoice.setBookingDate(LocalDate.now());
        invoice.setMovieName(movie.getMovieNameVn());
        invoice.setScheduleShow(showDate.getShowDate());
        invoice.setScheduleShowTime(schedule.getScheduleTime().toString());
        invoice.setStatus(0);
        invoice.setSeat(req.getSeatNamesString());

        int total = 0;
        for (ScheduleSeat scheduleSeat : scheduleSeats) {
            Ticket ticket = ticketService.findByType(scheduleSeat.getSeatType());
            total += ticket.getPrice();
        }

        invoice.setTotalMoney(total);
        invoice.setAddScore(req.getAddScore());

        if (!req.getIsUseScore()) {
            invoice.setUseScore(0);
            member.setScore(member.getScore() + req.getAddScore());
            memberService.save(member);
        } else {
            if (member.getScore() < total)
                throw new NotEnoughMoneyException("Not enough money");
            else {
                invoice.setUseScore(member.getScore());
                member.setScore(member.getScore() + req.getAddScore() - member.getScore());
                memberService.save(member);
            }
        }

        return invoiceRepository.save(invoice);
    }
}
