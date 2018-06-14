package controleur.modelComposant;

import Jclasses.ModelComposant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.ModelComposantFacade;

@ManagedBean
@ViewScoped
public class ListeModelComposantControleur implements Serializable {

    @EJB
    private ModelComposantFacade modelComposantFacade;

    private List<ModelComposant> modelComposants;
    private ModelComposant selected;

    @PostConstruct
    public void init() {
        System.out.println(" init LISTEFormuleControler ");
        modelComposants = modelComposantFacade.findAll();
        
        if (modelComposants == null){
            modelComposants = new ArrayList<>();
            System.out.println("LISTE MODELE COMPOSANTS VIDE");
        }
        
    }
    
    public void supprimer(ModelComposant modelComposant)
    {
        modelComposantFacade.remove(modelComposant);
    }

    public List<ModelComposant> getModelComposants() {
        return modelComposants;
    }

    public void setModelComposants(List<ModelComposant> modelComposants) {
        this.modelComposants = modelComposants;
    }

    public ModelComposant getSelected() {
        return selected;
    }

    public void setSelected(ModelComposant selected) {
        this.selected = selected;
    }

  

    

}
