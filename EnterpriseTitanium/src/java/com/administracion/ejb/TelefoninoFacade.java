/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejb;

import com.administracion.models.Telefonino;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Julio Cortorreal
 */
@Stateless
public class TelefoninoFacade extends AbstractFacade<Telefonino> {
    @PersistenceContext(unitName = "TitaniumDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TelefoninoFacade() {
        super(Telefonino.class);
    }
    
}
