
package controleur.session;

import Session.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import service.UtilisateurFacade;


@ManagedBean
@SessionScoped
public class LoginUtilisateurControleur {

@EJB    
private UtilisateurFacade utilisateurFacade;    

private Utilisateur utilisateur;

//utilisé dans la nouvelle méthode de login
private Utilisateur u;

//liste utilisée dans l'ancienne méthode de login
//private List<Utilisateur> utilisateurs;
    
@PostConstruct
public void init()
{ utilisateur=new Utilisateur();
 u=new Utilisateur();
//utilisateurs=new ArrayList<>();
}
public String login(){
    String outcome="";
    try{
    u=utilisateurFacade.loginByUID(utilisateur.getIdUtilisateur());
    System.out.println(u);

        if(u.getMdp().equals(utilisateur.getMdp()))
        {FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("c'est correcte"));
            outcome="/template/menu";
        }
        else
        {FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("mdp incorrecte"));
        outcome="/app/session/connexion";
        }
        
    }catch(Exception e)
    {FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("username non trouvé"));
     outcome="/app/session/connexion";
    }
    return outcome;    
    
}




//    public void login2(){
//        
//        utilisateurs=utilisateurFacade.findAll();
//        
//        for(Utilisateur u:utilisateurs)
//        {   
//            if(utilisateur.equalsByIDU_MDP(u))
//        {   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("trouvé"));
//                return;}
//          }
//            
//           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("utilisateur non trouvé"));
// 
//    }
 

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    
}
