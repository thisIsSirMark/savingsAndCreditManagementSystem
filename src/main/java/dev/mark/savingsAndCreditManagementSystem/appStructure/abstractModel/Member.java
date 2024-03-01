package dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Member {

    @Id
    @SequenceGenerator(
            name = "member_sequence",
            sequenceName = "member_sequence",
            allocationSize = 1,
            initialValue = 1001
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_sequence"
    )
    private Long memberId;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String role;


    @Autowired
    private Date dateOfBirth;

    @Transient
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private int age;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "savings_id",
            referencedColumnName = "savingsId"
    )
    private Savings savingRecord;

    public int getAge() {
        return Period.between(getDateOfBirth().toLocalDate(), LocalDate.now()).getYears();
    }


}
