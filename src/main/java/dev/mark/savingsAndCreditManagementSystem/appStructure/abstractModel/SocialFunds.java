package dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class SocialFunds {

    @Id
    @SequenceGenerator(
            name = "social_funds_sequence",
            sequenceName = "social_funds_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "social_funds_sequence"
    )
    private Long socFundsId;
    private double totalSocFunds;
    private Date asOf;

}
