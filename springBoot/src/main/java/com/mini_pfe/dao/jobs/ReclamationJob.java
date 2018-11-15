package com.mini_pfe.dao.jobs;


import com.mini_pfe.dao.repositories.ReclamationsRepository;
import com.mini_pfe.entities.QueriesDefinition.ReclamationQuerieDefinitionClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class ReclamationJob {

    @Autowired
    private ReclamationsRepository reclamationsRepository;


    public int add_reclamation(ReclamationQuerieDefinitionClass query) {
        int rowInserted = this.reclamationsRepository.addReclamation(
                query.date_creation,
                query.description,
                query.objectif,
                query.chef_dep_id,
                query.mat_id);

        return rowInserted;

    }
}
