package dev.mark.savingsAndCreditManagementSystem.repository;

import dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface.AppSettingsRepository;
import dev.mark.savingsAndCreditManagementSystem.model.SavingsAndCreditSysAppSettings;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ComscamAppSettingRepo extends AppSettingsRepository<SavingsAndCreditSysAppSettings> {

    String updateSavingsAndCreditSysAppSettings = " UPDATE SavingsAndCreditSysAppSettings appSettings SET";

    @Override
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(updateSavingsAndCreditSysAppSettings + " appSettings.maxNumberOfUnpaidLoan = :maxNumberOfUnpaidLoan WHERE appSettings.id = :id ")
    Integer updateMaxNumberOfUnpaidLoan(@Param(value = "maxNumberOfUnpaidLoan") int maxNumberOfUnpaidLoan, @Param(value = "id") long id);
    @Override
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(updateSavingsAndCreditSysAppSettings + " appSettings.interestRate = :interestRate WHERE appSettings.id = :id ")
    Integer updateLoanInterestRate(@Param(value = "interestRate") double interestRate, @Param(value = "id") long id);
    @Override
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(updateSavingsAndCreditSysAppSettings + " appSettings.maxHulog = :maxHulog WHERE appSettings.id = :id ")
    Integer updateMaxHulog(@Param(value = "maxHulog") double maxHulog, @Param(value = "id") long id);
    @Override
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(updateSavingsAndCreditSysAppSettings + " appSettings.minHulog = :minHulog WHERE appSettings.id = :id ")
    Integer updateMinHulog(@Param(value = "minHulog") double minHulog, @Param(value = "id") long id);
    @Override
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(updateSavingsAndCreditSysAppSettings + " appSettings.pageNumber = :pageNumber, appSettings.pageSize = :pageSize WHERE appSettings.id = :id ")
    Integer updatePageReturnResultPageNumberAndPageSize(@Param(value = "pageNumber") int pageNumber,@Param(value = "pageSize") int pageSize, @Param(value = "id") long id);
}
