package com.mini_pfe.dao.jobs;

import com.mini_pfe.dao.repositories.MaterielsRepository;
import com.mini_pfe.entities.Materiel;
import com.mini_pfe.services.GraphQlService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterielJob {

    @Autowired
    GraphQlService graphQlService;


    public ExecutionResult getAllMaterielsByChefDepart(String query) {
        ExecutionResult execute = this.graphQlService.getGraphQL().execute(query);
        return execute;

    }
}
