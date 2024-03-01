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
public abstract class MoneyOnBox {
    @Id
    @SequenceGenerator(
            name = "total_money_in_box_rec_sequence",
            sequenceName = "total_money_in_box_rec_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "total_money_in_box_rec_sequence"
    )
    private Long id;
    private double totalSavingsAmount;
    private double totalSocialFundsAmount;
    private double totalBorrowedAmount;
    private double totalMoneyInBox;
    private Date date;
}
