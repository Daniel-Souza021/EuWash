package unoesc.edu.euwash.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import unoesc.edu.euwash.model.Servico;
import unoesc.edu.euwash.model.Agendamento;


@FacesConverter(value = "servicoconverter", forClass = Servico.class)
public class ServicoConverter implements javax.faces.convert.Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
			Servico s = (Servico) component.getAttributes().get(value);
            return s;
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && (value instanceof Servico)) {
			Servico s = (Servico) value; 
			component.getAttributes().put( String.valueOf(s.getId()), s);
            return String.valueOf(s.getId());
        }

		return null;
	}

}
