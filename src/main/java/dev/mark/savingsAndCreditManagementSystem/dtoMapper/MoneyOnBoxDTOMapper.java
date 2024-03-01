package dev.mark.savingsAndCreditManagementSystem.dtoMapper;

import dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel.MoneyOnBox;
import dev.mark.savingsAndCreditManagementSystem.dto.moneyOnBoxDTOs.MoneyOnBoxRecordDTO;
import dev.mark.savingsAndCreditManagementSystem.model.ComscamMoneyOnBoxRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MoneyOnBoxDTOMapper {

    MoneyOnBoxRecordDTO toMoneyOnBoxRecordDTO(ComscamMoneyOnBoxRecord moneyOnBox);

}
