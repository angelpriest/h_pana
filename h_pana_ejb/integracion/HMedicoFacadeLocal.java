/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion;

import entidades.HMedico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan Carlos
 */
@Local
public interface HMedicoFacadeLocal {

    void create(HMedico hMedico);

    void edit(HMedico hMedico);

    void remove(HMedico hMedico);

    HMedico find(Object id);

    List<HMedico> findAll();

    List<HMedico> findRange(int[] range);

    int count();
    
}
