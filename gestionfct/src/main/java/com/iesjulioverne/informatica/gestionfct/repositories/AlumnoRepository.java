/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesjulioverne.informatica.gestionfct.repositories;

import com.iesjulioverne.informatica.gestionfct.entities.Alumno;
import com.iesjulioverne.informatica.gestionfct.entities.Empresa;
import java.util.List;
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
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    
    @Query("select a from Alumno a")
    public List<Alumno> verAlumnos();
    
    @Query("select a from Alumno a where a.alumnoID=?1")
    public Alumno verAlumno (Integer id);
    
    @Query("select a.empresaId from Alumno a where a.idAlumno=?1")
    public Empresa getEmpresaFromAlumno (Integer idAlu);
    
    @Transactional
    @Modifying
    @Query("Update Alumno set nombre=?2 where idAlumno=?1")
    public void updateAlumno (Integer idAlu, String nombre);
    
    
}
