/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesjulioverne.informatica.gestionfct.repositories;

import com.iesjulioverne.informatica.gestionfct.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Raquel
 */
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    
    @Query("select e from Empresa e")
    public Empresa verUsuario();
    
    @Query("select e from Empresa e where e.nombre=?1")
    public Empresa verEmpresaNombre(String nombre);
}
