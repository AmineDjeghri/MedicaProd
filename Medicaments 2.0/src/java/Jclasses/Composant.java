package Jclasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Composant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom, codeBarre;
    
    @ManyToOne
    private ModelComposant modelComposant;
    @OneToMany(mappedBy = "composant")
    private ArrayList<LigneFacture> lignesFacture;

    //Constructors:

  
    
   //Setters & Getters

    public Integer getId() {
        return id;}

    public void setId(Integer id) {
        this.id = id;}

    public String getNom() {
        return nom;}

    public void setNom(String nom) {
        this.nom = nom;}

    public String getCodeBarre() {
        return codeBarre;}

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;}

    public ModelComposant getModelComposant() {
        return modelComposant;}

    public void setModelComposant(ModelComposant modelComposant) {
        this.modelComposant = modelComposant;}

    public ArrayList<LigneFacture> getLignesFacture() {
        return lignesFacture;}

    public void setLignesFacture(ArrayList<LigneFacture> lignesFacture) {
        this.lignesFacture = lignesFacture;}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Composant other = (Composant) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Composant{" + "id=" + id + '}';
    }
    
    
    
    
}
