/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.DaoImplements;

import com.iesjulioverne.informatica.gestionfct.entities.Empresa;
import java.util.ArrayList;
import xml.handler.EmpresaHandlerXML;
import xml.interfacesDao.IDaoEmpresa;

/**
 *
 * @author Raquel
 */
public class DaoEmpresaXML extends DaoXML implements IDaoEmpresa {

    private String nombreFichero;
    private EmpresaHandlerXML handler;

    public DaoEmpresaXML(String nombreFichero) {
        super(new EmpresaHandlerXML());
        handler = (EmpresaHandlerXML) this.getHandler();
        this.nombreFichero = nombreFichero;
    }
    
    public void guardarEmpresa(Empresa e){
        
    }
    
    public ArrayList<Empresa> verEmpresas(){
        try{
            this.leerXML(nombreFichero);
            return handler.getEmpresas();
        } catch (Exception ex){
            return null;
        }
    }
}
