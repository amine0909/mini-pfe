package com.mini_pfe.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mini_pfe.dao.repositories.MaterielsRepository;
import com.mini_pfe.entities.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    private MaterielsRepository materielsRepository;

    public List<Materiel> AllMaterielsByChefDepart(Long chefDepartId) {
        return  this.materielsRepository.findMaterielsByChefDepart(chefDepartId);
    }

    public List<Materiel> getMaterialsByDepartement(Long departementId) {
       return  this.materielsRepository.findByClasseDepartementId(departementId);
    }

    public List<Materiel> getMaterialsByClassroom(Long classroomId) {
        return this.materielsRepository.findByClasseId(classroomId);
    }
}
