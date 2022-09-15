package com.travelagency.travel.repository;
import com.travelagency.travel.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

    List<Travel> findByDescriptionContaining(String description);
}
