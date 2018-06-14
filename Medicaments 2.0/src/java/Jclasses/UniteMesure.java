package Jclasses;

public enum UniteMesure {

    MG("milligramme"),
    G("gramme"),
    KG("kilogramme"),
    T("tonne"),
    ML("millilittre"),
    L("litre");

    String nom;

    private UniteMesure(String nom) {
        this.nom = nom;
    }

}
