package com.project.securindemo.service.impls;

import com.project.securindemo.entity.WeatherData;
import com.project.securindemo.repository.WeatherRepository;
import com.project.securindemo.service.WeatherService;
import com.project.securindemo.utils.CsvUtil;


import com.project.securindemo.utils.WeatherSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;
    private final CsvUtil csvUtil;

    @Override
    @Transactional
    public String uploadWeatherDataViaCsv(MultipartFile file) {

        try {
            List<WeatherData> weatherDataList =
                    csvUtil.parseCsvFile(file);

            weatherRepository.saveAll(weatherDataList);

            return weatherDataList.size() + " records uploaded successfully";

        } catch (IOException e) {
            throw new RuntimeException("Error processing CSV file", e);
        }
    }

    @Override
    public Page<WeatherData> getWeatherData(
            Integer year,
            Integer month,
            LocalDate date,
            Pageable pageable) {

        Specification<WeatherData> spec =
                Specification.where(WeatherSpecification.hasYear(year))
                        .and(WeatherSpecification.hasMonth(month))
                        .and(WeatherSpecification.hasDate(date));

        return weatherRepository.findAll(spec, pageable);
    }
}