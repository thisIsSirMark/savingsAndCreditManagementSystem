package dev.mark.savingsAndCreditManagementSystem.appStructure.serviceInterface;

public interface MoneyOnBoxService<MONEY_IN_BOX_DTO> {

    MONEY_IN_BOX_DTO getMoneyOnBoxRecord();
    Integer updateTotalReadyMoneyOnBoxRecord(double amount);
    Integer updateTotalBorrowedMoneyOnBoxRecord(double amount, boolean loan);
    Integer updateTotalSavingsMoneyOnBoxRecord(double amount, boolean saveMoney);
    Integer updateTotalSocialFundsMoneyOnBoxRecord(double amount, boolean usedSocialFunds);


}
