package Jclasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ModelComposant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String nom;

    @OneToMany(mappedBy = "modelComposant")
    private ArrayList<Detail> details;
    @OneToMany(mappedBy = "modelComposant")
    private ArrayList<Composant> composants;
    
    @Enumerated(EnumType.STRING)
    private TypeComposant typeComposant;
    
    
    //Constructors:
    
    
    
//Setters & Getters

    public Integer getId() {
        return id;}

    public void setId(Integer id) {
        this.id = id;}

    public String getCode() {
        return code;}

    public void setCode(String code) {
        this.code = code;}

    public String getNom() {
        return nom;}

    public void setNom(String nom) {
        this.nom = nom;}

    public ArrayList<Detail> getDetails() {
        return details;}

    public void setDetails(ArrayList<Detail> details) {
        this.details = details;}

    public ArrayList<Composant> getComposants() {
        return composants;}

    public void setComposants(ArrayList<Composant> composants) {
        this.composants = composants;}

    public TypeComposant getTypeComposant() {
        return typeComposant;}

    public void setTypeComposant(TypeComposant typeComposant) {
        this.typeComposant = typeComposant;}
    
//

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final ModelComposant other = (ModelComposant) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModelComposant{" + "id=" + id + '}';
    }
    
   

}
