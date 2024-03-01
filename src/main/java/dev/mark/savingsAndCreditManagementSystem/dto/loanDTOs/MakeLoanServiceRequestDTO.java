package dev.mark.savingsAndCreditManagementSystem.dto.loanDTOs;

import java.util.Date;

public record MakeLoanServiceRequestDTO(
        long memberId,
        double loanAmount,
        Date loanDate,
        double loanBalance,
        boolean loanPaymentIsClear,
        Date datePaid
) {

}
