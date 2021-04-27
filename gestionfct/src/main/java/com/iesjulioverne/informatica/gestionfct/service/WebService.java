/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesjulioverne.informatica.gestionfct.service;

import com.iesjulioverne.informatica.gestionfct.entities.Alumno;
import com.iesjulioverne.informatica.gestionfct.entities.Empresa;
import com.iesjulioverne.informatica.gestionfct.entities.Tutor;
import com.iesjulioverne.informatica.gestionfct.repositories.AlumnoRepository;
import com.iesjulioverne.informatica.gestionfct.repositories.EmpresaRepository;
import com.iesjulioverne.informatica.gestionfct.repositories.TutorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Raquel
 */
@Service
public class WebService {
 
    private final AlumnoRepository aluRepository;
    private final TutorRepository tutRepository;
    private final EmpresaRepository empRepository;
    
    public WebService(AlumnoRepository aluRepository, TutorRepository tutRepository, EmpresaRepository empRepository){
        this.aluRepository=aluRepository;
        this.tutRepository=tutRepository;
        this.empRepository=empRepository;
    }
    
    // ---------- CRUD Alumno ----------
    public void guardarAlumno(Alumno alumno){
        aluRepository.save(alumno);
    }
    
    public void borrarAlumno(Alumno alumno) {
        aluRepository.delete(alumno);
    }
       
    public List<Alumno> getAlumnos(){
        List<Alumno> alumnos = aluRepository.findAll();
        return alumnos;
    }

    public Alumno getOneAlumno(Integer idAlumno) {
        return aluRepository.getOne(idAlumno);
    }
    
    public void actualizarAlumno(Alumno alumno){
        aluRepository.updateAlumno(alumno.getIdAlumno(), alumno.getNombre());
    }
    
    // ---------- CRUD Tutor ----------
    public void guardarTutor(Tutor tutor) {
        tutRepository.save(tutor);
    }
    
    public void borrarTutor(Tutor tutor) {
        tutRepository.delete(tutor);
    }
    
    public List<Tutor> getTutores() {
        List<Tutor> tutores = tutRepository.findAll();
        return tutores;
    }
    
    public Tutor getOneTutor(Integer idTutor) {
        return tutRepository.getOne(idTutor);
    }
    
    public void actualizarTutor(Tutor tutor){
        tutRepository.updateTutor(tutor.getIdTutor(), tutor.getNombre());
    }
    
    // ---------- CRUD Empresa ----------
    public void guardarEmpresa(Empresa empresa) {
        empRepository.save(empresa);
    }
    
    public void borrarEmpresa(Empresa empresa) {
        empRepository.delete(empresa);
    }
    
    public List<Empresa> verEmpresaNombre(Empresa empresa){
        return empRepository.verEmpresaNombre(empresa.getNombre());
    }
    
    public List<Empresa> getEmpresas() {
        List<Empresa> empresas = empRepository.findAll();
        return empresas;
    }
  
    public Empresa getOneEmpresa(Integer idEmpresa) {
        return empRepository.getOne(idEmpresa);
    }
    
}
