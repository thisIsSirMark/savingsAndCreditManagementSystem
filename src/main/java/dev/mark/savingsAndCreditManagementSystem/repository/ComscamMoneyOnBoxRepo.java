package dev.mark.savingsAndCreditManagementSystem.repository;

import dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface.MoneyOnBoxRepository;
import dev.mark.savingsAndCreditManagementSystem.model.ComscamMoneyOnBoxRecord;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ComscamMoneyOnBoxRepo extends MoneyOnBoxRepository<ComscamMoneyOnBoxRecord> {
    String updateMoneyInBox = "UPDATE ComscamMoneyOnBoxRecord m SET ";


    @Override
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(updateMoneyInBox + " m.totalSavingsAmount = :amount, m.date = LOCALTIMESTAMP() WHERE m.id = :id")
    Integer updateTotalSavingsAmount(@Param(value = "amount") double amount,@Param(value = "id") long id);
    @Override
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(updateMoneyInBox + " m.totalSocialFundsAmount = :amount, m.date = LOCALTIMESTAMP() WHERE m.id = :id")
    Integer updateTotalSocialFundsAmount(@Param(value = "amount") double amount, @Param(value = "id") long id);
    @Override
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(updateMoneyInBox + " m.totalBorrowedAmount = :amount, m.date = LOCALTIMESTAMP() WHERE m.id = :id")
    Integer updateTotalBorrowedAmount(@Param(value = "amount") double amount,@Param(value = "id") long id);
    @Override
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(updateMoneyInBox + " m.totalMoneyInBox = :amount, m.date = LOCALTIMESTAMP() WHERE m.id = :id")
    Integer updateTotalMoneyInBox(@Param(value = "amount") double amount,@Param(value = "id") long id);
}
