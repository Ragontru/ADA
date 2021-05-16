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
    // Crear alumno
    public void crearAlumno(Alumno alumno){
        aluRepository.save(alumno);
    }
    
    // Actualizar alumno
    public void actualizarAlumno(Alumno alumno){
        aluRepository.update(alumno.getIdAlumno(), alumno.getNombre());
    }
    
    // Borrar alumno
    public void borrarAlumno(Alumno alumno) {
        aluRepository.delete(alumno);
    }
    
    // Mostrar todos los alumnos
    public List<Alumno> getAlumnos(){
        List<Alumno> alumnos = aluRepository.findAll();
        return alumnos;
    }

    // Mostrar un alumno
    public Alumno getAlumno(Integer idAlumno) {
        return aluRepository.getOne(idAlumno);
    }
    
    // ---------- CRUD Tutor ----------
    // Crear tutor
    public void crearTutor(Tutor tutor) {
        tutRepository.save(tutor);
    }
    
    // Actualizar tutor
    public void actualizarTutor(Tutor tutor){
        tutRepository.update(tutor.getIdTutor(), tutor.getNombre());
    }
    
    // Borrar tutor
    public void borrarTutor(Tutor tutor) {
        tutRepository.delete(tutor);
    }
    
    // Listar todos los tutores
    public List<Tutor> getTutores() {
        List<Tutor> tutores = tutRepository.findAll();
        return tutores;
    }
    
    // Listar un tutor
    public Tutor getTutor(Integer idTutor) {
        return tutRepository.getOne(idTutor);
    }
    
    // ---------- CRUD Empresa ----------
    // Crear empresa
    public void crearEmpresa(Empresa empresa) {
        empRepository.save(empresa);
    }
    
    // Actualizar empresa
    public void actualizarEmpresa(Empresa empresa){
        empRepository.update(empresa.getIdEmpresa(), empresa.getNombre());
    }
    
    // Borrar empresa
    public void borrarEmpresa(Empresa empresa) {
        empRepository.delete(empresa);
    }
    
    // Listar todas las empresas
    public List<Empresa> getEmpresas() {
        List<Empresa> empresas = empRepository.findAll();
        return empresas;
    }
  
    // Listar una empresa
    public Empresa getEmpresa(Integer idEmpresa) {
        return empRepository.getOne(idEmpresa);
    }

}