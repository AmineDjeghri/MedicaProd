package Jclasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Medicament implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateFabrication;
    private Date dateExpiration;
    private String lot;
    private Double quantite;

    @ManyToOne
    private Formule formule;
    @OneToMany(mappedBy = "medicament")
    private ArrayList<Detail2> details2;
    
    @Enumerated(EnumType.STRING)
    private TypeMedicament typeMedicament;

    //Constructors:
    public Medicament() {
    }

    //Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateFabrication() {
        return dateFabrication;
    }

    public void setDateFabrication(Date dateFabrication) {
        this.dateFabrication = dateFabrication;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Formule getFormule() {
        return formule;
    }

    public void setFormule(Formule formule) {
        this.formule = formule;
    }

    public ArrayList<Detail2> getDetails2() {
        return details2;
    }

    public void setDetails2(ArrayList<Detail2> details2) {
        this.details2 = details2;
    }

    public TypeMedicament getTypeMedicament() {
        return typeMedicament;
    }

    public void setTypeMedicament(TypeMedicament typeMedicament) {
        this.typeMedicament = typeMedicament;
    }

    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Medicament other = (Medicament) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Medicament{" + "id=" + id + '}';
    }

}
