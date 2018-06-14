/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Jclasses.Facture;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fatah
 */
@Stateless
public class FactureFacade extends AbstractFacade<Facture> {

    @PersistenceContext(unitName = "MEDICAMENT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FactureFacade() {
        super(Facture.class);
    }

    @Override
    public void create(Facture entity) {

//        entity.setDateFacture(new Date());
        super.create(entity);

    }

}
