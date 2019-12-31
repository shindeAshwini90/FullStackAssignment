package com.yash.assignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.assignment.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

	Project findByProjectIdentifier(String identifier);
	
	@Override
	Iterable<Project> findAll();
	
	//Project updateProjectByIdentifier(Project project);
}
