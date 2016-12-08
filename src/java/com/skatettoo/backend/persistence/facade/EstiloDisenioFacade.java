/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.backend.persistence.facade;

import com.skatettoo.backend.persistence.entities.EstiloDisenio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author StivenDavid
 */
@Stateless
public class EstiloDisenioFacade extends AbstractFacade<EstiloDisenio> implements EstiloDisenioFacadeLocal {

    @PersistenceContext(unitName = "PSkatettooPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstiloDisenioFacade() {
        super(EstiloDisenio.class);
    }

    @Override
    public EstiloDisenio verEstilo(String id) {
        List<EstiloDisenio> estad;
        Query q = em.createNativeQuery("SELECT nombreEstilo FROM estilo_disenio WHERE idEstiloDisenio = '?'", EstiloDisenio.class);
        TypedQuery<EstiloDisenio> q2 = em.createNamedQuery("EstiloDisenio.findByIdEstiloDisenio", EstiloDisenio.class);
        q2.setParameter("nombreEstilo", id);
        q.setParameter(1, id);
        estad = q2.getResultList();
        if (estad != null && estad.size() >0){
            return q2.getResultList().get(0);
        } else {
            return null;
        }
    }
    
}
