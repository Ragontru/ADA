/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesjulioverne.informatica.gestionfct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iesjulioverne.informatica.gestionfct.entities.Alumno;
import com.iesjulioverne.informatica.gestionfct.entities.Empresa;
import com.iesjulioverne.informatica.gestionfct.entities.Tutor;
import com.iesjulioverne.informatica.gestionfct.service.WebService;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Raquel
 */
@Controller
public class InicioController {
    
    private final WebService service;
    
    public InicioController (WebService gestService){
        this.service = gestService;
    }
    
    @RequestMapping("/")
    public String listarAlumnos(Model model) {
        
        List<Alumno> alumnos = service.getAlumnos();
        model.addAttribute("alumnos", alumnos);
        
        return "listar_alumnos";
    }
    
    // ---------- Peticiones de alumno ----------
    @RequestMapping("/crear_alumno")
    public String crearAlumno (Model modelo){
        Alumno alumno = new Alumno();
        modelo.addAttribute("alumno", alumno);
        List<Empresa> empresas = service.getEmpresas();
        modelo.addAttribute("empresa",empresas);
        List<Tutor> tutores = service.getTutores();
        modelo.addAttribute("tutor",tutores);
        
        return "crear_alumno";       
    }
    
    @RequestMapping("/guardar_alumno")
    public String guardarAlumno(Alumno alumno){
        
        System.out.println(alumno.getNombre());
        service.guardarAlumno(alumno);
        
        return "redirect:/";
    }
    
    @RequestMapping("borrar_alumno/{id}")
    public String borrarAlumno(@PathVariable(value="id")Integer idAlumno){
        Alumno alumno = new Alumno(idAlumno);
        service.borrarAlumno(alumno);
        return "redirect:/";
    }
    
    @RequestMapping("/alumno_edit/{id}")
    public String editEmpresa(@PathVariable(value="id")Integer idAlumno, Model modelo){
        Alumno alumnoBase = service.getOneAlumno(idAlumno);
        modelo.addAttribute("alumno",alumnoBase);
        List<Empresa> empresas = service.getEmpresas();
        modelo.addAttribute("empresa",empresas);
        
        System.out.println(alumnoBase.getNombre());
        return "/alumno_edit";
    }
    
    @RequestMapping("/alumno_edit/{id}")
    public String editTutor(@PathVariable(value="id")Integer idAlumno, Model modelo){
        Alumno alumnoBase = service.getOneAlumno(idAlumno);
        modelo.addAttribute("alumno",alumnoBase);
        List<Tutor> tutores = service.getTutores();
        modelo.addAttribute("tutor",tutores);
        
        System.out.println(alumnoBase.getNombre());
        return "/alumno_edit";
    }
    
    @RequestMapping("/addE_alumno")
    public String addEAlumno (Alumno alumno, @RequestParam Integer[] selectEmpresa){
        alumno.addEmpresa(selectEmpresa);
        service.guardarAlumno(alumno);
        
        return "redirect:/";
    }
    
    // ---------- Peticiones de tutor ----------
    @RequestMapping("/listar_tutores")
    public String listarTutores(Model modelo){
        List<Tutor> tutores = service.getTutores();
        modelo.addAttribute("tutores",tutores);
        return "listar_tutores";
    }
    
    @RequestMapping("/crear_tutor")
    public String crearTutor(Model modelo){
        Tutor tutor = new Tutor();
        modelo.addAttribute("tutor",tutor);
        return "crear_tutor";
    }
    
    @RequestMapping("/guardar_tutor")
    public String guardarTutor(Tutor tutor){
        service.guardarTutor(tutor);
        return "redirect:/listar_tutores";
    }
    
    @RequestMapping("/borrar_tutor/{id}")
    public String borrarTutor(@PathVariable(value="id") Integer idTutor, Model modelo){
        Tutor tutor = new Tutor(idTutor);
        service.borrarTutor(tutor);
        return "redirect:/listar_tutores";
    }
    /*
    @RequestMapping("/tutor_edit/{id}")
    public String editTutor(@PathVariable(value="id") Integer idTutor, Model modelo){
        Tutor tutorBase = service.getOneTutor(idTutor);
        modelo.addAttribute("tutor",tutorBase);
        System.out.println(tutorBase.getNombre());
        return "/tutor_edit";
    }
    */
    @RequestMapping("/act_tutor")
    public String actTutor (Tutor tutor, @RequestParam Integer selectEmpresa){
        tutor.setEmpresaidEmpresa(new Empresa(selectEmpresa));
        service.guardarTutor(tutor);
        return "redirect:/listar_tutores";
    }
    
    // ---------- Peticiones de tutor ----------
    @RequestMapping("/listar_empresas")
    public String listarEmpresas(Model modelo){
        List<Empresa> empresas = service.getEmpresas();
        modelo.addAttribute("empresas",empresas);
        return "/listar_empresas";
    }
    
    @RequestMapping("/crear_empresa")
    public String crearEmpresa(Model modelo){
        Empresa empresa = new Empresa();
        modelo.addAttribute("empresa",empresa);
        return "crear_empresa";
    }
    
    @RequestMapping("/guardar_empresa")
    public String guardaEmpresa(Empresa empresa){
        service.guardarEmpresa(empresa);
        return "redirect:/";
    }
    
    @RequestMapping("empresa_edit/borrar_empresa/{id}")
    public String borrarEmpresaEdit(@PathVariable(value="id") Integer idEmpresa){
        Empresa empresa = new Empresa (idEmpresa);
        service.borrarEmpresa(empresa);
        return "redirect:/";
    }
    
    @RequestMapping("/borrar_empresa/{id}")
    public String borrarEmpresa(@PathVariable(value="id") Integer idEmpresa){
        Empresa empresa = service.getOneEmpresa(idEmpresa);
        if (empresa.getAlumnoList().isEmpty()) {
            List<Tutor> tutoresEmpresa = empresa.getTutorList();
            tutoresEmpresa.forEach(tutor->{
                service.actualizarTutor(tutor);
            });
            service.borrarEmpresa(empresa);
        }
        return "redirect:/lista_empresas";
    }
    
    /*
    @RequestMapping("/empresa_edit/{id}")
    public String editEmpresa(@PathVariable(value="id") Integer idEmpresa, Model modelo){
        Empresa empresaBase = service.getOneEmpresa(idEmpresa);
        modelo.addAttribute("empresa",empresaBase);
        System.out.println(empresaBase.getNombre());
        return "/taller_edit";
    }
    */
    
    // Leer XMLO
}
