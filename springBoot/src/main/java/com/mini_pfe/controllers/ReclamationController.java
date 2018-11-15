package com.mini_pfe.controllers;


import com.mini_pfe.dao.jobs.ReclamationJob;
import com.mini_pfe.entities.QueriesDefinition.ReclamationQuerieDefinitionClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReclamationController {


    @Autowired
    private ReclamationJob reclamationJob;

    @RequestMapping(value = "/api/chefDep/add_reclamation", method = RequestMethod.POST)
    public ResponseEntity< HashMap<String, String>> add_reclamation(@RequestBody ReclamationQuerieDefinitionClass query) {
        int result = this.reclamationJob.add_reclamation(query);

        HashMap<String, String> message = new HashMap<>();

        if(result == 1) {
            message.put("message", "Insert with success");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }

        message.put("message", "Server error");
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
