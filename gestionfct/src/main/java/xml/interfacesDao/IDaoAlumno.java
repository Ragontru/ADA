/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.interfacesDao;

import java.util.ArrayList;
import com.iesjulioverne.informatica.gestionfct.entities.Alumno;

/**
 *
 * @author Raquel
 */
public interface IDaoAlumno {
    
    public void guardarAlumno(Alumno a);
    
    public ArrayList<Alumno> verAlumnos();
}
