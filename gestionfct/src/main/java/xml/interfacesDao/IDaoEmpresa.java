/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.interfacesDao;

import java.util.ArrayList;
import com.iesjulioverne.informatica.gestionfct.entities.Empresa;

/**
 *
 * @author Raquel
 */
public interface IDaoEmpresa {
    
    public void guardarEmpresa(Empresa e);
    
    public ArrayList<Empresa> listar_empresas();
}
