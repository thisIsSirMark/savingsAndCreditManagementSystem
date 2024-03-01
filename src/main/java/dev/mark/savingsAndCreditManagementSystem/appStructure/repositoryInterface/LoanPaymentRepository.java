package dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface;

import dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel.LoanPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface LoanPaymentRepository<T extends LoanPayment> extends JpaRepository<T, Long> {
}
