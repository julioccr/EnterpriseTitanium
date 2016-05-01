/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.schedule.ejb;

import com.modules.schedule.models.CuentaUsuarioComp;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Julio Cortorreal
 */
@Stateless
public class CuentaUsuarioCompFacade extends AbstractFacade<CuentaUsuarioComp> {
    @PersistenceContext(unitName = "TitaniumDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaUsuarioCompFacade() {
        super(CuentaUsuarioComp.class);
    }
    
}
