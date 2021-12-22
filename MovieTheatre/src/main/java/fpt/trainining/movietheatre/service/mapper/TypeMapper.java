package fpt.trainining.movietheatre.service.mapper;

import fpt.trainining.movietheatre.dto.type.TypeRequest;
import fpt.trainining.movietheatre.dto.type.TypeResponse;
import fpt.trainining.movietheatre.entity.Type;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TypeMapper {
    private final ModelMapper mapper;

    public Type map(TypeRequest request) {
        return mapper.map(request, Type.class);
    }

    public TypeResponse map(Type type) {
        return mapper.map(type, TypeResponse.class);
    }

    public void map(TypeRequest request, Type type) {
        mapper.map(request, type);
    }
}
