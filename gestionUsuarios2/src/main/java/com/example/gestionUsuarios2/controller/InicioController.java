/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gestionUsuarios2.controller;

import com.example.gestionUsuarios2.negocio.entity.Usuario;
import com.example.gestionUsuarios2.negocio.service.UsuarioService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class InicioController {
    
    private final UsuarioService usuService;

    public InicioController(UsuarioService usuService) {
       
        this.usuService = usuService;
        
    }
    
    
    @RequestMapping("/")
    public String listarusuarios(Model modelo){
        
        List<Usuario> usuarios =usuService.listarUsuarios();
        modelo.addAttribute("usuarios",usuarios);
        
        return"listado_usuarios";
    }
    
    
    @RequestMapping("/form_usuario")
    public String detalleUsuario(Model modelo){
      Usuario usuario=new Usuario();
      usuario.setNombre("pepe");
        
        //Si ya teniamos un usuario , tnedrá valores y se editará
        modelo.addAttribute("usuario",usuario);  
        
        return"form_usuario";
    }
//       
    
    @PostMapping("/guardar")
    public String guardarUsuario(Usuario usuario){
        
       System.out.println(usuario.getNombre());
       usuService.guardarUsuario(usuario);
        return"redirect:/";
    }
    
}
