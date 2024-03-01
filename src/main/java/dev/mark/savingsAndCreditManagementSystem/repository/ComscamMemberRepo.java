package dev.mark.savingsAndCreditManagementSystem.repository;

import dev.mark.savingsAndCreditManagementSystem.appStructure.repositoryInterface.MemberRepository;
import dev.mark.savingsAndCreditManagementSystem.model.ComscamMember;
import org.springframework.stereotype.Repository;

@Repository
public interface ComscamMemberRepo extends MemberRepository<ComscamMember> {
}
