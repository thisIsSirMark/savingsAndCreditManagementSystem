package dev.mark.savingsAndCreditManagementSystem.model;

import dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel.Member;
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
@Table(name = "comscam_member")
public class ComscamMember extends Member {

}
