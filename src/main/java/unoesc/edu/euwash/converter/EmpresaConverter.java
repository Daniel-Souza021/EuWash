package unoesc.edu.euwash.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import unoesc.edu.euwash.model.Empresa;


@FacesConverter(value = "empresaconverter", forClass = Empresa.class)
public class EmpresaConverter implements javax.faces.convert.Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
			Empresa e = (Empresa) component.getAttributes().get(value);
            return e;
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && (value instanceof Empresa)) {
			Empresa e = (Empresa) value; 
			component.getAttributes().put( String.valueOf(e.getId()), e);
            return String.valueOf(e.getId());
        }

		return null;
	}

}