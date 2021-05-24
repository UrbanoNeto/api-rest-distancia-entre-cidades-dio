package com.digitalinnovationone.buscadorcidadesbrasil.repositories;

import com.digitalinnovationone.buscadorcidadesbrasil.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distanceByCube(final Double lat1, final Double lon1, final Double lat2, final Double lon2);
}