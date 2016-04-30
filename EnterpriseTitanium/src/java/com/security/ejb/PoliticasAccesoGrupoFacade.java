/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.ejb;

import com.security.models.PoliticasAccesoGrupo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Julio Cortorreal
 */
@Stateless
public class PoliticasAccesoGrupoFacade extends AbstractFacade<PoliticasAccesoGrupo> {
    @PersistenceContext(unitName = "TitaniumDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PoliticasAccesoGrupoFacade() {
        super(PoliticasAccesoGrupo.class);
    }
    
}
