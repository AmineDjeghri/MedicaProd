package controleur.facture;

import Jclasses.Composant;
import Jclasses.Facture;
import Jclasses.LigneFacture;
import Jclasses.UniteMesure;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.ComposantFacade;
import service.FactureFacade;

@ManagedBean
@ViewScoped
public class FactureControleur {

    @EJB
    private FactureFacade factureFacade;
    @EJB
    private ComposantFacade composantFacade;
    
    // liste des composants pour leur ajouter les lignes quand on insert <==> on les modifie
    private List<Composant> composantsTemp;
    
    private Facture facture;
    private ArrayList<LigneFacture> lignesFactures;
    private LigneFacture ligneFacture;
    private UniteMesure tabUniteMesure[];

    public FactureControleur() {
    }

    @PostConstruct
    public void init() {
        facture = new Facture();
        lignesFactures = new ArrayList<>();
        facture.setDateFacture(new Date());

        ligneFacture = new LigneFacture();

        tabUniteMesure = UniteMesure.values();
        composantsTemp=new ArrayList<>();
    }

    public void add() {
        System.out.println(" before ligneFacture " + ligneFacture);
        //récuperer tout le composant car notre converter récupère que l'ID
        Composant c = composantFacade.find(ligneFacture.getComposant().getId());
        c.getLignesFacture().add(ligneFacture);
        composantsTemp.add(c);
        
        ligneFacture.setComposant(c);

        ligneFacture.setFacture(facture);
        lignesFactures.add(ligneFacture);

        ligneFacture = new LigneFacture();

        System.out.println(" after ligneFacture " + ligneFacture);
        System.out.println(" after liste " + lignesFactures);
    }

    

    public void inserer() {
        try {
            System.out.println("insertion");
            facture.setLignesFacture(lignesFactures);
            for(Composant c:composantsTemp)
                composantFacade.edit(c);
            
            factureFacade.create(facture);
            
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public ArrayList<LigneFacture> getLignesFactures() {
        return lignesFactures;
    }

    public void setLignesFactures(ArrayList<LigneFacture> lignesFactures) {
        this.lignesFactures = lignesFactures;
    }

    public LigneFacture getLigneFacture() {
        return ligneFacture;
    }

    public void setLigneFacture(LigneFacture ligneFacture) {
        this.ligneFacture = ligneFacture;
    }

    public UniteMesure[] getTabUniteMesure() {
        return tabUniteMesure;
    }

    public void setTabUniteMesure(UniteMesure[] tabUniteMesure) {
        this.tabUniteMesure = tabUniteMesure;
    }

}
