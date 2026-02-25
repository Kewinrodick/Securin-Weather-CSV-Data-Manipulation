package com.project.securindemo.service;


import com.project.securindemo.entity.WeatherData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface WeatherService {
    @Transactional
    String uploadWeatherDataViaCsv(MultipartFile file);
    public Page<WeatherData> getWeatherData(
            Integer year,
            Integer month,
            LocalDate date,
            Pageable pageable);
}
