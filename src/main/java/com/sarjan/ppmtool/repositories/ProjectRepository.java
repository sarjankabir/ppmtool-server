package com.sarjan.ppmtool.repositories;

import com.sarjan.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sarjan Kabir
 */

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {

    @Override
    Iterable<Project> findAll();

    Project findByProjectIdentifier(String projectId);
}
