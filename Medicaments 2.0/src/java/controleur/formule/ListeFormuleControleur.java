package controleur.formule;

import Jclasses.Formule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.FormuleFacade;

@ManagedBean
@ViewScoped
public class ListeFormuleControleur implements Serializable {

    @EJB
    private FormuleFacade formuleFacade;

    private List<Formule> formules;
    

    @PostConstruct
    public void init() {
        System.out.println(" init LISTEFormuleControler ");
        formules = formuleFacade.findAll();
        
        if (formules == null){
            formules = new ArrayList<>();
            System.out.println("liste formules VIDE");
        }
        
    }
    
    public void supprimer(Formule formule){
        formuleFacade.remove(formule);
    }

    public List<Formule> getFormules() {
        return formules;
    }

    public void setFormules(List<Formule> formules) {
        this.formules = formules;
    }

    

    

}
