
package controleur.composant;

import Jclasses.Composant;
import Jclasses.ModelComposant;
import Jclasses.TypeComposant;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.ComposantFacade;
import service.ModelComposantFacade;


@ManagedBean
@ViewScoped
public class ComposantControleur {

    @EJB
    private ComposantFacade composantFacade;
    @EJB 
    private ModelComposantFacade modelComposantFacade;
    
    
    private Composant composant;
    private ModelComposant modelComposant;
    
    public ComposantControleur() {
    }
    
    @PostConstruct
    public void init()
    { composant=new Composant(); 
      
    }
    
    public void inserer() {
        try {
            System.out.println(" inserer " + this);
            modelComposant=modelComposantFacade.find(composant.getModelComposant().getId());
            modelComposant.getComposants().add(composant);
            composantFacade.create(composant);
            this.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Composant getComposant() {
        return composant;
    }

    public void setComposant(Composant composant) {
        this.composant = composant;
    }


    

    @Override
    public String toString() {
        return "{Composant" + "Composant=" + composant + '}';
    }
    
    
}
