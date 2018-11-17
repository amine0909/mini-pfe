package com.mini_pfe.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.mini_pfe.entities.Intervention;
import com.mini_pfe.entities.Reclamation;
import com.mini_pfe.entities.Technicien;
import graphql.GraphQL;
import org.springframework.stereotype.Component;

@Component
public class InterventionResolver implements GraphQLResolver<Intervention> {

    public Reclamation getReclamation(Intervention intervention) {
        return intervention.getReclamation();
    }

    public Technicien getTechnicien(Intervention intervention) {
        return intervention.getTechnicien();
    }
}
