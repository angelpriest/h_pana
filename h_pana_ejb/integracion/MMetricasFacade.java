/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion;

import entidades.MMetricas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan Carlos
 */
@Stateless
public class MMetricasFacade extends AbstractFacade<MMetricas> implements MMetricasFacadeLocal {

    @PersistenceContext(unitName = "h_pana_ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MMetricasFacade() {
        super(MMetricas.class);
    }
    
}
