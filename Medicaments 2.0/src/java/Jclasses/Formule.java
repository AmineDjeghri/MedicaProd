package Jclasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Formule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nom;
    private String nomScientifique;
     
    @OneToMany(mappedBy = "formule", cascade = CascadeType.ALL)
    private ArrayList<Detail> details;
   
    @OneToMany(mappedBy = "formule")
    private ArrayList<Medicament> medicaments;


    public Integer getId() {
        return id;}

    public void setId(Integer id) {
        this.id = id;}

    public String getNom() {
        return nom;}

    public void setNom(String nom) {
        this.nom = nom;}
    
    public String getNomScientifique(){
        return nomScientifique;}
    
    public void setNomScientifique(String nomScientifique){
        this.nomScientifique=nomScientifique;}
    
    public ArrayList<Detail> getDetails() {
        return details;}

    public void setDetails(ArrayList<Detail> details) {
        this.details = details;}

    public ArrayList<Medicament> getMedicaments() {
        return medicaments;}

    public void setMedicaments(ArrayList<Medicament> medicaments) {
        this.medicaments = medicaments;}

    
    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final Formule other = (Formule) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
 

    @Override
    public String toString() {
        return "Formule{" + "id=" + id + ", nom=" + nom + ", nomScientifique=" + nomScientifique + ", details=" + details + ", medicaments=" + medicaments + '}';
    }
}


