package com.erixrivas.springBootRESTfulApiPractice.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erixrivas.springBootRESTfulApiPractice.persistence.entity.TeamMember;
import com.erixrivas.springBootRESTfulApiPractice.persistence.service.TeamMemberService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/drop SCHEMA public;")
public class TeamMemberController {
	
	
	 @Autowired
	    private TeamMemberService teamMemberService;

	
	   @GetMapping("/all")
	    @ApiOperation("Get all  TeamMembers")
	    @ApiResponse(code = 200, message = "OK")
	    public ResponseEntity<List<TeamMember>> getAll() {
	        return new ResponseEntity<>(teamMemberService.getAll(), HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    @ApiOperation("Search a TeamMember with an ID")
	    @ApiResponses({
	            @ApiResponse(code = 200, message = "OK"),
	            @ApiResponse(code = 404, message = "TeamMember not found"),
	    })
	    public ResponseEntity<TeamMember> getTeamMember(@ApiParam(value = "The id of the TeamMember", required = true, example = "7")
	                                                  @PathVariable("id") Integer TeamMemberId) {
	     Optional<TeamMember> value = teamMemberService.findByID(TeamMemberId);
	     ResponseEntity<TeamMember> responseEntity=new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     
	    if( value.isPresent())
	     
	     
	    {
	     responseEntity= new ResponseEntity<>(value.get(), HttpStatus.OK);}		 
	      
			return responseEntity;		 
	    }

	    @GetMapping("/skill/{skillId}")
	    public ResponseEntity<List<TeamMember>> getBySkill(@PathVariable("skillId") Integer categoryId) {
	       
	    	ResponseEntity responseEntity=new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	
	    	
	    	
	    	List<TeamMember> teamMembers= teamMemberService.getBySkillId(categoryId);
	    	if (!teamMembers.isEmpty())
	    		return new ResponseEntity<>(teamMembers, HttpStatus.OK);
	    
	    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @PostMapping("/save")
	    public ResponseEntity<TeamMember> save(@RequestBody TeamMember TeamMember) {
	        return new ResponseEntity<>(teamMemberService.save(TeamMember), HttpStatus.CREATED);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity delete(@PathVariable("id") Integer TeamMemberId) {
	        if (teamMemberService.delete(teamMemberService.findByID(TeamMemberId).get())) {
	            return new ResponseEntity(HttpStatus.OK);
	        } else {
	            return new ResponseEntity(HttpStatus.NOT_FOUND);
	        }
	    }
}
