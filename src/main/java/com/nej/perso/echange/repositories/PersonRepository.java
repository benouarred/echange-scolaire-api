package com.nej.perso.echange.repositories;

import com.nej.perso.echange.entities.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {
    Person findByUuid(String uuid);
}
