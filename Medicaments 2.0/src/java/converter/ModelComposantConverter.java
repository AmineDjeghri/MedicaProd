/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import Jclasses.ModelComposant;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = ModelComposant.class)
public class ModelComposantConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        
        if (value != null && !"".equals(value.trim()) && !"null".equals(value)) {
            ModelComposant f = new ModelComposant();
            f.setId(Integer.parseInt(value));
            return f;
        }
        
        
        System.out.println("probleme! String null ou bien vide");
        return null;
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println(" asString value = " + value);
        
        if (value instanceof ModelComposant) {
            ModelComposant f = new ModelComposant();
            f = (ModelComposant) value;
            System.out.println(" de Objet ModelComposant à String ");
            return f.getId().toString();
        }
        
        return "0";
    }
    
}
