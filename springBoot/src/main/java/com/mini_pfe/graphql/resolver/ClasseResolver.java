package com.mini_pfe.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.mini_pfe.entities.Classe;
import com.mini_pfe.entities.Departement;
import com.mini_pfe.entities.Materiel;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Component
public class ClasseResolver implements GraphQLResolver<Classe> {

    public Collection<Materiel> getMateriels(Classe classe) {
        return classe.getMateriels();
    }

    public Departement getDepartement(Classe classe) {
        return classe.getDepartement();
    }
}
