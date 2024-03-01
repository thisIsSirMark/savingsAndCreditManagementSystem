package dev.mark.savingsAndCreditManagementSystem.model;

import dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel.PenaltyTypes;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "penalty_type_record")
public class ComscamPenaltyTypesRecord extends PenaltyTypes {
}
