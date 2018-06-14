
package controleur.detail;

import Jclasses.Detail;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.DetailFacade;


@ManagedBean
@ViewScoped
public class ListeDetailControleur implements Serializable{
    
    @EJB
    private DetailFacade detailFacade;
    
    private List<Detail> details;
    private Detail selected;

     public ListeDetailControleur() {
    }
    
    @PostConstruct
    public void init()
    { details =detailFacade.findAll();
        
        if(details==null)
        {
            details=new ArrayList<Detail>();
            System.out.println("LISTE DETAILS VIDE");
        }
        
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public Detail getSelected() {
        return selected;
    }

    public void setSelected(Detail selected) {
        this.selected = selected;
    }

}
