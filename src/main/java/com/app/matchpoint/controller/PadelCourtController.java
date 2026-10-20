package com.app.matchpoint.controller;

import com.app.matchpoint.model.PadelCourt;
import com.app.matchpoint.service.IPadelCourtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/padel-courts")
public class PadelCourtController {

    private final IPadelCourtService padelCourtService;

    public PadelCourtController(IPadelCourtService padelCourtService) {
        this.padelCourtService = padelCourtService;
    }

    // Get all padel courts
    @GetMapping()
    public List<PadelCourt> getAllPadelCourts() {
        return padelCourtService.getAllPadelCourts();
    }

    // Get padel court by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPadelCourtById(@PathVariable Long id){
        PadelCourt padelCourt = padelCourtService.getPadelCourtById(id);

        if(padelCourt == null){
            return ResponseEntity.status(404).body("Padel court not found with ID: " + id);
        }
        return ResponseEntity.ok(padelCourt);
    }

    // Create
    @PostMapping
    public ResponseEntity<?> createPadelCourt(@RequestBody PadelCourt padelCourt){

        PadelCourt padel = padelCourtService.createPadelCourt(padelCourt);
        if(padel == null){
            return ResponseEntity.badRequest().body("Padel court data is invalid or incomplete");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(padel);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePadelCourt(@PathVariable Long id, @RequestBody PadelCourt padelCourt){

        PadelCourt update = padelCourtService.updatePadelCourt(id, padelCourt);
        if(update == null){
            return ResponseEntity.badRequest().body("Failed to update padel court with ID: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePadelCourt(@PathVariable Long id){

        boolean canDelete = padelCourtService.deletePadelCourt(id);

        if(!canDelete){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Padel court not found with ID: " + id);
        }
        return ResponseEntity.ok().body("Padel court deleted successfully");
    }
}
