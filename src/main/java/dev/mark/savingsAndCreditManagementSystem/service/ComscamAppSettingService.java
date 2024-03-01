package dev.mark.savingsAndCreditManagementSystem.service;

import dev.mark.savingsAndCreditManagementSystem.appStructure.serviceInterface.AppSettingService;
import dev.mark.savingsAndCreditManagementSystem.dto.appSettingsDTOs.AppSettingsDTO;
import dev.mark.savingsAndCreditManagementSystem.dtoMapper.AppSettingsDTOMapper;
import dev.mark.savingsAndCreditManagementSystem.model.SavingsAndCreditSysAppSettings;
import dev.mark.savingsAndCreditManagementSystem.repository.ComscamAppSettingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComscamAppSettingService implements AppSettingService<AppSettingsDTO> {

    private final ComscamAppSettingRepo comscamAppSettingRepo;
    private final AppSettingsDTOMapper appSettingsDTOMapper;

    private AppSettingsDTO appSettingsDTO;

    @Override
    public AppSettingsDTO getAppSettings() {
        if (appSettingsDTO == null) {
            return appSettingsDTO = appSettingsDTOMapper.toAppSettingsDTO(comscamAppSettingRepo.findById(getIdAppSettingsRecord()).orElseThrow());
        }
        return appSettingsDTO;
    }

    @Override
    public Integer updateMaxNumberOfUnpaidLoan(int maxNumber) {
        return comscamAppSettingRepo.updateMaxNumberOfUnpaidLoan(maxNumber, getAppSettings().id());
    }

    @Override
    public Integer updateLoanInterestRate(double interestRate) {
        return comscamAppSettingRepo.updateLoanInterestRate(interestRate,getAppSettings().id());
    }

    @Override
    public Integer updateMxHulog(double maxHulog) {
        return comscamAppSettingRepo.updateMaxHulog(maxHulog,getAppSettings().id());
    }

    @Override
    public Integer updateMinHulog(double hulog) {
        return comscamAppSettingRepo.updateMinHulog(hulog,getAppSettings().id());
    }

    @Override
    public Integer updatePageReturnResultPageNumberAndPageSize(int pageNumber, int pageSize) {
        return comscamAppSettingRepo.updatePageReturnResultPageNumberAndPageSize(pageNumber,pageSize,getAppSettings().id());
    }

    public boolean checkIfAppSettingsExistInDB() {
        return comscamAppSettingRepo.findAll().isEmpty();
    }

    public void createMoneyOnBoxRecordOnDB() {
        var AppSettingsDoesNotExistInDB = checkIfAppSettingsExistInDB();

        if (AppSettingsDoesNotExistInDB) {
            var freshRecord = SavingsAndCreditSysAppSettings.builder().build();
            comscamAppSettingRepo.save(freshRecord);
        }
    }

    public long getIdAppSettingsRecord() {
        createMoneyOnBoxRecordOnDB();
        var moneyOnBoxRepositoryList = comscamAppSettingRepo.findAll();
        var size = moneyOnBoxRepositoryList.size();

        if (size > 1) {
            comscamAppSettingRepo.deleteAll();
            return getIdAppSettingsRecord();
        }
        return moneyOnBoxRepositoryList.stream().findFirst().orElseThrow().getId();
    }
}
