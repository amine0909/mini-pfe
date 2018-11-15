package com.mini_pfe.dao.repositories;

import com.mini_pfe.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Repository
public interface ReclamationsRepository extends JpaRepository<Reclamation, Long> {

    @Modifying
    @Query(value = "INSERT INTO reclamations (date_creation,description,objectif,chef_dep_id,mat_id) VALUES (:date_creation,:description,:objectif,:chef_dep_id,:mat_id)",
            nativeQuery = true)
    @Transactional
    int addReclamation(@Param("date_creation") Date date_creation,
                       @Param("description") String description,
                       @Param("objectif") String objectif,
                       @Param("chef_dep_id") Long chef_dep_id,
                       @Param("mat_id") Long mat_id);
}
