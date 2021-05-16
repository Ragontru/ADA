/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesjulioverne.informatica.gestionfct.repositories;

import com.iesjulioverne.informatica.gestionfct.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Raquel
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    @Query("Update Empresa SET nombre=?2 WHERE idEmpresa=?1")
    public void update(Integer idEmpresa, String nombre);
}
