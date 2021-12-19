package ru.levelp.mysimplecrm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.levelp.mysimplecrm.model.Customers;

public interface CustomerRepo extends PagingAndSortingRepository<Customers, Long> {
    @Query("select c from Customers c where c.firstName like concat('%', :query, '%') or c.lastName like concat('%', :query, '%')")
    Page<Customers> findContact(@Param("query") String query, Pageable pageRequest);
}
