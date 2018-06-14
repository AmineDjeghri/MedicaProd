package controleur.ligneFacture;


import Jclasses.LigneFacture;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.LigneFactureFacade;


@ManagedBean
@ViewScoped
public class ListeLigneFactureControleur implements Serializable {

    @EJB
    private LigneFactureFacade ligneFactureFacade; 
    private  List <LigneFacture> listeLigneFactures;


    @PostConstruct
    public void init() {
        System.out.println(" init LISTE ligne facture ");
        listeLigneFactures = ligneFactureFacade.findAll();
        
        if (listeLigneFactures == null){
            listeLigneFactures = new ArrayList<>();
            System.out.println("liste ligne facture  VIDE");
        }
        
    }

    public List<LigneFacture> getListeLigneFactures() {
        return listeLigneFactures;
    }

    public void setListeLigneFactures(List<LigneFacture> listeLigneFactures) {
        this.listeLigneFactures = listeLigneFactures;
    }

    
    

}
