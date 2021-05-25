/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.DaoImplements;

import java.util.ArrayList;
import com.iesjulioverne.informatica.gestionfct.entities.Alumno;
import xml.handler.AlumnoHandlerXML;
import xml.interfacesDao.IDaoAlumno;

/**
 *
 * @author Raquel
 */
public class DaoAlumnoXML extends DaoXML implements IDaoAlumno {

    private String nombreFichero;
    private AlumnoHandlerXML handler;

    public DaoAlumnoXML(String nombreFichero) {

        super(new AlumnoHandlerXML());
        handler = (AlumnoHandlerXML) this.getHandler();
        this.nombreFichero = nombreFichero;
    }

    public void guardarAlumno(Alumno a) {

    }

    public ArrayList<Alumno> verAlumnos() {

        try {
            this.leerXML(nombreFichero);
            return handler.getAlumnos();
        } catch (Exception ex) {
            return null;
        }

    }
}
