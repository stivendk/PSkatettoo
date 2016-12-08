/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.usuario.controller;

import com.skatettoo.backend.persistence.entities.Noticia;
import com.skatettoo.backend.persistence.facade.NoticiaFacadeLocal;
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
@Named(value = "noticiaManagedBean")
@SessionScoped
public class NoticiaManagedBean implements Serializable {

    private Noticia noticia;
    @EJB
    private NoticiaFacadeLocal noticiafc;
    
    public NoticiaManagedBean() {
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }
    
    @PostConstruct
    public void init(){
        noticia = new Noticia();
    }
    
    public void publicarNoticia(){
        noticiafc.create(noticia);
    }
    public void eliminarNoticia(){
        noticiafc.remove(noticia);
    }
    public void modificarNoticia(){
        noticiafc.edit(noticia);
    }
    public void actualizarNoticia(Noticia n){
        noticia = n;
    }
    public List<Noticia> listarNoticia(){
        return noticiafc.findAll();
    }
}
