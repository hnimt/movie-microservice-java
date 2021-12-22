package fpt.trainining.movietheatre.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket {

    @Id
    @Column(length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    @Column(length = 19)
    private Integer price;

    @Column(length = 1)
    private Integer ticketType;
}
