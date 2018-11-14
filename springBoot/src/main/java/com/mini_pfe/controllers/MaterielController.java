package com.mini_pfe.controllers;

import com.mini_pfe.dao.jobs.MaterielJob;
import com.mini_pfe.entities.Materiel;
import com.mini_pfe.services.GraphQlService;
import graphql.ExecutionResult;
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


    @RequestMapping(value="/materiels", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> getMateriels(@RequestBody String query) {
        ExecutionResult result = this.materielJob.getAllMaterielsByChefDepart(query);
        return ResponseEntity.status(HttpStatus.OK)
                .body(result);

    }
}
