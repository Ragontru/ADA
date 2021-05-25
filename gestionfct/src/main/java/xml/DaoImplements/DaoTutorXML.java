/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.DaoImplements;

import com.iesjulioverne.informatica.gestionfct.entities.Tutor;
import xml.handler.TutorHandlerXML;
import xml.interfacesDao.IDaoTutor;
import java.util.ArrayList;


/**
 *
 * @author Raquel
 */
public class DaoTutorXML extends DaoXML implements IDaoTutor {
     
    private String nombreFichero;
    private TutorHandlerXML handler;
    
    public DaoTutorXML (String nombreFichero){
        super(new TutorHandlerXML());
        handler = (TutorHandlerXML)this.getHandler();
        this.nombreFichero = nombreFichero;
    }
    
    public void guardarTutor(Tutor t){
        
    }
    
    public ArrayList<Tutor> verTutores(){
        try{
            this.leerXML(nombreFichero);
            return handler.getTutores();
        } catch (Exception ex){
            return null;
        }
    }
}
