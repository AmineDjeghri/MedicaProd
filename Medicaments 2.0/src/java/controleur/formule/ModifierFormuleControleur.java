package controleur.formule;

import Jclasses.Detail;
import Jclasses.Formule;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import service.FormuleFacade;
import service.ModelComposantFacade;

//Cette classe n'est pas supposée utilisé le sessionScoped mais c'est juste pour apprendre à le faire apars
//le LOGIN

@ManagedBean
@SessionScoped
public class ModifierFormuleControleur implements Serializable {

    @EJB
    private FormuleFacade formuleFacade;
    @EJB 
    private ModelComposantFacade modelComposantFacade;

    private Formule formule;
    private Detail detail;

   

    @PostConstruct
    public void init() {
        String idParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("f_id");
        formule=new Formule();
        detail = new Detail();
        if(idParam!=null && "".equals(idParam));
        {
        System.out.println(" init FormuleControler ");
        formule = formuleFacade.find(Integer.parseInt(idParam));
        
        }
    }
    
    public void annuler(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    
     public void addDetail() {
        detail.setModelComposant(modelComposantFacade.find(detail.getModelComposant().getId()));
         
        detail.setFormule(formule);
        formule.getDetails().add(detail);
        detail = new Detail();
        
    }

     public void modifierDetail(Detail detail){
     formule.getDetails().remove(detail);
     }
     
     
     public void supprimerDetail(Detail detail){
      formule.getDetails().remove(detail);
     
     }
     
    public void modifier() {
        try {
            // automatiquement la table Detail va se remplir quand la formule va se créer 
            //car on l'a spécifié dans l'entité
            if (formule.getDetails() != null && !formule.getDetails().isEmpty()) {
                formuleFacade.edit(formule);
                
                // on peut appeller INIT mais elle va initaliser le detail aussi , alors qu'on n'a 
                //pas besoin de le reinitialiser vu qu'il est déja réinitialisé quand on fait qu'on on fait ADD
                //gain de perfomrance
                formule = new Formule();
                FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Formule modifié"));
                //pour fermer la SESSION :D 
                FacesContext.getCurrentInstance().getExternalContext().invalidateSession();  
            } else {
                FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Erreur , formule non modifié"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("termiiinéééé");
    }

    public void action() {
        System.out.println(" action FormuleControler ");
        System.out.println(this);
    }

    public Formule getFormule() {
        return formule;
    }

    public void setFormule(Formule formule) {
        this.formule = formule;
    }

   
    

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

}
