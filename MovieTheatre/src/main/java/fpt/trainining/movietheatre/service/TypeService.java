package fpt.trainining.movietheatre.service;

import fpt.trainining.movietheatre.dto.type.TypeRequest;
import fpt.trainining.movietheatre.dto.type.TypeResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TypeService {
    ResponseEntity<List<TypeResponse>> getAll();
    ResponseEntity<TypeResponse> getByTypeName(String typeName);
    ResponseEntity<List<TypeResponse>> getTypeContains(String string);
    ResponseEntity<TypeResponse> create(TypeRequest request);
    ResponseEntity<TypeResponse> update(Integer id, TypeRequest request);
    void deleteById(Integer id);
}
