/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.usuario.converter;

import com.skatettoo.backend.persistence.entities.EstadoUsuario;
import com.skatettoo.frontend.util.AbstractConvertidores;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author StivenDavid
 */
@FacesConverter(forClass = EstadoUsuario.class)
public class EstadoUsuarioConverter extends AbstractConvertidores{

    public EstadoUsuarioConverter() {
        this.nombreMB = "estadoUsuarioManagedBean";
    }
    
    
}
