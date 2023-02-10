package com.betoola.homework.repository;

import com.betoola.homework.entity.Rate;
import com.betoola.homework.entity.RateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, RateId> {
}
