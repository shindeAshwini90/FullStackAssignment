package com.yash.assignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.assignment.domain.Project;
import com.yash.assignment.exception.ProjectIdException;
import com.yash.assignment.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		try {
		return projectRepository.save(project);
		}catch (Exception e) {
			throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
		}
	}
	
	public Project findByProjectIdentifier(String identifier) {
		Project project = projectRepository.findByProjectIdentifier(identifier);
		if(project == null) {
			throw new ProjectIdException("Project ID '"+identifier+"' does not exists");
		}
		return project;
	}
	
	public Iterable<Project> findAllProjects(){
		return projectRepository.findAll();
	}
	
	public Project updateProjectByIdentifier(Project project){
		Project dbProject = projectRepository.findByProjectIdentifier(project.getProjectIdentifier());
		if(dbProject==null) {
			throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' does not exists");
		}
		
		dbProject = projectRepository.save(project);
		return dbProject;
	}
}
