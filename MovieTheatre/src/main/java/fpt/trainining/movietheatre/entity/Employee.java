package fpt.trainining.movietheatre.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @Column(length = 10)
    @GeneratedValue(generator = "employee-generator")
    @GenericGenerator(
            name = "employee-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "EMP"),
            strategy = "fpt.trainining.movietheatre.generator.MyGenerator"
    )
    private String employeeId;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
