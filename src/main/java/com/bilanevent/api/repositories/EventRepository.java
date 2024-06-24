package com.bilanevent.api.repositories;

import com.bilanevent.api.domain.event.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {

    @Query("SELECT e FROM Event e LEFT JOIN FETCH e.address a WHERE e.date >= :currentDate")
    public Page<Event> findUpComingEvents(@Param("currentDate") Date currentDate, Pageable pageable);


    @Query("SELECT e FROM Event e " +
            "LEFT JOIN e.address a " +
            "WHERE (:title = '' OR LOWER(e.title) LIKE LOWER(%:title%))" +
            "AND (:city = '' OR LOWER(a.city) LIKE LOWER(%:city%))" +
            "AND (:uf = '' OR LOWER(a.uf) LIKE LOWER(%:uf%))" +
            "AND (e.date >= :startDate AND e.date <= :endDate)")
    Page<Event> findFilteredEvents(@Param("title") String title,
                                   @Param("city") String city,
                                   @Param("uf") String uf,
                                   @Param("startDate") Date startDate,
                                   @Param("endDate") Date endDate,
                                   Pageable pageable);
}
