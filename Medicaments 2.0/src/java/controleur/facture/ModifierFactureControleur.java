package controleur.facture;

import Jclasses.Composant;
import Jclasses.Facture;
import Jclasses.LigneFacture;
import Jclasses.UniteMesure;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import service.ComposantFacade;
import service.FactureFacade;

@ManagedBean
@ViewScoped
public class ModifierFactureControleur {

    @EJB
    private FactureFacade factureFacade;
    @EJB
    private ComposantFacade composantFacade;

    private Facture facture;
//    private ArrayList<LigneFacture> lignesFactures;
    private LigneFacture ligneFacture;
    private UniteMesure tabUniteMesure[];
    private ArrayList<LigneFacture> lignesFactures;
       private List<Composant> composantsTemp;


    public ModifierFactureControleur() {
    }

    @PostConstruct
    public void init() {
        String idParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("f_id");
        Integer id;
        System.out.println(" idPram |"+idParam+"|" );
        
        if (idParam != null && !"".equals(idParam)) {
            id = Integer.parseInt(idParam);
           
            facture = factureFacade.find(id);
            composantsTemp=new ArrayList<>();
//        lignesFactures = facture.getLignesFacture();
            ligneFacture = new LigneFacture();

            tabUniteMesure = UniteMesure.values();
        }
    }

    public void add() {
        System.out.println(" before ligneFacture " + ligneFacture);
        Composant c = composantFacade.find(ligneFacture.getComposant().getId());
        c.getLignesFacture().add(ligneFacture);
           composantsTemp.add(c);
      ligneFacture.setComposant(c);

        ligneFacture.setFacture(facture);

//        lignesFactures.add(ligneFacture);
        facture.getLignesFacture().add(ligneFacture);

        ligneFacture = new LigneFacture();

        System.out.println(" after ligneFacture " + ligneFacture);
//        System.out.println(" after liste " + lignesFactures);
        System.out.println(" after liste " + facture.getLignesFacture());
    }

    public void modifierLigne(LigneFacture ligneF) {
//        ligneFacture = ligneF;
//        

        facture.getLignesFacture().remove(ligneF);
    }

    public void annulerLigne() {
        facture.getLignesFacture().add(ligneFacture);
        ligneFacture = new LigneFacture();
    }

    public void supprimerLigne(LigneFacture ligne) {
        Composant c= ligne.getComposant();
        System.out.println("LISTE BEDORE 1"+c.getLignesFacture());
        for(int i=0;i<c.getLignesFacture().size();i++)
            if(c.getLignesFacture().get(i).getId()==ligne.getId())
            { c.getLignesFacture().remove(i);
                break;
            }
        
        System.out.println("LISTE BEDORE 2"+c.getLignesFacture());
        
        facture.getLignesFacture().remove(ligne);
    }

    public void modifier() {
        try {
            System.out.println("modification ");
            //facture.setLignesFacture(lignesFactures);
            
            for(Composant c:composantsTemp)
                composantFacade.edit(c);
            
            factureFacade.edit(facture);
            System.out.println(" lignes :: " + ligneFacture);

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
//
//    public ArrayList<LigneFacture> getLignesFactures() {
//        return lignesFactures;
//    }
//
//    public void setLignesFactures(ArrayList<LigneFacture> lignesFactures) {
//        this.lignesFactures = lignesFactures;
//    }

    public LigneFacture getLigneFacture() {
        return ligneFacture;
    }

    public void setLigneFacture(LigneFacture ligneFacture) {
        System.out.println(" set mligne " + ligneFacture);
        this.ligneFacture = ligneFacture;
    }

    public UniteMesure[] getTabUniteMesure() {
        return tabUniteMesure;
    }

    public void setTabUniteMesure(UniteMesure[] tabUniteMesure) {
        this.tabUniteMesure = tabUniteMesure;
    }

}
