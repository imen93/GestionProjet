package tn.enis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.dao.ProjetDAO;
import tn.enis.dao.ProjetDAOImpl;
import tn.enis.dao.TacheDAO;
import tn.enis.dao.TacheDAOImpl;
import tn.enis.model.projet.Projet;
import tn.enis.model.projet.ProjetService;
import tn.enis.model.projet.ProjetServiceImpl;
import tn.enis.model.tache.Tache;
import tn.enis.model.tache.TacheService;
import tn.enis.model.tache.TacheServiceImpl;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ")
				.append(request.getContextPath());
		String requestPram;
		ProjetDAO projetDao = new ProjetDAOImpl();
		ProjetService service = new ProjetServiceImpl(projetDao);
		Projet projet;
		if ((requestPram = request.getParameter("id")) == null) {
			System.out.println("projet==null");
			projet = service.findByID(1);
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			projetDao = new ProjetDAOImpl();
			service = new ProjetServiceImpl(projetDao);
			projet = service.findByID(id);

		}
		TacheDAO tacheDao = new TacheDAOImpl();
		TacheService serviceTache = new TacheServiceImpl(tacheDao);
		List<Tache> taches = serviceTache.findByProjet(projet.getId_projet());
		request.getSession().setAttribute("projet", projet);
		request.getSession().setAttribute("taches", taches);
		getServletContext().getRequestDispatcher("/pages/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
