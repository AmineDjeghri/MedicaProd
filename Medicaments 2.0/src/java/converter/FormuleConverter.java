/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import Jclasses.Formule;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Formule.class)
public class FormuleConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        
        if (value != null && !"".equals(value.trim()) && !"null".equals(value)) {
            Formule f = new Formule();
            f.setId(Integer.parseInt(value));
            return f;
        }
        
        
        System.out.println("probleme! String null ou bien vide");
        return null;
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println(" asString value = " + value);
        
        if (value instanceof Formule) {
            Formule f = new Formule();
            f = (Formule) value;
            System.out.println(" de Objet Formule à String ");
            return f.getId().toString();
        }
        
        return "0";
    }
    
}
