package dev.mark.savingsAndCreditManagementSystem.repository;

import dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface.PenaltyTypesRepository;
import dev.mark.savingsAndCreditManagementSystem.model.ComscamPenaltyTypesRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface ComscamPenaltyTypesRepo extends PenaltyTypesRepository<ComscamPenaltyTypesRecord> {
}
