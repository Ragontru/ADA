/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.handler;

import com.iesjulioverne.informatica.gestionfct.entities.Alumno;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Raquel
 */
public class AlumnoHandlerXML extends DefaultHandler {

    private StringBuilder cadena;
    private Alumno alumno;
    private ArrayList<Alumno> alumnos;

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    @Override
    public void startDocument() throws SAXException {
        cadena = new StringBuilder();
        alumnos = new ArrayList<Alumno>();
        System.out.println("startDocument");

    }

    @Override
    public void startElement(String uri, String nombreLocal, String nombreCualif, Attributes atrbts) throws SAXException {
        cadena.setLength(0);
        if (nombreCualif.equals("alumno")) {
            alumno = new Alumno();
        }

        System.out.println("startElement: " + nombreLocal + " " + nombreCualif);
    }

    @Override
    public void characters(char[] chars, int inicio, int lon) throws SAXException {
        cadena.append(chars, inicio, lon);
        System.out.println("dato final: " + cadena);
    }
    
    @Override
    public void endElement(String uri, String nombreLocal, String nombreCualif) throws SAXException {
        if(nombreCualif.equals("nombre")){
            alumno.setNombre(cadena.toString());
        }else if (nombreCualif.equals("alumno")){
            alumnos.add(alumno);
        }
        System.out.println("endtElement: "+nombreLocal+ " "+nombreCualif);
    }
    
    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument");
       
    }
}
