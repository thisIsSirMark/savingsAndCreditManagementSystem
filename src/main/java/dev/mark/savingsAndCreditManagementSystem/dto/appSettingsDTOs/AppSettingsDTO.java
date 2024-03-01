package dev.mark.savingsAndCreditManagementSystem.dto.appSettingsDTOs;

public record AppSettingsDTO(
        long id,
        double interestRate,
        double minHulog,
        double maxHulog,
        int maxNumberOfUnpaidLoan,
        int pageNumber,
        int pageSize
) {
}
