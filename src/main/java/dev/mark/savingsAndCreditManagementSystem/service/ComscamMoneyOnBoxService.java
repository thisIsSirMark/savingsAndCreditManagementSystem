package dev.mark.savingsAndCreditManagementSystem.service;

import dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface.MoneyOnBoxRepository;
import dev.mark.savingsAndCreditManagementSystem.appStructure.serviceInterface.MoneyOnBoxService;
import dev.mark.savingsAndCreditManagementSystem.dto.moneyOnBoxDTOs.MoneyOnBoxRecordDTO;
import dev.mark.savingsAndCreditManagementSystem.dtoMapper.MoneyOnBoxDTOMapper;
import dev.mark.savingsAndCreditManagementSystem.model.ComscamMoneyOnBoxRecord;
import dev.mark.savingsAndCreditManagementSystem.repository.ComscamMoneyOnBoxRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComscamMoneyOnBoxService implements MoneyOnBoxService<MoneyOnBoxRecordDTO> {

    private final ComscamMoneyOnBoxRepo comscamMoneyOnBoxRepo;
    private final MoneyOnBoxDTOMapper moneyOnBoxDTOMapper;
    private final Date currentDate;

    private MoneyOnBoxRecordDTO moneyOnBoxRecordDTO;

    @Override
    public MoneyOnBoxRecordDTO getMoneyOnBoxRecord() {
        if (moneyOnBoxRecordDTO==null){
        ComscamMoneyOnBoxRecord comscamMoneyOnBoxRecord = comscamMoneyOnBoxRepo.findById(getIdMoneyOnBoxRecord()).orElseThrow();
        return moneyOnBoxRecordDTO = moneyOnBoxDTOMapper.toMoneyOnBoxRecordDTO(comscamMoneyOnBoxRecord);
        }
        return moneyOnBoxRecordDTO;
    }

    @Override
    public Integer updateTotalReadyMoneyOnBoxRecord(double amount) {
        return comscamMoneyOnBoxRepo.updateTotalMoneyInBox(amount, getIdMoneyOnBoxRecord());
    }

    @Override
    public Integer updateTotalBorrowedMoneyOnBoxRecord(double amount, boolean loan) {
        return comscamMoneyOnBoxRepo.updateTotalBorrowedAmount(amount, getIdMoneyOnBoxRecord());
    }

    @Override
    public Integer updateTotalSavingsMoneyOnBoxRecord(double amount, boolean saveMoney) {
        return comscamMoneyOnBoxRepo.updateTotalSavingsAmount(amount, getIdMoneyOnBoxRecord());
    }

    @Override
    public Integer updateTotalSocialFundsMoneyOnBoxRecord(double amount, boolean usedSocialFunds) {
        return comscamMoneyOnBoxRepo.updateTotalSocialFundsAmount(amount, getIdMoneyOnBoxRecord());
    }

    public boolean checkIfMoneyOnBoxRecordExistInDB(){
        return comscamMoneyOnBoxRepo.findAll().isEmpty();
    }
    public void createMoneyOnBoxRecordOnDB(){
        var size = checkIfMoneyOnBoxRecordExistInDB();
        if (size){
            var record = ComscamMoneyOnBoxRecord.builder().date(currentDate).build();
            comscamMoneyOnBoxRepo.save(record);
        }
    }

    public long getIdMoneyOnBoxRecord(){
        createMoneyOnBoxRecordOnDB();
        var moneyOnBoxRepositoryList = comscamMoneyOnBoxRepo.findAll();
        var size = moneyOnBoxRepositoryList.size();

        if (size==1){
            Optional<ComscamMoneyOnBoxRecord> moneyOnBoxRecord = moneyOnBoxRepositoryList.stream().findFirst();
            return moneyOnBoxRecord.orElseThrow().getId();
        }
        Pageable pageable = PageRequest.of(0,10, Sort.Direction.DESC, "date");
        var currentMoneyInBoxRecord = comscamMoneyOnBoxRepo.findAll(pageable).stream().findFirst();
        return currentMoneyInBoxRecord.orElseThrow().getId();
    }

}
