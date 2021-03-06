package com.mini_pfe.dao.repositories;

import com.mini_pfe.entities.Materiel;
import com.mini_pfe.entities.enums.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MaterielsRepository extends JpaRepository<Materiel, Long> {
    @Query(value = "SELECT * FROM materiels m " +
            "JOIN classes c on (m.class_id=c.class_id)" +
            "JOIN departements d on (c.dep_id=d.dep_id)" +
            "JOIN users u on (u.dep_id=d.dep_id)" +
            "WHERE u.user_id=?1", nativeQuery = true)
    List<Materiel> findMaterielsByChefDepart(long user_id);


    @Query(value = "SELECT * FROM materiels m " +
            "JOIN classes c on (m.class_id=c.class_id)" +
            "JOIN departements d on (c.dep_id=d.dep_id)" +
            "JOIN users u on (u.dep_id=d.dep_id)" +
            "WHERE u.user_id=?1", nativeQuery = true)
    List<Materiel> getMateriels(long user_id);
    List<Materiel> findById(long id);
    List<Materiel> findAll();


    /*BEGIN OUSSAMA WORK*/

    //List<Materiel> findByClasseDepartementId(Long id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Materiel m SET m.adresseIp=:ip,m.categorie=:cat,m.marque=:marque,m.nom=:nom,m.numSerie=:num,m.classe.id=:id_classe WHERE m.id=:id", nativeQuery = false)
    void updateMaterial(
            @Param("ip") String ip, @Param("cat") Categorie cat, @Param("marque") String marque,
            @Param("nom") String nom, @Param("num") String numSerie, @Param("id_classe")  Long classeId,
            @Param("id") Long id
    );
    /*END OUSSAMA WORK*/
}
