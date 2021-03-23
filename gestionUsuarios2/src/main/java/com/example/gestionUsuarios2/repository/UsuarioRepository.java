/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gestionUsuarios2.repository;

import com.example.gestionUsuarios2.negocio.entity.Tarea;
import com.example.gestionUsuarios2.negocio.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
    
    @Query("select u from Usuario u" )
    public List<Usuario> verUsuarios();
    
    
    @Query("select u from Usuario u where u.nombre=?1 and u.password=?2" )
    public Usuario validar(String nombre, String password );
    
    @Query("select u.tareaList from Usuario u where u.usuarioId=?1")
    public List<Tarea> verTareas(Integer id);
    
     @Query("from Usuario u where u.usuarioId=?1")
    public Usuario verUsuario(Integer id);
    
    
    
    
}
