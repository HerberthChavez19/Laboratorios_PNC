package com.example.ejercicioevaluado02_pnc.controller;

import com.example.ejercicioevaluado02_pnc.domain.entity.Wizard;
import com.example.ejercicioevaluado02_pnc.service.impl.WizardServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class WizardController {
    private final WizardServiceImpl wizardService;

    @PostMapping("/wizards")
    public ResponseEntity<Wizard> createProduct(@RequestBody Wizard wizard) {
        wizardService.createWizard(wizard);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(wizard);
    }

    @GetMapping("/wizards")
    public ResponseEntity<List<Wizard>> getAllWizards() {
        List<Wizard> response = wizardService.getAllWizards();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/wizards/deatheaters")
    public ResponseEntity<List<Wizard>> getByIsDeatheater() {
        List<Wizard> response = wizardService.getAllByIsDeatheater(true);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/wizards/patronus")
    public ResponseEntity<List<Wizard>> getByPatronus(@RequestParam String patronus) {
        List<Wizard> response = wizardService.getByPatronus(patronus);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/wizards/delete/{id}")
    public ResponseEntity<Wizard> deleteWizardById(@PathVariable UUID id) {
        Wizard response =  wizardService.deleteWizard(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/wizards/{id}")
    public ResponseEntity<Wizard> updateWizardById(@PathVariable UUID id, @RequestBody Wizard wizard) {
        Wizard response = wizardService.updateWizard(id, wizard);
        return ResponseEntity.ok(response);
    }


}
