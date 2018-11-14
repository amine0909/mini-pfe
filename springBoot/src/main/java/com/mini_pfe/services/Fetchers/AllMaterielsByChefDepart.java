package com.mini_pfe.services.Fetchers;


import com.mini_pfe.dao.repositories.MaterielsRepository;
import com.mini_pfe.entities.Materiel;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllMaterielsByChefDepart implements DataFetcher<List<Materiel>> {

    @Autowired
    private MaterielsRepository materielsRepository;

    @Override
    public List<Materiel> get(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("chefDepartId");
        System.out.println(id);
        return this.materielsRepository.findMaterielsByChefDepart(id);
    }
}
