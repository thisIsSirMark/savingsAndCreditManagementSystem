package dev.mark.savingsAndCreditManagementSystem.repository;

import dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface.SavingsRepository;
import dev.mark.savingsAndCreditManagementSystem.model.ComscamSavingRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface ComscamSavingsRepo extends SavingsRepository<ComscamSavingRecord> {
}
