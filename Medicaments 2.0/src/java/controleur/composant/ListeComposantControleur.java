package controleur.composant;

import Jclasses.Composant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.ComposantFacade;

@ManagedBean
@ViewScoped
public class ListeComposantControleur implements Serializable {

    @EJB
    private ComposantFacade composantFacade;

    private List<Composant> composants;
   

    @PostConstruct
    public void init() {
        System.out.println(" init LISTEFormuleControler ");
        composants = composantFacade.findAll();
        
        if (composants == null){
            composants = new ArrayList<>();
            System.out.println("LISTE DES COMPOSANTS VIDE");
        }
        
    }
    
    public void supprimer(Composant composant){
        composantFacade.remove(composant);
        
    }
    
    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }

   

    

  

    

}
