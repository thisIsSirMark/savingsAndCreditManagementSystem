package dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface;

import dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel.AppSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AppSettingsRepository<T extends AppSettings> extends JpaRepository<T, Long> {

    Integer updateMaxNumberOfUnpaidLoan(int maxNumber, long id);
    Integer updateLoanInterestRate(double interestRate, long id);
    Integer updateMaxHulog(double maxHulog, long id);
    Integer updateMinHulog(double hulog, long id);
    Integer updatePageReturnResultPageNumberAndPageSize(int pageNumber, int pageSize, long id);
}
