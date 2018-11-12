package com.mini_pfe.dao.jobs;

import com.mini_pfe.dao.repositories.MaterielsRepository;
import com.mini_pfe.entities.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterielJob {

    @Autowired
    private MaterielsRepository materielRepository;


    public List<Materiel> getMateriels(long user_id) {
       return this.materielRepository.findMateriels(user_id);
    }
}
