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
public abstract class LoanPayment {

    @Id
    @SequenceGenerator(
            name = "loan_payment_record_sequence",
            sequenceName = "loan_payment_record_sequence",
            allocationSize = 1,
            initialValue = 1001
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "loan_payment_record_sequence"
    )
    private Long loanPaymentId;
    private double loanBalance;
    private double loanPaymentAmount;
    private double interestOfLoanBalance;
    private Date dateOfPayment;
    private double newLoanBalance;

    @ManyToOne(
            cascade = CascadeType.DETACH
    )
    @JoinColumn(
            name = "loan_id",
            referencedColumnName = "loanId"
    )
    private Loan loanRecord;

}
