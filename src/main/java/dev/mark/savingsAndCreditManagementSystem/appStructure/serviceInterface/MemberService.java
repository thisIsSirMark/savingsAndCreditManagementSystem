package dev.mark.savingsAndCreditManagementSystem.appStructure.serviceInterface;

public interface MemberService<REGISTRATION_DTO> {
    void addMember(REGISTRATION_DTO registrationDto);
    boolean validateMember(REGISTRATION_DTO registrationDto);
    Integer deactivateMember(long id);




}
