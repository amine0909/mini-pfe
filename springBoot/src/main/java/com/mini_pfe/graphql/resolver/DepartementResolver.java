package com.mini_pfe.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.mini_pfe.entities.ChefDepartement;
import com.mini_pfe.entities.Classe;
import com.mini_pfe.entities.Departement;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Component
public class DepartementResolver implements GraphQLResolver<Departement> {

    public ChefDepartement getChef(Departement departement) {
        return departement.getChef();
    }

    public Collection<Classe> getClasses(Departement departement) {
        return departement.getClasses();
    }
}
