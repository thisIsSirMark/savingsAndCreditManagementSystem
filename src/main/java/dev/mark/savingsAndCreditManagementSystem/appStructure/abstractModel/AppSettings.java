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
public abstract class AppSettings {
    @Id
    @SequenceGenerator(
            name = "app_settings_sequence",
            sequenceName = "app_settings_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "app_settings_sequence"
    )
    private Long id;
    private double interestRate;
    private double minHulog;
    private double maxHulog;
    private int maxNumberOfUnpaidLoan;
    private int pageNumber;
    private int pageSize;
}
