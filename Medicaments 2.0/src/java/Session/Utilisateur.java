
package Session;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
public class Utilisateur implements Serializable{
@Id
@Column(unique = true)
@GeneratedValue(strategy = GenerationType.IDENTITY)    
private Integer id;

@NotNull
@Column(unique = true)
private String idUtilisateur;
@NotNull 
private String mdp;

private String nom;
private String prenom;


@ManyToMany
private List<Role> profils;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public List<Role> getProfiles() {
        return profils;
    }

    public void setProfiles(List<Role> profiles) {
        this.profils = profiles;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.idUtilisateur);
        return hash;
    }

    
    public boolean equalsByIDU_MDP(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        if (!Objects.equals(this.idUtilisateur, other.idUtilisateur)) {
            return false;
        }
        if (!Objects.equals(this.mdp, other.mdp)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", mdp=" + mdp + ", profiles=" + profils + '}';
    }

    
  
    

}
