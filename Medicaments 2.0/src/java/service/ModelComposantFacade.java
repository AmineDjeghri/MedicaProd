/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Jclasses.ModelComposant;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fatah
 */
@Stateless
public class ModelComposantFacade extends AbstractFacade<ModelComposant> {

    @PersistenceContext(unitName = "MEDICAMENT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModelComposantFacade() {
        super(ModelComposant.class);
    }
    
}
