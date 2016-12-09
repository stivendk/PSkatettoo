/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.usuario.controller;

import com.skatettoo.backend.persistence.entities.Usuario;
import com.skatettoo.backend.persistence.facade.UsuarioFacadeLocal;
import com.skatettoo.frontend.util.Managedbean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author StivenDavid
 */
@Named(value = "usuarioManagedBean")
@SessionScoped
public class UsuarioManagedBean implements Serializable, Managedbean<Usuario> {

    private Usuario usuario;
    @EJB
    private UsuarioFacadeLocal usuariofc;

    public UsuarioManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Usuario getUsuarioKey(Integer id) {
        return usuariofc.find(id);
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public void registrarUsuario() {
        usuariofc.create(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        usuariofc.remove(usuario);
    }

    public void modificarUsuario() {
        usuariofc.edit(usuario);
    }

    public void actualizarUsuario(Usuario u) {
        usuario = u;
    }

    public List<Usuario> listarUsuario() {
        return usuariofc.findAll();
    }

    public String login() {
        Usuario uss;
        String redir = null;
        try {
            uss = usuariofc.login(usuario);
            if (uss!=null) {
                redir = "/pages/entrar";
            }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Credenciales incorrectas"));
            } 
        }catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error!"));
        }
        return redir;
    }

    @Override
    public Usuario getObject(Integer i) {
        return usuariofc.find(i);

    }
}
