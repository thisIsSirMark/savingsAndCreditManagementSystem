package dev.mark.savingsAndCreditManagementSystem.repository;

import dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface.SocialFundsRepository;
import dev.mark.savingsAndCreditManagementSystem.model.ComscamSocialFundsRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface ComscamSocialFundsRepo extends SocialFundsRepository<ComscamSocialFundsRecord> {
}
