/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.DaoImplements;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Raquel
 */
public class DaoXML {

    private DefaultHandler handler;

    public DaoXML(DefaultHandler handler) {
        this.handler = handler;
    }

    public void leerXML(String nombreFichero) throws Exception {

        // Localizar fichero
        File fichero = new File(nombreFichero);
        InputStream entrada = new FileInputStream(fichero);

        // Instancia una factoria
        // Objeto de la clase SaxParser para obtener un lector de archivos XML
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLReader lector = saxParser.getXMLReader();

        lector.setContentHandler(getHandler());
        lector.parse(new InputSource(entrada));
    }

    public DefaultHandler getHandler() {
        return handler;
    }
    
    public void setHandler(DefaultHandler handler){
        this.handler = handler;
    }
}
