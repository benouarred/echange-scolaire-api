package com.nej.perso.echange.repositories;

import com.nej.perso.echange.entities.Test;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "test", path = "test")
public interface TestRepository_2 extends PagingAndSortingRepository<Test, Integer> {

    List<Test> findByCode(@Param("code") String code);

}
