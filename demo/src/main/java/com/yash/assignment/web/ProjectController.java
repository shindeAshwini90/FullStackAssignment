package com.yash.assignment.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.assignment.domain.Project;
import com.yash.assignment.services.MapValidationService;
import com.yash.assignment.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@Autowired
	private MapValidationService mapErrorValidation;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {
		ResponseEntity<Map<String, String>> errorResponse = mapErrorValidation.mapValidationService(result);
		if (errorResponse != null) {
			return errorResponse;
		}
		Project project1 = projectService.saveOrUpdateProject(project);
		return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
	}

	@GetMapping("/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable String projectId) {
		Project project = projectService.findByProjectIdentifier(projectId);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}

	@GetMapping("/all")
	public Iterable<Project> getAllProjects() {
		return projectService.findAllProjects();
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateExistingProject(@RequestBody Project project) {
		/*
		 * ResponseEntity<Map<String, String>> errorResponse =
		 * mapErrorValidation.mapValidationService(result); if (errorResponse != null) {
		 * return errorResponse; }
		 */
		Project project1 = projectService.saveOrUpdateProject(project);
		return new ResponseEntity<Project>(project1, HttpStatus.OK);
	}
}
