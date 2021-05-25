/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.handler;

import com.iesjulioverne.informatica.gestionfct.entities.Empresa;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Raquel
 */
public class EmpresaHandlerXML extends DefaultHandler {

    private StringBuilder cadena;
    private Empresa empresa;
    private ArrayList<Empresa> empresas;

    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    @Override
    public void startDocument() throws SAXException {
        cadena = new StringBuilder();
        empresas = new ArrayList<Empresa>();
        System.out.println("startDocument");
    }

    @Override
    public void startElement(String uri, String nombreLocal, String nombreCualif, Attributes atrbts) throws SAXException {
        cadena.setLength(0);
        if (nombreCualif.equals("empresa")) {
            empresa = new Empresa();
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
        if (nombreCualif.equals("nombre")) {
            empresa.setNombre(cadena.toString());
        } else if (nombreCualif.equals("empresa")) {
            empresas.add(empresa);
        }
        System.out.println("endtElement: " + nombreLocal + " " + nombreCualif);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument");

    }
}
