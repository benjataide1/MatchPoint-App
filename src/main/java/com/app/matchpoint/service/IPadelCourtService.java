package com.app.matchpoint.service;

import com.app.matchpoint.model.PadelCourt;

import java.util.List;

public interface IPadelCourtService {

    //CRUD operations for PadelCourt entity

    PadelCourt createPadelCourt(PadelCourt padelCourt);

    List<PadelCourt> getAllPadelCourts();

    PadelCourt getPadelCourtById(Long id);

    PadelCourt updatePadelCourt(Long id, PadelCourt padelCourt);

    boolean deletePadelCourt(Long id);
}
