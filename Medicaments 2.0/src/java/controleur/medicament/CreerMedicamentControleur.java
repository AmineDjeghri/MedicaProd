package controleur.medicament;

import Jclasses.Composant;
import Jclasses.Detail;
import Jclasses.Formule;
import Jclasses.LigneFacture;
import Jclasses.Medicament;
import Jclasses.ModelComposant;
import Jclasses.TypeMedicament;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.FormuleFacade;
import service.MedicamentFacade;

@ManagedBean
@ViewScoped
public class CreerMedicamentControleur implements Serializable {

    @EJB
    private MedicamentFacade medeciamanetFacade;

    //
    @EJB
    FormuleFacade formuleFacade;
    private Medicament medicament;
    private TypeMedicament tabTypeMedicament[];

    // les lignes factures associés à la formule du médicament et toute liste pour l'avoir
    private List<LigneFacture> ligneFactures;
    private List<ModelComposant> modelComposants;
    private List<Composant> composants;
    private List<Detail> details;

    public CreerMedicamentControleur() {
    }

    @PostConstruct
    public void init() {
        System.out.println("init Medicament");
        medicament = new Medicament();
        tabTypeMedicament = TypeMedicament.values();
        details = new ArrayList<>();
        composants = new ArrayList<>();
        modelComposants = new ArrayList<>();
        ligneFactures = new ArrayList<>();
    }

    public void obtenirLigneFacture() {
        Formule formule;
     
        formule = medicament.getFormule();
        formule=formuleFacade.find(formule.getId());
        
        
        
        details = formule.getDetails();
        
        for (int i = 0, x = details.size(); i < x; i++) {
            modelComposants.add(details.get(i).getModelComposant());
        }

        for (ModelComposant mc : modelComposants) {
            for (Composant c : mc.getComposants()) {
                composants.add(c);
            }
        }
        
        
        for (Composant c : composants) {
            for (LigneFacture l : c.getLignesFacture()) 
                ligneFactures.add(l);
        }
        
         for(LigneFacture lf: ligneFactures)
             System.out.println("liiiignes"+lf.getId());
         
    }
    public void inserer() {
        try {
            System.out.println("insertion de médicament" + this);

            medeciamanetFacade.create(medicament);

        } catch (Exception e) {
            System.out.println("EXCEPTION" + e);
        }
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public TypeMedicament[] getTabTypeMedicament() {
        return tabTypeMedicament;
    }

    public void setTabTypeMedicament(TypeMedicament[] tabTypeMedicament) {
        this.tabTypeMedicament = tabTypeMedicament;
    }

    public List<LigneFacture> getLigneFactures() {
        return ligneFactures;
    }

    public void setLigneFactures(List<LigneFacture> ligneFactures) {
        this.ligneFactures = ligneFactures;
    }

    
    @Override
    public String toString() {
        return "MedicamentControleur{" + "medicament=" + medicament + '}';
    }

}
