package dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface;

import dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel.PenaltyTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PenaltyTypesRepository<T extends PenaltyTypes> extends JpaRepository<T, Long> {
}
