package dev.mark.savingsAndCreditManagementSystem.appStructure.abstractModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Penalty {

    @Id
    @SequenceGenerator(
            name = "penalty_record_sequence",
            sequenceName = "penalty_record_sequence",
            allocationSize = 1,
            initialValue = 1001
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "penalty_record_sequence"
    )
    private Long penaltyRecordId;

    @ManyToMany(
            cascade = CascadeType.DETACH
    )
    @JoinTable(
            name = "member_penalty_record",
            joinColumns = @JoinColumn(
                    name = "penalty_record_id",
                    referencedColumnName = "penaltyRecordId"),
            inverseJoinColumns = @JoinColumn(
                    name = "member_id",
                    referencedColumnName = "memberId"))
    private List<Member> members;
    @ManyToMany(
            cascade = CascadeType.DETACH
    )
    @JoinTable(
            name = "member_penalty_description",
            joinColumns = @JoinColumn(
                    name = "penalty_record_id",
                    referencedColumnName = "penaltyRecordId"),
            inverseJoinColumns = @JoinColumn(
                    name = "penalty_id",
                    referencedColumnName = "penaltyId"))
    private List<PenaltyTypes> penaltyType;
}
