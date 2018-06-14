
package service;

import Jclasses.Detail;
import Jclasses.Formule;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fatah
 */

@Stateless
public class FormuleFacade extends AbstractFacade<Formule> {

    @PersistenceContext(unitName = "MEDICAMENT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormuleFacade() {
        super(Formule.class);
    }

    
    public void create(Formule entity, ArrayList<Detail> detail) {
        
    }
    
    @Override
    public void create(Formule entity) {
        if (entity.getMedicaments() != null && ! entity.getMedicaments().isEmpty()){
            //pblm
            entity.setMedicaments(new ArrayList<>());
        }
        
        if (entity.getDetails() == null || entity.getDetails().isEmpty()){
            //pblm je ne dois pas creer une formule sans Details
//            entity.setMedicaments(new ArrayList<>());
        }
        
        
        super.create(entity); //To change body of generated methods, choose Tools | Templates.
    }

    
}
