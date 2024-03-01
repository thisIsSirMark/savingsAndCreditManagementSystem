package dev.mark.savingsAndCreditManagementSystem.model;

import dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel.LoanPayment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "loan_payment_record")
public class ComscamLoanPaymentRecord extends LoanPayment {

}
