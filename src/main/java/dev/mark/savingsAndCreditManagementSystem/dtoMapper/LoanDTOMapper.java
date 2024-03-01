package dev.mark.savingsAndCreditManagementSystem.dtoMapper;

import dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel.Loan;
import dev.mark.savingsAndCreditManagementSystem.dto.loanDTOs.ComscamLoanRecordDTO;
import dev.mark.savingsAndCreditManagementSystem.dto.loanDTOs.MakeLoanServiceRequestDTO;
import dev.mark.savingsAndCreditManagementSystem.model.ComscamLoanRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoanDTOMapper {

    @Mapping(target = "memberId", expression = "java(getMemberId(loan))")
    MakeLoanServiceRequestDTO toMakeLoanServiceRequestDTO(Loan loan);

    @Mapping(target = "memberId", expression = "java(getMemberId(loan))")
    @Mapping(target = "fullName", expression = "java(getFullName(loan))")
    ComscamLoanRecordDTO toComscamLoanRecordDTO(Loan loan);

    List<ComscamLoanRecordDTO> toComscamLoanRecordDTOList(List<ComscamLoanRecord> loanList);

    default String getFullName(Loan loan){
        return loan.getMember().getFirstName() + " " + loan.getMember().getLastName();
    }
    default long getMemberId(Loan loan){
        return loan.getMember().getMemberId();
    }



}
