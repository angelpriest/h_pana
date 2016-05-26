/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion;

import entidades.HMedico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan Carlos
 */
@Stateless
public class HMedicoFacade extends AbstractFacade<HMedico> implements HMedicoFacadeLocal {

    @PersistenceContext(unitName = "h_pana_ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HMedicoFacade() {
        super(HMedico.class);
    }
    
}
