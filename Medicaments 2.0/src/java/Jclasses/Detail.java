package Jclasses;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Detail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double ordre, quantite;

    @ManyToOne
    private ModelComposant modelComposant;
    @ManyToOne
    private Formule formule;
    private UniteMesure uniteMesure; //enum
  
    //Constructors:
    

 //Setters & Getters

    public Integer getId() {
        return id;}

    public void setId(Integer id) {
        this.id = id;}

    public Double getOrdre() {
        return ordre;}

    public void setOrdre(Double ordre) {
        this.ordre = ordre;}

    public Double getQuantite() {
        return quantite;}

    public void setQuantite(Double quantite) {
        this.quantite = quantite;}

    public ModelComposant getModelComposant() {
        return modelComposant;}

    public void setModelComposant(ModelComposant modelComposant) {
        this.modelComposant = modelComposant;}

    public Formule getFormule() {
        return formule;}

    public void setFormule(Formule formule) {
        this.formule = formule;}

    public UniteMesure getUniteMesure() {
        return uniteMesure;}

    public void setUniteMesure(UniteMesure uniteMesure) {
        this.uniteMesure = uniteMesure;}
   //
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Detail other = (Detail) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Detail{" + "id=" + id + '}';
    }
    
    
    
    
    
}
