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

/**
 *
 * @author Raquel
 */
@Controller
public class InicioController {

    private final WebService service;

    public InicioController(WebService gestService) {
        this.service = gestService;
    }

    // -- Inicio
    @RequestMapping("/")
    public String inicio() {
        return "inicio";
    }

    // ---------- Peticiones de alumno ----------
    // Muestra todos los alumnos
    @RequestMapping("/listar_alumnos")
    public String listarAlumnos(Model model) {

        List<Alumno> alumnos = service.getAlumnos();
        model.addAttribute("alumnos", alumnos);

        return "listar_alumnos";
    }

    // Crea un alumno
    @RequestMapping("/crear_alumno")
    public String crearAlumno(Model modelo) {
        Alumno alumno = new Alumno();
        modelo.addAttribute("alumno", alumno);
        modelo.addAttribute("empresa", service.getEmpresas());
        modelo.addAttribute("tutor", service.getTutores());

        return "crear_alumno";
    }

    // Guarda un alumno
    @RequestMapping("/guardar_alumno")
    public String guardarAlumno(Alumno alumno) {

        if (alumno.getEmpresaIdEmpresa() == null || alumno.getTutorIdTutor() == null) {
            alumno.setEmpresaIdEmpresa(new Empresa(1));
            alumno.setTutorIdTutor(new Tutor(1));
            service.crearAlumno(alumno);
            return "redirect:/";
        } else {
            System.out.println(alumno.getNombre());
            service.crearAlumno(alumno);
            return "redirect:/";
        }
    }

    // Borrar un alumno
    @RequestMapping("borrar_alumno/{id}")
    public String borrarAlumno(@PathVariable(value = "id") Integer idAlumno) {
        Alumno alumno = new Alumno(idAlumno);
        service.borrarAlumno(alumno);
        return "redirect:/";
    }

    // Actualiza un alumno
    @RequestMapping("/alumno_edit/{id}")
    public String editAlumno(@PathVariable(value = "id") Integer idAlumno, Model modelo) {
        Alumno alumnoBase = service.getAlumno(idAlumno);
        modelo.addAttribute("alumno", alumnoBase);
        modelo.addAttribute("empresa", service.getEmpresas());
        modelo.addAttribute("tutor", service.getTutores());

        System.out.println(alumnoBase.getNombre());
        return "/alumno_edit";
    }

    // ---------- Peticiones de tutor ----------
    // Muestra todos los tutores
    @RequestMapping("/listar_tutores")
    public String listarTutores(Model modelo) {
        List<Tutor> tutores = service.getTutores();
        modelo.addAttribute("tutores", tutores);
        return "/listar_tutores";
    }

    // Crea un tutor
    @RequestMapping("/crear_tutor")
    public String crearTutor(Model modelo) {
        Tutor tutor = new Tutor();
        modelo.addAttribute("tutor", tutor);
        return "crear_tutor";
    }

    // Guarda un tutor
    @RequestMapping("/guardar_tutor")
    public String guardarTutor(Tutor tutor) {
        service.crearTutor(tutor);
        return "redirect:/listar_tutores";
    }

    // Borra un tutor
    @RequestMapping("/borrar_tutor/{id}")
    public String borrarTutor(@PathVariable(value = "id") Integer idTutor, Model modelo) {
        Tutor tutor = new Tutor(idTutor);

        List<Alumno> alumnos = service.getAlumnos();
        for (int i = 0; i < alumnos.size(); i++) {
            if (tutor.getIdTutor() == alumnos.get(i).getTutorIdTutor().getIdTutor()) {
                alumnos.get(i).setTutorIdTutor(new Tutor(1));
            }
        }

        service.borrarTutor(tutor);
        return "redirect:/listar_tutores";
    }

    // Actualizar tutor
    @RequestMapping("/tutor_edit/{id}")
    public String editTutor(@PathVariable(value = "id") Integer idTutor, Model modelo) {
        Tutor tutorBase = service.getTutor(idTutor);
        modelo.addAttribute("tutor", tutorBase);
        System.out.println(tutorBase.getNombre());
        return "/tutor_edit";
    }

    // ---------- Peticiones de empresas ----------
    // Muestra todas las empresas
    @RequestMapping("/listar_empresas")
    public String listarEmpresas(Model modelo) {
        List<Empresa> empresas = service.getEmpresas();
        modelo.addAttribute("empresas", empresas);
        return "/listar_empresas";
    }

    // Crea una empresa
    @RequestMapping("/crear_empresa")
    public String crearEmpresa(Model modelo) {
        Empresa empresa = new Empresa();
        modelo.addAttribute("empresa", empresa);
        return "crear_empresa";
    }

    // Guarda una empresa
    @RequestMapping("/guardar_empresa")
    public String guardaEmpresa(Empresa empresa) {
        service.crearEmpresa(empresa);
        return "redirect:/";
    }

    // Borra una empresa
    @RequestMapping("/borrar_empresa/{id}")
    public String borrarEmpresa(@PathVariable(value = "id") Integer idEmpresa) {
        Empresa empresa = new Empresa(idEmpresa);

        List<Alumno> alumnos = service.getAlumnos();
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getEmpresaIdEmpresa().getIdEmpresa() == empresa.getIdEmpresa()) {
                alumnos.get(i).setEmpresaIdEmpresa(new Empresa(1));
            }
        }

        service.borrarEmpresa(empresa);
        return "redirect:/lista_empresas";
    }

    // Actualiza una empresa
    @RequestMapping("/empresa_edit/{id}")
    public String editEmpresa(@PathVariable(value = "id") Integer idEmpresa, Model modelo) {
        Empresa empresaBase = service.getEmpresa(idEmpresa);
        modelo.addAttribute("empresa", empresaBase);
        System.out.println(empresaBase.getNombre());
        return "/empresa_edit";
    }

}
