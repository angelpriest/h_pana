/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion;

import entidades.Agenda;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan Carlos
 */
@Stateless
public class AgendaFacade extends AbstractFacade<Agenda> implements AgendaFacadeLocal {

    @PersistenceContext(unitName = "h_pana_ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgendaFacade() {
        super(Agenda.class);
    }
    
}
