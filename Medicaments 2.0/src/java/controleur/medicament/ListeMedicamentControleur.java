package controleur.medicament;

import Jclasses.Medicament;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.MedicamentFacade;

@ManagedBean
@ViewScoped
public class ListeMedicamentControleur implements Serializable {

    @EJB
    private MedicamentFacade medicamentFacade;

    private List<Medicament> medicaments;
    private Medicament selected;

    @PostConstruct
    public void init() {
        System.out.println(" init LISTEFormuleControler ");
        medicaments = medicamentFacade.findAll();
        
        if (medicaments == null){
            System.out.println("LISTE MEDICAMENTS VIDE");
            medicaments = new ArrayList<>();
        }
        
    }

    public List<Medicament> getMedicaments() {
        return medicaments;
    }

    //Pas besoin de faire un SET car c'est une liste utilisé que pour affichage
//    public void setMedicaments(List<Medicament> medicaments) {
//        this.medicaments = medicaments;
//    }

    public Medicament getSelected() {
        return selected;
    }

    public void setSelected(Medicament selected) {
        this.selected = selected;
    }

   

   

    

}
