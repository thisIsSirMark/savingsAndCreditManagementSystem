package dev.mark.savingsAndCreditManagementSystem.appStructure.serviceInterface;

public interface ServiceInterface<REQUEST_DTO, DTO, MEMBER> {

    REQUEST_DTO requestService(MEMBER member, double amount);

    boolean verifyRequest(REQUEST_DTO requestDto);

    DTO saveRequest(REQUEST_DTO requestDto);

    Integer updateDatabase(REQUEST_DTO requestDto);

}
