package dev.mark.savingsAndCreditManagementSystem.repository;

import dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface.PenaltyRepository;
import dev.mark.savingsAndCreditManagementSystem.model.ComscamPenaltyRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface ComscamPenaltyRepo extends PenaltyRepository<ComscamPenaltyRecord> {
}
