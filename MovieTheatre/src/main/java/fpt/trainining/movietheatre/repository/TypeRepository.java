package fpt.trainining.movietheatre.repository;

import fpt.trainining.movietheatre.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    Optional<Type> findTypeByTypeName(String typeName);

    @Query("SELECT t FROM Type t WHERE t.typeName LIKE %?1%")
    Optional<List<Type>> findTypeContains(String string);
}
