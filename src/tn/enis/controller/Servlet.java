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
		String requestPramIdSupp;
		ProjetDAO projetDao = new ProjetDAOImpl();
		ProjetService serviceProjet = new ProjetServiceImpl(projetDao);
		Projet projet=null;
		if ((requestPram = request.getParameter("id")) == null) {
			System.out.println("projet==null");
			projet = serviceProjet.findByID(1);
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			projetDao = new ProjetDAOImpl();
			serviceProjet = new ProjetServiceImpl(projetDao);
			projet = serviceProjet.findByID(id);

		}
		String nomProjet=request.getParameter("nomProjet");
		if(nomProjet!=null){
			Projet projetAjoute=new Projet(nomProjet);
			serviceProjet.ajoutProjet(projetAjoute);
		}
		if((requestPramIdSupp = request.getParameter("idSupp")) != null)
		{
			Projet projetSupp=serviceProjet.findByID(Integer.parseInt(requestPramIdSupp));
			serviceProjet.supprimerProduit(projetSupp);
		}
		String nomProjetAmodifier=request.getParameter("nomProjetAmodifier");
		if(nomProjetAmodifier!=null){
			int idProjetAmodifier=Integer.parseInt(request.getParameterValues("idProjetAmodifier")[0]);
			Projet projetAmodifier=new Projet(idProjetAmodifier,nomProjetAmodifier);
			serviceProjet.modifierProduit(projetAmodifier);
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
