package com.cydeo.bootstrap;

import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component

public class DataGenerator implements CommandLineRunner {
    private final RegionRepository regionRepository;

    public DataGenerator(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------Region Start-----------");
        System.out.println(regionRepository.findByCountry("United States"));
        System.out.println("findDistinctByCountry: "+ regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainingOrderByCountry: "+ regionRepository.findByCountryContainingOrderByCountry("United"));
        System.out.println("--------Region End---------------");
    }
}
