package com.mini_pfe.dao.repositories;

import com.mini_pfe.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamationsRepository extends JpaRepository<Reclamation,Long>{
    List<Reclamation> findByMaterielId(Long matId);
}
