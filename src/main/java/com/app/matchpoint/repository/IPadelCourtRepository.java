package com.app.matchpoint.repository;

import com.app.matchpoint.model.PadelCourt;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPadelCourtRepository extends JpaRepository<PadelCourt, Long> {
}
