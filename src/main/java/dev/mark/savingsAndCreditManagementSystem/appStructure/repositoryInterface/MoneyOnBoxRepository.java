package dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface;

import dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel.MoneyOnBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MoneyOnBoxRepository<T extends MoneyOnBox> extends JpaRepository<T, Long> {
    Integer updateTotalSavingsAmount( double amount, long id);


    Integer updateTotalSocialFundsAmount( double amount, long id);


    Integer updateTotalBorrowedAmount(double amount, long id);


    Integer updateTotalMoneyInBox( double amount, long id);
}
