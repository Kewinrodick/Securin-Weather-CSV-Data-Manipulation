package com.project.securindemo.utils;

import com.project.securindemo.entity.WeatherData;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class WeatherSpecification {

    public static Specification<WeatherData> hasYear(Integer year) {
        return (root, query, cb) ->
                year == null ? null :
                        cb.equal(root.get("year"), year);
    }

    public static Specification<WeatherData> hasMonth(Integer month) {
        return (root, query, cb) ->
                month == null ? null :
                        cb.equal(root.get("month"), month);
    }

    public static Specification<WeatherData> hasDate(LocalDate date) {
        return (root, query, cb) ->
                date == null ? null :
                        cb.equal(root.get("recordDate"), date);
    }
}