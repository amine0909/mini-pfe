package com.mini_pfe.dao.repositories;

import com.mini_pfe.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationsRepository extends JpaRepository<Reclamation,Long>{
}
