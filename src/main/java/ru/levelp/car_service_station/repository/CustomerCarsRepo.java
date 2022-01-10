package ru.levelp.car_service_station.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.levelp.car_service_station.model.CustomerCars;

public interface CustomerCarsRepo extends PagingAndSortingRepository<CustomerCars, Long> {
    @Query("select c from CustomerCars c where c.brand like concat('%', :query, '%') or c.model like concat('%', :query, '%')")
    Page<CustomerCars> findCar(@Param("query") String query, Pageable pageRequest);
}
