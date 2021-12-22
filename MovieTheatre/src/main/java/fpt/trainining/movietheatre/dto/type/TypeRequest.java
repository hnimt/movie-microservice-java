package fpt.trainining.movietheatre.dto.type;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TypeRequest {

    @NotBlank
    private String typeName;
}
