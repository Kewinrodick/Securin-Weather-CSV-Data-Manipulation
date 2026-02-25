package com.project.securindemo.repository;


import com.project.securindemo.entity.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherData,Long>, JpaSpecificationExecutor<WeatherData> {

}
