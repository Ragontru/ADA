/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesjulioverne.informatica.gestionfct.repositories;

import com.iesjulioverne.informatica.gestionfct.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Raquel
 */
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    // Actualizar alumno
    @Query("Update Alumno set nombre=?2 where idAlumno=?1")
    public void update(Integer idAlu, String nombre);

}
