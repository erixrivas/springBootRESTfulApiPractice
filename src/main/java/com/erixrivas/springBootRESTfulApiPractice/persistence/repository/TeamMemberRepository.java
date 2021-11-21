package com.erixrivas.springBootRESTfulApiPractice.persistence.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erixrivas.springBootRESTfulApiPractice.persistence.entity.TeamMember;

public interface TeamMemberRepository  extends JpaRepository<TeamMember ,Integer> {

}
