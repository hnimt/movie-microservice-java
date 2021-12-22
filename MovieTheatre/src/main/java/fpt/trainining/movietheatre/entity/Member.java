package fpt.trainining.movietheatre.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Data
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "member_id",length = 10)
    @GeneratedValue(generator = "member-generator")
    @GenericGenerator(
            name = "member-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "MEM"),
            strategy = "fpt.trainining.movietheatre.generator.MyGenerator"
    )
    private String memberId;

    @Column(length = 10)
    private Integer score;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @PrePersist
    void preInsert() {
        if (this.score == null) {
            this.score = 0;
        }
    }
}
