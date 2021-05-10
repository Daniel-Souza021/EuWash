package unoesc.edu.euwash.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unoesc.edu.euwash.model.Cliente;

@WebServlet("/cadastroClientes")
public class ControllerCliente  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {
		handleRequest(req, resp);
	}

	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {

		handleRequest(req, resp);
	}

	private void handleRequest(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {

		Cliente c;
		List<Cliente> clientes;

		if (req.getSession().getAttribute("clientes") == null) {
			clientes = new ArrayList<Cliente>();
			req.getSession().setAttribute("clientes", clientes);
		} else {
			clientes = (ArrayList) req.getSession().getAttribute("clientes");
		}

		if (req.getParameter("updateProfessor") != null) {
			int pId = Integer.parseInt(req.getParameter("updateCliente"));
			c = clientes.get(pId);
			
			c.setNome(req.getParameter("txtnome"));
			c.setSobrenome(req.getParameter("txtsobrenome"));
			c.setTelefone(req.getParameter("txttelefone"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				c.setDataNasc(format.parse(req.getParameter("txtdtnasc")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
				
		} else {
			c = new Cliente();
			
			c.setNome(req.getParameter("txtnome"));
			c.setSobrenome(req.getParameter("txtSobrenome"));
			c.setTelefone(req.getParameter("txttelefone"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				c.setDataNasc(format.parse(req.getParameter("txtdtnasc")));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			clientes.add(c);
		}

		req.getRequestDispatcher("ClienteView.jsp").forward(req, resp);
	}

}
