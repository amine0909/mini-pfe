package com.mini_pfe.controllers;

import com.mini_pfe.dao.jobs.MaterielJob;
import com.mini_pfe.entities.Materiel;
import com.mini_pfe.entities.enums.Categorie;
//import com.mini_pfe.services.GraphQlService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class MaterielController {

    @Autowired
    private MaterielJob materielJob;


    /*
    old with old configuration
    @RequestMapping(value="/materiels", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> getMateriels(@RequestBody String query) {
        ExecutionResult result = this.materielJob.getAllMaterielsByChefDepart(query);
        return ResponseEntity.status(HttpStatus.OK)
                .body(result);

    }*/

     /*BEGIN OUSSAMA METHODS*/

    @GetMapping(value = "/materiel/{id}/get")
    public ResponseEntity<Materiel> getMaterielById(@PathVariable("id") Long id) {
        Materiel mat = this.materielJob.findMaterielById(id);
        if(mat!=null)
            return new ResponseEntity<Materiel>(mat,HttpStatus.OK);

        return new ResponseEntity<Materiel>(mat,HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/materiels/{id}/update")
    public ResponseEntity<Void> updateMaterial(@PathVariable("id") Long id, @RequestBody Map<String,String> materiel) {
        try{
            Materiel m = new Materiel();
            m.setAdresseIp(materiel.get("adresseIp"));
            m.setId(id);
            m.setCategorie(Categorie.valueOf(materiel.get("categorie")));
            m.setNom(materiel.get("nom"));
            m.setNumSerie(materiel.get("numSerie"));
            m.setMarque(materiel.get("marque"));
            this.materielJob.updateMaterial(m,Long.valueOf(materiel.get("classe")));
            System.err.println("tous va bien");
            return new ResponseEntity<Void>(HttpStatus.OK);
        }catch(Exception e) {
            System.err.println("error here");
            return  new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
   /*END OUSSAMA METHODS*/
}
