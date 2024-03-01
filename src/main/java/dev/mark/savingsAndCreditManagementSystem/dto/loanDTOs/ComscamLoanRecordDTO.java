package dev.mark.savingsAndCreditManagementSystem.dto.loanDTOs;

import java.util.Date;
public record ComscamLoanRecordDTO(long memberId, String fullName, long loanId, double loanAmount, Date loanDate, double loanBalance, boolean loanPaymentIsClear, Date datePaid) {
}
