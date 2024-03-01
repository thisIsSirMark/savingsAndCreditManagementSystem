package dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface;

import dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel.SocialFundsUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SocialFundsUsageRepository<T extends SocialFundsUsage> extends JpaRepository<T, Long> {
}
