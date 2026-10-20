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
        if(!this.validator(padelCourt)) {
            return null;
        }

        return padelCourtRepository.save(padelCourt);
    }

    @Override
    public List<PadelCourt> getAllPadelCourts() {
        return padelCourtRepository.findAll();
    }

    @Override
    public PadelCourt getPadelCourtById(Long id) {
        return padelCourtRepository.findById(id).orElse(null);
    }

    @Override
    public PadelCourt updatePadelCourt(Long id, PadelCourt padelCourt) {

        PadelCourt padelCourt1 = getPadelCourtById(id);

        if(padelCourt1 == null) {
            return null;
        }

        if(!this.validator(padelCourt)) {
            return null;
        }

        padelCourt1.setType_court(padelCourt.getType_court());
        padelCourt1.setPrice(padelCourt.getPrice());

        return padelCourtRepository.save(padelCourt1);
    }

    @Override
    public boolean deletePadelCourt(Long id) {
        PadelCourt padelCourt1 = getPadelCourtById(id);

        if(padelCourt1 == null) {
            return false;
        }
        padelCourtRepository.delete(padelCourt1);
        return true;
    }

    private boolean validator(PadelCourt padelCourt) {

        if(padelCourt.getType_court() == null || padelCourt.getType_court().isBlank()) {
            return false;
        }

        return true;
    }

}
