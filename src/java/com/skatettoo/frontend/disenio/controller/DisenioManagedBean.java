/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.disenio.controller;

import com.skatettoo.backend.persistence.entities.Disenio;
import com.skatettoo.backend.persistence.entities.EstiloDisenio;
import com.skatettoo.backend.persistence.entities.Usuario;
import com.skatettoo.backend.persistence.facade.DisenioFacadeLocal;
import com.skatettoo.backend.persistence.facade.EstiloDisenioFacadeLocal;
import com.skatettoo.backend.persistence.facade.UsuarioFacadeLocal;
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
@Named(value = "disenioManagedBean")
@SessionScoped
public class DisenioManagedBean implements Serializable {

    private Disenio disenio;
    @EJB
    private DisenioFacadeLocal diseniofc;
    

    public Disenio getDisenio() {
        return disenio;
    }
    
    public Disenio getDisenioKey(Integer id) {
        return diseniofc.find(id);
    }

    public void setDisenio(Disenio disenio) {
        this.disenio = disenio;
    }
    
    public DisenioManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        disenio = new Disenio();
    }
    
    public void registrarDisenio(){
        diseniofc.create(disenio);
    }
    
    public void eliminarDisenio(Disenio disenio){
        diseniofc.remove(disenio);
    }
    
    public void actualizarDisenio(Disenio d){
        disenio = d;
    }
    
    public void modificarDisenio(){
        diseniofc.edit(disenio);
    }
    
    public List<Disenio> listarDisenio(){
        return diseniofc.findAll();
    }
}
