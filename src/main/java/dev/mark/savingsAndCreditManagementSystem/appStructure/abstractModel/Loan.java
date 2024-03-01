package dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Loan {

    @Id
    @SequenceGenerator(
            name = "loan_record_sequence",
            sequenceName = "loan_record_sequence",
            allocationSize = 1,
            initialValue = 1001
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "loan_record_sequence"
    )
    private Long loanId;

    private double loanBalance;
    private double loanAmount;
    private Date loanDate;
    private boolean loanPaymentIsClear;
    private Date datePaid;

    @ManyToOne(
            cascade = CascadeType.DETACH
    )
    @JoinColumn(
            name = "member_id",
            referencedColumnName = "memberId"
    )
    private Member member;
}
