package fpt.trainining.movietheatre.service.impl;

import fpt.trainining.movietheatre.dto.type.TypeRequest;
import fpt.trainining.movietheatre.dto.type.TypeResponse;
import fpt.trainining.movietheatre.entity.Type;
import fpt.trainining.movietheatre.exception.ResourceNotFoundException;
import fpt.trainining.movietheatre.repository.TypeRepository;
import fpt.trainining.movietheatre.service.TypeService;
import fpt.trainining.movietheatre.service.mapper.TypeMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TypeServiceImpl implements TypeService {
    private final TypeMapper mapper;
    private final TypeRepository repository;

    private Type findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find type with id = " + id));
    }

    private Type findByTypeName(String typeName) {
        return repository.findTypeByTypeName(typeName)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find type with name = " + typeName));
    }

    private List<Type> findTypeContains(String string) {
        return repository.findTypeContains(string)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find type with name containing = " + string));
    }

    @Override
    public ResponseEntity<List<TypeResponse>> getAll() {
        List<Type> types = repository.findAll();

        List<TypeResponse> typeResponses = types.stream()
                .map(mapper::map)
                .collect(Collectors.toList());

        return ResponseEntity.ok(typeResponses);
    }

    @Override
    public ResponseEntity<TypeResponse> getByTypeName(String typeName) {
        return ResponseEntity.ok(mapper.map(findByTypeName(typeName)));
    }

    @Override
    public ResponseEntity<List<TypeResponse>> getTypeContains(String string) {
        return ResponseEntity.ok(
                findTypeContains(string).stream()
                        .map(mapper::map)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<TypeResponse> create(TypeRequest request) {
        Type type = mapper.map(request);

        repository.save(type);

        return ResponseEntity.ok(mapper.map(type));
    }

    @Override
    public ResponseEntity<TypeResponse> update(Integer id, TypeRequest request) {
        Type type = findById(id);
        mapper.map(request, type);
        repository.save(type);
        return ResponseEntity.ok(mapper.map(type));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
