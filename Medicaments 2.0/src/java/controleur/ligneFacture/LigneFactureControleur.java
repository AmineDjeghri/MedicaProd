//package controleur.ligneFacture;
//
//import Jclasses.LigneFacture;
//import Jclasses.UniteMesure;
//import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import service.LigneFactureFacade;
//
//@ManagedBean
//@ViewScoped
//public class LigneFactureControleur {
//
//    @EJB
//    private LigneFactureFacade ligneFactureFacade;
//
//    private LigneFacture ligneFacture;
//
//    private UniteMesure tabUniteMesure[];
//
//    public LigneFactureControleur() {
//    }
//
//    @PostConstruct
//    public void init() {
//        ligneFacture = new LigneFacture();
//        tabUniteMesure = UniteMesure.values();
//    }
//
//    public void inserer() {
//        try {
//            System.out.println("insertion");
//            ligneFactureFacade.create(ligneFacture);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public LigneFacture getLigneFacture() {
//        return ligneFacture;
//    }
//
//    public void setLigneFacture(LigneFacture ligneFacture) {
//        this.ligneFacture = ligneFacture;
//    }
//
//    public UniteMesure[] getTabUniteMesure() {
//        return tabUniteMesure;
//    }
//
//    public void setTabUniteMesure(UniteMesure[] tabUniteMesure) {
//        this.tabUniteMesure = tabUniteMesure;
//    }
//
//}
