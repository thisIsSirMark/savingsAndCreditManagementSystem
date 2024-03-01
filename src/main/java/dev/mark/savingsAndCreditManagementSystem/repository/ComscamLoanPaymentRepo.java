package dev.mark.savingsAndCreditManagementSystem.repository;

import dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface.LoanPaymentRepository;

import dev.mark.savingsAndCreditManagementSystem.model.ComscamLoanPaymentRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface ComscamLoanPaymentRepo extends LoanPaymentRepository<ComscamLoanPaymentRecord> {
}
