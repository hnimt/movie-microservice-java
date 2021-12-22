package fpt.trainining.movietheatre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "type")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Type {

    @Id
    @Column(length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;

    @Column(unique = true)
    private String typeName;

    @ManyToMany(mappedBy = "types")
    @JsonIgnore
    private Collection<Movie> movies;
}
