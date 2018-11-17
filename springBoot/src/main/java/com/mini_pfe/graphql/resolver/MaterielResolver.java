package com.mini_pfe.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.mini_pfe.dao.repositories.ClassesRepository;
import com.mini_pfe.dao.repositories.ReclamationsRepository;
import com.mini_pfe.entities.Classe;
import com.mini_pfe.entities.Materiel;
import com.mini_pfe.entities.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class MaterielResolver implements GraphQLResolver<Materiel> {
    public Classe getClasse(Materiel mat) {
        return mat.getClasse();
    }

    public Collection<Reclamation> getReclamations(Materiel mat) {
        return mat.getReclamations();
    }
}
