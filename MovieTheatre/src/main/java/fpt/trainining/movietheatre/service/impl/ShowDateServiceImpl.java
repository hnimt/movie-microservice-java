package fpt.trainining.movietheatre.service.impl;

import fpt.trainining.movietheatre.dto.show_date.ShowDateRequest;
import fpt.trainining.movietheatre.dto.show_date.ShowDateResponse;
import fpt.trainining.movietheatre.entity.ShowDate;
import fpt.trainining.movietheatre.exception.ResourceNotFoundException;
import fpt.trainining.movietheatre.repository.ShowDateRepository;
import fpt.trainining.movietheatre.service.ShowDateService;
import fpt.trainining.movietheatre.service.mapper.ShowDateMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShowDateServiceImpl implements ShowDateService {
    private final ShowDateMapper mapper;
    private final ShowDateRepository repository;

    private ShowDate findByDate(LocalDate date) {
        return repository.findShowDateByShowDate(date)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find show date with date = " + date));
    }

    @Override
    public ResponseEntity<List<ShowDateResponse>> getAll() {
        List<ShowDate> showDates = repository.findAll();

        List<ShowDateResponse> responses = showDates.stream()
                .map(mapper::map)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<ShowDateResponse> getByDate(LocalDate date) {
        return ResponseEntity.ok(mapper.map(findByDate(date)));
    }

    @Override
    public ResponseEntity<ShowDateResponse> create(ShowDateRequest request) {
        ShowDate showDate = mapper.map(request);

        repository.save(showDate);

        return ResponseEntity.ok(mapper.map(showDate));
    }

    @Override
    public ShowDate findById(Integer showDateId) {
        return repository.findById(showDateId)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot found show date"));
    }
}
