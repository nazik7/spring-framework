package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    List<Region> findByCountry(String country);

    List<Region> findDistinctByCountry(String country);

    List<Region> findByCountryContaining(String country);

    //display all regions with country name includes 'United' in order
    List<Region> findByCountryContainingOrderByCountry(String country);

    List<Region> findTop2ByCountry(String country);

}
