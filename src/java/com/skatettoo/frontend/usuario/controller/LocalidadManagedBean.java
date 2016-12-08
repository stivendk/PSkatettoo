/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.usuario.controller;

import com.skatettoo.backend.persistence.entities.Localidad;
import com.skatettoo.backend.persistence.facade.LocalidadFacadeLocal;
import com.skatettoo.frontend.util.Managedbean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author StivenDavid
 */
@Named(value = "localidadManagedBean")
@SessionScoped
public class LocalidadManagedBean implements Serializable, Managedbean <Localidad>{

    private Localidad local;
    @EJB
    private LocalidadFacadeLocal localfc;
    
    public LocalidadManagedBean() {
    }

    public Localidad getLocal() {
        return local;
    }

    public void setLocal(Localidad local) {
        this.local = local;
    }
    
    @PostConstruct
    public void init(){
        local = new Localidad();
    }
    
    public List<Localidad> listarLocalidad(){
        return localfc.findAll();
    }

    @Override
    public Localidad getObject(Integer i) {
        return localfc.find(i);
    }
}
