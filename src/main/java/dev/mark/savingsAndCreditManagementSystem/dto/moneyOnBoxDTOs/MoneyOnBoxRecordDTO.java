package dev.mark.savingsAndCreditManagementSystem.dto.moneyOnBoxDTOs;

import java.util.Date;

public record MoneyOnBoxRecordDTO(

        long id,
        double totalSavingsAmount,
        double totalSocialFundsAmount,
        double totalBorrowedAmount,
        double totalMoneyInBox,
        Date date
) {
}
