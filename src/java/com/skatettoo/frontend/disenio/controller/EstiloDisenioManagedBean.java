/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.disenio.controller;

import com.skatettoo.backend.persistence.entities.EstiloDisenio;
import com.skatettoo.backend.persistence.facade.EstiloDisenioFacadeLocal;
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
@Named(value = "estiloDisenioManagedBean")
@SessionScoped
public class EstiloDisenioManagedBean implements Serializable, Managedbean <EstiloDisenio> {

    private EstiloDisenio estil;
    @EJB
    private EstiloDisenioFacadeLocal estilfc;
    
    public EstiloDisenioManagedBean() {
    }

    public EstiloDisenio getEstil() {
        return estil;
    }

    public void setEstil(EstiloDisenio estil) {
        this.estil = estil;
    }

    @PostConstruct
    public void init(){
        estil = new EstiloDisenio();
    }
    
    public void registrarEstilo(){
        estilfc.create(estil);
    }
    
    public void eliminarEstilo(EstiloDisenio estil){
        estilfc.remove(estil);
    }
    
    public void actualizarEstilo(EstiloDisenio es){
        estil = es;
    }
    
    public void modificarEstilo(){
        estilfc.edit(estil);
    }
    
    public List<EstiloDisenio> listarDisenio(){
        return estilfc.findAll();
    }

    @Override
    public EstiloDisenio getObject(Integer i) {
        return estilfc.find(i);
    }
}
