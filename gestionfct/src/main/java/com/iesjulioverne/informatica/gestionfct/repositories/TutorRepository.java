/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesjulioverne.informatica.gestionfct.repositories;

import com.iesjulioverne.informatica.gestionfct.entities.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Raquel
 */

public interface TutorRepository extends JpaRepository<Tutor, Integer> {

    @Query("Update Tutor set nombre=?2 where idTutor=?1")
    public void update(Integer idTutor, String nombre);
}
