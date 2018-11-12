package com.mini_pfe.dao.repositories;

import com.mini_pfe.entities.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaterielsRepository extends JpaRepository<Materiel, Long> {


    @Query(value = "SELECT * FROM materiels m " +
            "JOIN classes c on (m.class_id=c.class_id)" +
            "JOIN departements d on (c.dep_id=d.dep_id)" +
            "JOIN users u on (u.dep_id=d.dep_id)" +
            "WHERE u.user_id=?1", nativeQuery = true)
    List<Materiel> findMateriels(long user_id);




    List<Materiel> findById(long id);
    List<Materiel> findAll();
}
