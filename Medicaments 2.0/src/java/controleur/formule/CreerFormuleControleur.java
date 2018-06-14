package controleur.formule;

import Jclasses.Detail;
import Jclasses.Formule;
import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import service.FormuleFacade;
import service.ModelComposantFacade;

@ManagedBean
@SessionScoped
public class CreerFormuleControleur implements Serializable {

    @EJB
    private FormuleFacade formuleFacade;
    @EJB 
    private ModelComposantFacade modelComposantFacade;

    private Formule formule;
    private ArrayList<Detail> details;
    private Detail detail;

   

    @PostConstruct
    public void init() {
        System.out.println(" init FormuleControler ");
        formule = new Formule();
        detail = new Detail();
        details = new ArrayList<>();
    }
    
    
     public void addDetail() {
        detail.setModelComposant(modelComposantFacade.find(detail.getModelComposant().getId()));
         
        detail.setFormule(formule);
        details.add(detail);
        detail = new Detail();
        System.out.println("1 detail ajouté, la taille est de : " + details.size());
    }

     public void modifierDetail(Detail detail){
     details.remove(detail);
     }
     
     public void annulerModif(){
         details.add(detail);
         detail=new Detail();
     }
     
     public void supprimerDetail(Detail detail){
      details.remove(detail);
     
     }
     
    public void inserer() {
        try {
            // automatiquement la table Detail va se remplir quand la formule va se créer 
            //car on l'a spécifié dans l'entité
            if (details != null && !details.isEmpty()) {
                formule.setDetails(details);
                formuleFacade.create(formule);
                
                // on peut appeller INIT mais elle va initaliser le detail aussi , alors qu'on n'a 
                //pas besoin de le reinitialiser vu qu'il est déja réinitialisé quand on fait qu'on on fait ADD
                formule = new Formule();
                details = new ArrayList<>();
                FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Formule crée"));
                FacesContext.getCurrentInstance().getExternalContext().invalidateSession();  
            } else {
                FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Erreur , formule non crée"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("termiiinéééé");
    }

    

    public Formule getFormule() {
        return formule;
    }

    public void setFormule(Formule formule) {
        this.formule = formule;
    }

    @Override
    public String toString() {
        return "CreerFormuleControleur{" + "formule=" + formule + ", details=" + details + ", detail=" + detail + '}';
    }

    public ArrayList<Detail> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<Detail> details) {
        this.details = details;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

}
