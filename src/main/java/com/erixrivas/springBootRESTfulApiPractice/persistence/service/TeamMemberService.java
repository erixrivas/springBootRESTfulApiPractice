package com.erixrivas.springBootRESTfulApiPractice.persistence.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.erixrivas.springBootRESTfulApiPractice.persistence.entity.TeamMember;
import com.erixrivas.springBootRESTfulApiPractice.persistence.repository.TeamMemberRepository;
@Service
public class TeamMemberService implements ICURDSERVICE<TeamMember,Integer > {

	private TeamMemberRepository teamMemberRepository;

	public TeamMemberService(TeamMemberRepository teamMemberRepository) {
		super();
		this.teamMemberRepository = teamMemberRepository;
	}

	@Override
	public JpaRepository<TeamMember ,Integer > getRepository() {
		// TODO Auto-generated method stub
		return teamMemberRepository;
	}

	
	public List<TeamMember>	getBySkillId(Integer id){
		return new ArrayList<TeamMember>();
	}
}
