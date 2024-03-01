package dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PenaltyTypes {

    @Id
    @SequenceGenerator(
            name = "saving_record_sequence",
            sequenceName = "saving_record_sequence",
            allocationSize = 1,
            initialValue = 1001
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "saving_record_sequence"
    )
    private Long penaltyId;
    private String penaltyDescription;
    private double penaltyAmount;
}
