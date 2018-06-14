package controleur.facture;

import Jclasses.Facture;
import Jclasses.Formule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.FactureFacade;


@ManagedBean
@ViewScoped
public class ListeFactureControleur implements Serializable {

    @EJB
    private FactureFacade factureFacade;

    private List<Facture> factures;
    private Facture selected;

    @PostConstruct
    public void init() {
        System.out.println(" init LISTE Factures ");
        factures=factureFacade.findAll();
        
        if (factures == null){
            factures = new ArrayList<>();
            System.out.println("liste factures VIDE");
        }
        
    }

    public void supprimer(Facture f){
        try {
            factureFacade.remove(f);
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public Facture getSelected() {
        return selected;
    }

    public void setSelected(Facture selected) {
        this.selected = selected;
    }

    

    

}
