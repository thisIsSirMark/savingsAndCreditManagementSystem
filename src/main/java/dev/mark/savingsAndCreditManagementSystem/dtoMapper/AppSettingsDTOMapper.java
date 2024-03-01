package dev.mark.savingsAndCreditManagementSystem.dtoMapper;

import dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel.AppSettings;
import dev.mark.savingsAndCreditManagementSystem.dto.appSettingsDTOs.AppSettingsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppSettingsDTOMapper {

    AppSettingsDTO toAppSettingsDTO(AppSettings appSettings);
}
