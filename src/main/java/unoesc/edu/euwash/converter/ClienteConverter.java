package unoesc.edu.euwash.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import unoesc.edu.euwash.model.Cliente;
import unoesc.edu.euwash.model.Agendamento;


@FacesConverter(value = "clienteconverter", forClass = Cliente.class)
public class ClienteConverter implements javax.faces.convert.Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
			Cliente c = (Cliente) component.getAttributes().get(value);
            return c;
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && (value instanceof Cliente)) {
			Cliente c = (Cliente) value; 
			component.getAttributes().put( String.valueOf(c.getId()), c);
            return String.valueOf(c.getId());
        }

		return null;
	}

}