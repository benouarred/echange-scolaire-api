package com.nej.perso.echange.repositories;

import com.nej.perso.echange.entities.Personne;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonneRepository extends PagingAndSortingRepository<Personne, Integer> {
}
