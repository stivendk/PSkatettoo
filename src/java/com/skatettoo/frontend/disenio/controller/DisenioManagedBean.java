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
    private List<Disenio> lisdis;
    private EstiloDisenio estil;
    private Usuario usuario;
    @EJB
    private DisenioFacadeLocal diseniofc;
    @EJB
    private EstiloDisenioFacadeLocal estilfc;
    @EJB
    private UsuarioFacadeLocal usuariofc;
    

    public Disenio getDisenio() {
        return disenio;
    }
    
    public Disenio getDisenioKey(Integer id) {
        return diseniofc.find(id);
    }

    public void setDisenio(Disenio disenio) {
        this.disenio = disenio;
    }

    public List<Disenio> getLisdis() {
        lisdis = diseniofc.findAll();
        return lisdis;
    }

    public void setLisdis(List<Disenio> lisdis) {
        this.lisdis = lisdis;
    }

    public EstiloDisenio getEstil(Integer id) {
        return estilfc.find(id);
    }

    public void setEstil(EstiloDisenio estil) {
        this.estil = estil;
    }

    public Usuario getUsuario(Integer id) {
        return usuariofc.find(id);
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public DisenioManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        disenio = new Disenio();
        estil = new EstiloDisenio();
        usuario = new Usuario();
    }
    
    public void registrarDisenio(){
        diseniofc.create(disenio);
    }
    
    public void eliminarDisenio(){
        diseniofc.remove(disenio);
    }
    
    public void actualizarDisenio(Disenio d){
        disenio = d;
    }
    
    public void modificarDisenio(){
        diseniofc.edit(disenio);
    }
    
}
