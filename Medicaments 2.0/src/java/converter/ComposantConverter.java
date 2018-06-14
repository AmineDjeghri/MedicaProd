
package converter;

import Jclasses.Composant;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Composant.class)
public class ComposantConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        
        if (value != null && !"".equals(value.trim()) && !"null".equals(value)) {
            Composant f = new Composant();
            f.setId(Integer.parseInt(value));
            return f;
        }
        
        
        System.out.println("probleme! String null ou bien vide");
        return null;
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println(" asString value = " + value);
        
        if (value instanceof Composant) {
            Composant f = new Composant();
            f = (Composant) value;
            System.out.println(" de Objet ModelComposant à String ");
            return f.getId().toString();
        }
        
        return "0";
    }
    
}
