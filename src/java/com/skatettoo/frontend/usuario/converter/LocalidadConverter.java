/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.usuario.converter;

import com.skatettoo.backend.persistence.entities.Localidad;
import com.skatettoo.frontend.util.AbstractConvertidores;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author StivenDavid
 */
@FacesConverter(forClass = Localidad.class)
public class LocalidadConverter extends AbstractConvertidores{

    public LocalidadConverter() {
        this.nombreMB = "localidadManagedBean";
    }
    
}
