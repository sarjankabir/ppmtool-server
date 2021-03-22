package com.sarjan.ppmtool.services;

import com.sarjan.ppmtool.domain.Project;
import com.sarjan.ppmtool.exceptions.ProjectIdException;
import com.sarjan.ppmtool.exceptions.ProjectIdExceptionResponse;
import com.sarjan.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sarjan Kabir
 */

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }
        catch (Exception e){
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }


    }


    public Project findProjectByIdentifier(String projectId){

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null){
            throw new ProjectIdException("Project ID '"+projectId+"' does not exist");

        }


        return project;
    }
    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }
    public void deleteProjectByIdentifier(String projectid){
        Project project = projectRepository.findByProjectIdentifier(projectid.toUpperCase());

        if(project == null){
            throw  new  ProjectIdException("Cannot Project with ID '"+projectid+"'. This project does not exist");
        }

        projectRepository.delete(project);
    }
}
