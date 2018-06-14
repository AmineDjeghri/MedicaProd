
package controleur.modelComposant;

import Jclasses.ModelComposant;
import Jclasses.TypeComposant;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import service.ModelComposantFacade;


@ManagedBean
@ViewScoped
public class ModifierModelComposantControleur {

    @EJB
    private ModelComposantFacade modelCompFacade;
    
    private ModelComposant modelComposant;
    private TypeComposant tabTypeComposant[];
    
    public ModifierModelComposantControleur() {
    }
    
    @PostConstruct
    public void init()
    {    String idParam=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("mc_id");
        if(idParam!=null && !"".equals(idParam)){
        modelComposant=modelCompFacade.find(Integer.parseInt(idParam));
      tabTypeComposant=TypeComposant.values();
            System.out.println("init de modifier composant modele activée");
        }
        System.out.println("probleme dans le idparam"+idParam);
    }
    
    public void modifier() {
        try {
            System.out.println(" inserer " + this);
            modelCompFacade.edit(modelComposant);
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
