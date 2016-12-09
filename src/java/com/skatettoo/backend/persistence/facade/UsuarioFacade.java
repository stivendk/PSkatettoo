/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.backend.persistence.facade;

import com.skatettoo.backend.persistence.entities.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "PSkatettooPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario login(Usuario usr){
        Usuario us = null; 
        TypedQuery<Usuario> q;
        try {
            q = em.createQuery("FROM usuario WHERE usuario.username = ?1 and usuario.password = ?2",Usuario.class);
            q.setParameter(1, usr.getUsername());
            q.setParameter(2, usr.getPassword());
            if (!q.getResultList().isEmpty()) {
                us = q.getResultList().get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return us;
    }
}
