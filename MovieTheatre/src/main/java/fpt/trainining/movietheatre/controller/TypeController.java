package fpt.trainining.movietheatre.controller;

import fpt.trainining.movietheatre.dto.ResponseHandler;
import fpt.trainining.movietheatre.dto.type.TypeRequest;
import fpt.trainining.movietheatre.dto.type.TypeResponse;
import fpt.trainining.movietheatre.service.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/type")
@AllArgsConstructor
public class TypeController {
    private final TypeService service;

    @GetMapping("/get")
    public ResponseEntity<List<TypeResponse>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<TypeResponse> getByTypeName(@PathVariable String name) {
        return service.getByTypeName(name);
    }

    @GetMapping("/get-type-contains/{string}")
    public ResponseEntity<List<TypeResponse>> getTypeContains(@PathVariable String string) {
        return service.getTypeContains(string);
    }

    @PostMapping("/create")
    public ResponseEntity<TypeResponse> create(@RequestBody @Valid TypeRequest request) {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TypeResponse> update(@PathVariable Integer id, @RequestBody @Valid TypeRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity remove(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseHandler.generateResponse("Delete type successfully", HttpStatus.OK, null);
    }
}
