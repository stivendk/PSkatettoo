/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.usuario.controller;

import com.skatettoo.backend.persistence.entities.Usuario;
import com.skatettoo.backend.persistence.facade.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author StivenDavid
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable{

    private Usuario usu;
    @EJB
    private UsuarioFacadeLocal usufc;
    
    @PostConstruct
    public void init() {
        usu = new Usuario();
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }
    
    public List<Usuario> lisUsuario(){
        return usufc.findAll();
    }
    
    public String login(){
        String redir = null;
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            if (usufc.login(usu)!=null) {
                context.getExternalContext().getSessionMap().put("usu", usu);
                redir = "/pages/entrar";
            }else{
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Credenciales erroneas"));
            }
        }catch(Exception e){
            context.addMessage(null, new FacesMessage("¡Vaya! Parece que ocurrio un error"));
        }
        return redir;
    }
}
