package fpt.trainining.movietheatre.service.impl;

import fpt.trainining.movietheatre.dto.seat.SeatIdReq;
import fpt.trainining.movietheatre.dto.seat.SeatReq;
import fpt.trainining.movietheatre.dto.seat.SeatRes;
import fpt.trainining.movietheatre.entity.Seat;
import fpt.trainining.movietheatre.exception.ResourceNotFoundException;
import fpt.trainining.movietheatre.repository.SeatRepository;
import fpt.trainining.movietheatre.service.SeatService;
import fpt.trainining.movietheatre.service.mapper.SeatMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.aspectj.util.LangUtil.split;

@Service
@AllArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatMapper mapper;
    private final SeatRepository repository;

    @Override
    public Seat findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find seat with id = " + id));
    }

    @Override
    public List<Integer> findIdBySeatName(String seatNames) {
        String[] seatNameArray = seatNames.split(" ");
        List<Integer> idList = new ArrayList<>();

        for (String seatName : seatNameArray) {
            Integer row = Integer.parseInt(seatName.substring(0, seatName.length() - 1));
            String column = seatName.substring(seatName.length() - 1);
            System.out.println("row = " + row + " column = " + column);

            Seat seat = repository.findSeatBySeatRowAndSeatColumn(row, column)
                    .orElseThrow(() -> new ResourceNotFoundException("Cannot find"));

            idList.add(seat.getSeatId());
        }

        return idList;
    }

    @Override
    public ResponseEntity<List<SeatRes>> getAll() {
        List<Seat> seats = repository.findAll();

        List<SeatRes> seatRes = seats.stream()
                .map(mapper::map)
                .collect(Collectors.toList());

        return ResponseEntity.ok(seatRes);
    }

    @Override
    public ResponseEntity<SeatRes> create(SeatReq req) {
        Seat seat = mapper.map(req);

        repository.save(seat);

        return ResponseEntity.ok(mapper.map(seat));
    }

    @Override
    public ResponseEntity<SeatRes> changeType(SeatIdReq req) {
        Seat seat = mapper.map(req);
        seat.setSeatType(1 - seat.getSeatType());

        repository.save(seat);

        return ResponseEntity.ok(mapper.map(seat));
    }

    @Override
    public ResponseEntity<SeatRes> changeStatus(SeatIdReq req) {
        Seat seat = mapper.map(req);
        seat.setSeatStatus(1 - seat.getSeatStatus());

        repository.save(seat);

        return ResponseEntity.ok(mapper.map(seat));
    }

    @Override
    public Seat changeStatus(Integer id) {
        Seat seat = findById(id);

        seat.setSeatStatus(1 - seat.getSeatStatus());
        repository.save(seat);

        return seat;
    }

    @Override
    public ResponseEntity delete(Integer seatId) {
        repository.deleteById(seatId);
        return ResponseEntity.ok("delete successfully");
    }
}
