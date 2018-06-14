
package controleur.composant;

import Jclasses.Composant;
import Jclasses.TypeComposant;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import service.ComposantFacade;


@ManagedBean
@ViewScoped
public class ModifierComposantControleur {

    @EJB
    private ComposantFacade composantFacade;
    
    private Composant composant;
    
    
    public ModifierComposantControleur() {
    }
    
    @PostConstruct
    public void init()
    { String idParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("c_id");
        System.out.println(idParam);
    if(idParam!=null && !"".equals(idParam))
                {
        composant=composantFacade.find(Integer.parseInt(idParam));
                }
    }
    
    public void modifier() {
        try {
            System.out.println(" inserer " + this);
            composantFacade.edit(composant);
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
