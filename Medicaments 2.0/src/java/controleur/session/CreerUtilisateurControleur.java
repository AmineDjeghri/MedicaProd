
package controleur.session;

import Session.Utilisateur;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import service.UtilisateurFacade;


@ManagedBean
@SessionScoped
public class CreerUtilisateurControleur {

@EJB    
private UtilisateurFacade utilisateurFacade;    

private Utilisateur utilisateur;
    
@PostConstruct
public void init()
{ utilisateur=new Utilisateur();
    
}
    public void inserer(){
        try{
        if(utilisateur!=null)
        {utilisateurFacade.create(utilisateur);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("utilisateur crée"));
        }}
        catch(Exception e)
        {FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("psoeudo existe déja!"));}
    }
    

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    
}
