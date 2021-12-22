package fpt.trainining.movietheatre.service;

import fpt.trainining.movietheatre.dto.invoice.InvoiceConfirmReq;
import fpt.trainining.movietheatre.entity.Account;
import fpt.trainining.movietheatre.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> findAll();
    List<Invoice> findByAccountId(String accountId);
    List<Invoice> findByAccountName(String accountName);
    Invoice findById(String id);
    Invoice confirmInvoice(InvoiceConfirmReq req, String username);
}
