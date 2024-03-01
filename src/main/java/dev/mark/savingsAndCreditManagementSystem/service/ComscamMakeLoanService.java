package dev.mark.savingsAndCreditManagementSystem.service;

import dev.mark.savingsAndCreditManagementSystem.appStructure.serviceInterface.MakeLoanService;
import dev.mark.savingsAndCreditManagementSystem.dto.loanDTOs.ComscamLoanRecordDTO;
import dev.mark.savingsAndCreditManagementSystem.dto.loanDTOs.MakeLoanServiceRequestDTO;
import dev.mark.savingsAndCreditManagementSystem.dtoMapper.LoanDTOMapper;
import dev.mark.savingsAndCreditManagementSystem.model.ComscamLoanRecord;
import dev.mark.savingsAndCreditManagementSystem.model.ComscamMember;
import dev.mark.savingsAndCreditManagementSystem.repository.ComscamLoanRecordRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComscamMakeLoanService
        implements MakeLoanService<MakeLoanServiceRequestDTO, ComscamLoanRecordDTO, ComscamMember> {

    private final ComscamLoanRecordRepo comscamLoanRecordRepo;
    private final LoanDTOMapper loanDTOMapper;
    private final Date currentDate;
    private final ComscamAppSettingService comscamAppSettingService;

    @Override
    public MakeLoanServiceRequestDTO requestService(ComscamMember comscamMember, double amount) {
        ComscamLoanRecord comscamLoanRecord = ComscamLoanRecord.builder()
                .member(comscamMember)
                .loanAmount(amount)
                .loanDate(currentDate)
                .datePaid(null)
                .loanPaymentIsClear(false)
                .loanBalance(amount)
                .build();
        return loanDTOMapper.toMakeLoanServiceRequestDTO(comscamLoanRecord);
    }

    @Override
    public boolean verifyRequest(MakeLoanServiceRequestDTO makeLoanServiceRequestDTO) {
        return false;
    }

    @Override
    public ComscamLoanRecordDTO saveRequest(MakeLoanServiceRequestDTO makeLoanServiceRequestDTO) {
        return null;
    }

    @Override
    public Integer updateDatabase(MakeLoanServiceRequestDTO makeLoanServiceRequestDTO) {
        return null;
    }


    public Page<ComscamLoanRecord> findAllLoanRecordsPageable(Sort sort){
        int pageNumber = comscamAppSettingService.getAppSettings().pageNumber();
        int pageSize = comscamAppSettingService.getAppSettings().pageSize();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return comscamLoanRecordRepo.findAll(pageable);
    }

    //TODO
    // 0 = dec, 1 = acc
    public void sortByPayedLoan(int decDir){
        switch (decDir){
            case 0 -> {
                return;
            }

        }
    }

    public List<ComscamLoanRecordDTO> getAllComscamLoanRecordByMemberId(
            long memberId, int loanRecordResultPageNumber, int loanRecordResultPageSize) {
        String property = "loanDate";
        Pageable pageable =
                PageRequest.of(loanRecordResultPageNumber,
                        loanRecordResultPageSize,
                        Sort.Direction.DESC,
                        property);
        List<ComscamLoanRecord> comscamLoanRecordList = comscamLoanRecordRepo.findAllByMemberMemberId(memberId, pageable).stream().toList();
        return loanDTOMapper.toComscamLoanRecordDTOList(comscamLoanRecordList);
    }

    public List<ComscamLoanRecordDTO> getAllUnpaidLoanByMemberId(long memberId, int loanRecordResultPageNumber, int loanRecordResultPageSize) {
        return getAllComscamLoanRecordByMemberId(memberId, loanRecordResultPageNumber, loanRecordResultPageSize)
                .stream().filter(comscamLoanRecordDTO -> !comscamLoanRecordDTO.loanPaymentIsClear()).toList();
    }

    public ComscamLoanRecordDTO getLoanRecordByLoanId(long id) {
        var optionalComscamLoanRecord = comscamLoanRecordRepo.findById(id);
        var comscamLoanRecord = optionalComscamLoanRecord.orElseThrow();
        return loanDTOMapper.toComscamLoanRecordDTO(comscamLoanRecord);
    }

    public boolean bypassVerification(boolean bypass) {
        return bypass;
    }


}
