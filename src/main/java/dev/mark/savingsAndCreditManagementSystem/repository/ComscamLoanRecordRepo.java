package dev.mark.savingsAndCreditManagementSystem.repository;

import dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface.LoanRepository;
import dev.mark.savingsAndCreditManagementSystem.model.ComscamLoanRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComscamLoanRecordRepo extends LoanRepository<ComscamLoanRecord> {

    Page<ComscamLoanRecord> findAllByMemberMemberId(long id, Pageable pageable);
}
