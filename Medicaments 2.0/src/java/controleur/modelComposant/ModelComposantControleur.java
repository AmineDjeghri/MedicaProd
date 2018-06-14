
package controleur.modelComposant;

import Jclasses.ModelComposant;
import Jclasses.TypeComposant;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.ModelComposantFacade;


@ManagedBean
@ViewScoped
public class ModelComposantControleur {

    @EJB
    private ModelComposantFacade modelCompFacade;
    
    private ModelComposant modelComposant;
    private TypeComposant tabTypeComposant[];
    
    public ModelComposantControleur() {
    }
    
    @PostConstruct
    public void init()
    { modelComposant=new ModelComposant();  
      tabTypeComposant=TypeComposant.values();
    }
    
    public void inserer() {
        try {
            System.out.println(" inserer " + this);
            modelCompFacade.create(modelComposant);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ModelComposant getModelComposant() {
        return modelComposant;
    }

    public void setModelComposant(ModelComposant modelComposant) {
        this.modelComposant = modelComposant;
    }

    public TypeComposant[] getTabTypeComposant() {
        return tabTypeComposant;
    }

    //pas be soin de set tabTypeComposant
    
    

    @Override
    public String toString() {
        return "ModelCompControleur{" + "modelComposant=" + modelComposant + '}';
    }
    
    
}
