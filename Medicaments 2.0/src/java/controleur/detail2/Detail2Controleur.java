
package controleur.detail2;

import Jclasses.Detail2;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.Detail2Facade;


@ManagedBean
@ViewScoped
public class Detail2Controleur {

    @EJB
    Detail2Facade detail2Facade;
    
    Detail2 detail2; 
    
    
    public Detail2Controleur() {
    }
    
    @PostConstruct
    public void init(){
        detail2=new Detail2();
    }
    
    public void inserer()
    { System.out.println("insertion detail2");
        try{
            detail2Facade.create(detail2);
            System.out.println("terminééééé");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
