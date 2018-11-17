package com.mini_pfe.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.mini_pfe.entities.ChefDepartement;
import com.mini_pfe.entities.Intervention;
import com.mini_pfe.entities.Materiel;
import com.mini_pfe.entities.Reclamation;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Component
public class ReclamationResolver implements GraphQLResolver<Reclamation> {
    public Materiel getMateriel(Reclamation reclamation) {
        return reclamation.getMateriel();
    }

        public ChefDepartement getChefDepartement(Reclamation rec) {
         return rec.getChefDepartement();
        }

        public Collection<Intervention> getInterventions(Reclamation rec) {
        return  rec.getInterventions();
        }
}
