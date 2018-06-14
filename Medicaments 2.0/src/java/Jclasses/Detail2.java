
package Jclasses;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Detail2 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double quantite;
    
    @ManyToOne
    private LigneFacture ligneFacture;
    @ManyToOne
    private Medicament medicament;
    private UniteMesure uniteMesure; //Enum
    
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

    public LigneFacture getLigneFacture() {
        return ligneFacture;}

    public void setLigneFacture(LigneFacture ligneFacture) {
        this.ligneFacture = ligneFacture;}

    public Medicament getMedicament() {
        return medicament;}

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;}

    public UniteMesure getUniteMesure() {
        return uniteMesure;}

    public void setUniteMesure(UniteMesure uniteMesure) {
        this.uniteMesure = uniteMesure;}

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
        final Detail2 other = (Detail2) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Detail2{" + "id=" + id + '}';
    }
    
 
    
}
