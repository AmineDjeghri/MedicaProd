/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Jclasses.Detail2;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fatah
 */
@Stateless
public class Detail2Facade extends AbstractFacade<Detail2> {

    @PersistenceContext(unitName = "MEDICAMENT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Detail2Facade() {
        super(Detail2.class);
    }
    
}
