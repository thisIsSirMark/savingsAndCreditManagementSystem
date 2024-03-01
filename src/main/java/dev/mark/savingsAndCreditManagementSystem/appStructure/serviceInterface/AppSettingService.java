package dev.mark.savingsAndCreditManagementSystem.appStructure.serviceInterface;

public interface AppSettingService<APP_SERVICE_DTO> {

    APP_SERVICE_DTO getAppSettings();
    Integer updateMaxNumberOfUnpaidLoan(int maxNumber);
    Integer updateLoanInterestRate(double interestRate);
    Integer updateMxHulog(double maxHulog);
    Integer updateMinHulog(double hulog);
    Integer updatePageReturnResultPageNumberAndPageSize(int pageNumber, int pageSize);

}
