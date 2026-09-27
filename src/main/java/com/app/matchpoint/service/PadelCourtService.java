package com.app.matchpoint.service;

import com.app.matchpoint.model.PadelCourt;
import com.app.matchpoint.repository.IPadelCourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PadelCourtService  implements IPadelCourtService {

    @Autowired
    private IPadelCourtRepository padelCourtRepository;

    @Override
    public PadelCourt createPadelCourt(PadelCourt padelCourt) {
        return null;
    }

    @Override
    public List<PadelCourt> getAllPadelCourts() {
        return List.of();
    }

    @Override
    public PadelCourt getPadelCourtById(Long id) {
        return null;
    }

    @Override
    public PadelCourt updatePadelCourt(Long id, PadelCourt padelCourt) {
        return null;
    }

    @Override
    public boolean deletePadelCourt(Long id) {
        return false;
    }
}
