/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Jclasses.LigneFacture;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fatah
 */
@Stateless
public class LigneFactureFacade extends AbstractFacade<LigneFacture> {

    @PersistenceContext(unitName = "MEDICAMENT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LigneFactureFacade() {
        super(LigneFacture.class);
    }
    
}
