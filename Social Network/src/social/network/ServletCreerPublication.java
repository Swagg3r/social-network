package social.network;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import social.network.services.ServicePersonne;

public class ServletCreerPublication extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String input = req.getParameter("inputKey");
		System.out.println("input = " + input);
		//TODO : requete base de donnée :
		//	- si interet existe deja : renvoyer ref, sinon creer et envoyer ref
		//	- ajout de la ref dans la classe personne
		// XXX -> c'est fait par la methode creerInteret(personne,string)
		
		HttpSession session = req.getSession();
		String mail = (String) session.getAttribute("Mail");
		
		
		//ServiceInteret service = new ServiceInteret();
		ServicePersonne service = new ServicePersonne();
		Personne client = service.getPersonne(mail);
		
		//Requete dans la base ...

		if(service.existsInteret(input)){
			System.out.println("exist : true");
		} else {	
			System.out.println("exist : false");
			service.creerInteret(client,input);
		}
		
		//return
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(input);
	}
}