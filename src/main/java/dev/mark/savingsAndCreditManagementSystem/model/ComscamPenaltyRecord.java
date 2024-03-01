package dev.mark.savingsAndCreditManagementSystem.model;

import dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel.Penalty;
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
@Table(name = "member_penalty_record")
public class ComscamPenaltyRecord extends Penalty {

}
