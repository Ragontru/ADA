/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesjulioverne.informatica.gestionfct.repositories;

import com.iesjulioverne.informatica.gestionfct.entities.Tutor;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Raquel
 */
@Repository
public interface TutorRepository extends JpaRepository<Tutor, Integer> {
    
    @Query("select t from Tutor t where t.idTutor=?1")
    public Tutor verTutor(int id);
    
    @Transactional
    @Modifying
    @Query("Update Tutor set nombre=?2 where idTutor=?1")
    public void updateTutor(Integer idAlu, String nombre);

    public void update(Integer idTutor, String nombre);
}
