package controleur.detail;


import Jclasses.Detail;
import Jclasses.Formule;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.DetailFacade;


@ManagedBean
@ViewScoped
public class CreerDetailControleur implements Serializable {

    @EJB
    private DetailFacade detailFacade;
    
    private Detail detail;

    @PostConstruct
    public void init() {
        System.out.println(" init Detail Controleur ");
        detail = new Detail();
        
    }

    public void inserer() {
        try { detailFacade.create(detail);
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("termiiinéééé");
    }

    public void action() {
        System.out.println(" action FormuleControler ");
        System.out.println(this);
    }



  
}