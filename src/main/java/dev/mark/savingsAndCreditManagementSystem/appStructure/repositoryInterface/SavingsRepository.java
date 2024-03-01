package dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface;

import dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SavingsRepository<T extends Savings> extends JpaRepository<T, Long> {
}
