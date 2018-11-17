package com.mini_pfe.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.mini_pfe.entities.ChefDepartement;
import com.mini_pfe.entities.Departement;
import com.mini_pfe.entities.Reclamation;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ChefDepartementResolver implements GraphQLResolver<ChefDepartement>{
    public Departement getDepartement(ChefDepartement chef) {
        return chef.getDepartement();
    }

    public Collection<Reclamation> getReclamations(ChefDepartement chef) {
        return chef.getReclamations();
    }
}
