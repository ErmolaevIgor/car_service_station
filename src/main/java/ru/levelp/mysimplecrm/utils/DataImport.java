package ru.levelp.mysimplecrm.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.FileReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DataImport {

    private static Long MALE = 1L;
    private static Long FEMALE = 2L;
    private static Long UNKNOWN = 3L;

    private static Long NEW = 1L;
    private static Long POTENTIAL = 2L;
    private static Long CUSTOMERS = 3L;
    private static Long REFUSAL = 4L;

    @SneakyThrows
    public static void main(String[] args) {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/car_service_station");
        dataSource.setUsername("postgres");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //for customers_data.csv
        CSVReader reader = new CSVReaderBuilder(new FileReader("Укажите путь к customers_data.csv"))
                .withSkipLines(1)
                .build();

        List<Object[]> params = reader.readAll().stream()
                .map($ -> new Object[]{$[1], $[2], $[3], $[4], getGenderId($[5]), NEW})
                .collect(Collectors.toList());

        jdbcTemplate.batchUpdate("insert into customers (first_name, last_name, email, phone, gender_id, status_id) values (?, ?, ?, ?, ?, ?)", params);

        //for customer_cars_data.csv
//        CSVReader reader = new CSVReaderBuilder(new FileReader("Укажите путь к customer_cars_data.csv"))
//                .withSkipLines(1)
//                .build();
//
//        List<Object[]> params = reader.readAll().stream()
//                .map($ -> new Object[]{$[1], $[2], $[3], $[4], $[5], $[6], $[7]})
//                .collect(Collectors.toList());
//        jdbcTemplate.batchUpdate("insert into customer_cars(vin_number, registration_number, brand, model, engine_modification, year_of_issue, mileage) values (?, ?, ?, ?, ?, ?, ?)", params);

    }

    private static Long getGenderId(String value) {
        if (Objects.equals("Male", value)) {
            return MALE;
        }
        if (Objects.equals("Female", value)) {
            return FEMALE;
        }
        return UNKNOWN;
    }

}
