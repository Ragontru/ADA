/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.interfacesDao;

import java.util.ArrayList;
import com.iesjulioverne.informatica.gestionfct.entities.Tutor;

/**
 *
 * @author Raquel
 */
public interface IDaoTutor {
    
    public void guardarTutor(Tutor t);
    
    public ArrayList<Tutor> listar_tutores();
}
