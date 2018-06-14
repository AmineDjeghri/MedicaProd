/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Session.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Fatah
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> {

    @PersistenceContext(unitName = "MEDICAMENT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Utilisateur loginByUID(String user){
        Utilisateur u;
        //declaration de la requete 
        Query q= em.createQuery("select a from Utilisateur a where a.idUtilisateur=:user");
   //affectation du parametre declaré 
        q.setParameter("user", user);
//    excution de la requette 
try{
    u = (Utilisateur) q.getSingleResult();
}catch(Exception e)
{ System.out.println("Exception"+e);
    u=null;
}
   return u;
   
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }
    
}
