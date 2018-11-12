package com.mini_pfe.controllers;

import com.mini_pfe.dao.jobs.MaterielJob;
import com.mini_pfe.entities.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MaterielController {

    @Autowired
    private MaterielJob materielJob;



    @RequestMapping(value="/materiels/{user_id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Materiel>> getMateriels(@PathVariable("user_id") long user_id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.materielJob.getMateriels(user_id));

    }
}
