package Jclasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LigneFacture implements Serializable {

    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double quantite;
    private String lot;
    private Date dateFabrication;
    private Date dateExpiration;
  
    @ManyToOne
    private Facture facture;
    
    
    @ManyToOne
    private Composant composant;
    
    @Enumerated(EnumType.STRING)
    private UniteMesure uniteMesure; //Enum
    
    @OneToMany(mappedBy = "ligneFacture")
    private ArrayList<Detail2> details2;
    
//Constructors:
    
    
    
    //Setters & Getters

    public Integer getId() {
        return id;}

    public void setId(Integer id) {
        this.id = id;}

    public Double getQuantite() {
        return quantite;}

    public void setQuantite(Double quantite) {
        this.quantite = quantite;}

    public String getLot() {
        return lot;}

    public void setLot(String lot) {
        this.lot = lot;}

    public Date getDateFabrication() {
        return dateFabrication;}

    public void setDateFabrication(Date dateFabrication) {
        this.dateFabrication = dateFabrication;}

    public Date getDateExpiration() {
        return dateExpiration;}

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;}

    public Facture getFacture() {
        return facture;}

    public void setFacture(Facture facture) {
        this.facture = facture;}

    public Composant getComposant() {
        return composant;}

    public void setComposant(Composant composant) {
        this.composant = composant;}

    public UniteMesure getUniteMesure() {
        return uniteMesure;}

    public void setUniteMesure(UniteMesure uniteMesure) {
        this.uniteMesure = uniteMesure;}

    public ArrayList<Detail2> getDetails2() {
        return details2;
    }
    
    public void setDetails2(ArrayList<Detail2> details2) {
        this.details2 = details2;}
    
    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LigneFacture other = (LigneFacture) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "LigneFacture{" + "id=" + id + '}';
//    }

    @Override
    public String toString() {
        return "LigneFacture{" + "id=" + id + ", quantite=" + quantite + ", lot=" + lot + ", dateFabrication=" + dateFabrication + ", dateExpiration=" + dateExpiration + ", facture=" + facture + ", composant=" + composant + ", uniteMesure=" + uniteMesure + ", details2=" + details2 + '}';
    }
    
    
}
