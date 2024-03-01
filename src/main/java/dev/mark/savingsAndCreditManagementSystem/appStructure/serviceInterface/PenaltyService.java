package dev.mark.savingsAndCreditManagementSystem.appStructure.serviceInterface;

public interface PenaltyService<PENALTY_TYPE> {

    PENALTY_TYPE createPenalty(String penaltyName, String penaltyDescription, double penaltyAmount);
    void givePenaltyToMember(long memberId, PENALTY_TYPE penaltyType);

}
