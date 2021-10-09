package main;

import main.model.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Case;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CaseController {

    @Autowired
    private CaseRepository caseRepository;

    @GetMapping("/cases/")
    public ResponseEntity list() {
        Iterable<Case> caseIterable = caseRepository.findAll();
        ArrayList<Case> allCase = new ArrayList<>();
        for (Case deal : caseIterable){
            allCase.add(deal);
        }
        return new ResponseEntity(allCase, HttpStatus.OK);
    }

    @DeleteMapping("/cases")
    public ResponseEntity deleteList() {
        caseRepository.deleteAll();
        return new ResponseEntity<>("Case list cleared", HttpStatus.OK);
    }

    @PostMapping("/cases/{deal}")
    public ResponseEntity<String> add(Case deal) {
        Case newCase = caseRepository.save(deal);
        return new ResponseEntity<>("Case added: ID_" + newCase.getId(), HttpStatus.OK);
    }

    @DeleteMapping("/case/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        Optional<Case> optionalCase = caseRepository.findById(id);
        if (!optionalCase.isPresent()) {
            caseRepository.delete(optionalCase.get());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>("Case deleted ID_"+ id, HttpStatus.OK);
    }

    @PutMapping("/cases/{id}")
    public ResponseEntity<String> update(@PathVariable int id, Case newCase) {
        Optional<Case> optionalCase = caseRepository.findById(id);
        if (optionalCase.isPresent()) {
            newCase.setId(id);
            caseRepository.save(newCase);
            return new ResponseEntity<>("Case update ID_" + id, HttpStatus.OK);
        }else
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/cases/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Optional<Case> caseOptional = caseRepository.findById(id);
        if (!caseOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(caseOptional.get(), HttpStatus.OK);
    }
}
