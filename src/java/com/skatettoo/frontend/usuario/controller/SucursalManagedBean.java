/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.usuario.controller;

import com.skatettoo.backend.persistence.entities.Sucursal;
import com.skatettoo.backend.persistence.facade.SucursalFacadeLocal;
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
@Named(value = "sucursalManagedBean")
@SessionScoped
public class SucursalManagedBean implements Serializable {

    private Sucursal sucur;
    @EJB
    private SucursalFacadeLocal sucurfc;

    public SucursalManagedBean() {
    }

    public Sucursal getSucur() {
        return sucur;
    }

    public void setSucur(Sucursal sucur) {
        this.sucur = sucur;
    }

    @PostConstruct
    public void init() {
        sucur = new Sucursal();
    }

    public void registrarSucursal() {
        sucurfc.create(sucur);
    }

    public void eliminarSucursal(Sucursal sucur) {
        sucurfc.remove(sucur);
    }

    public void actualizar(Sucursal su) {
        sucur = su;
    }

    public void modificarSucursal() {
        sucurfc.edit(sucur);
    }

    public List<Sucursal> listarSucursal() {
        return sucurfc.findAll();
    }
}
