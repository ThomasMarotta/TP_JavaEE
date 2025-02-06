package org.iut.montreuil.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iut.montreuil.Service.AnnonceService;
import org.iut.montreuil.bean.Annonce;

import java.io.IOException;

@WebServlet("/AnnonceUpdate")
public class AnnonceUpdate extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            AnnonceService annonceService = AnnonceService.getInstance();
            Annonce annonce = annonceService.getAnnonceById(id);

            request.setAttribute("annonce", annonce);
        } catch (Exception e) {
           e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/AnnonceUpdate.jsp").forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Annonce annonce = new Annonce(
                id,
                request.getParameter("titre"),
                request.getParameter("description"),
                request .getParameter("adresse"),
                request.getParameter("mail")
        );

        try {
            AnnonceService annonceService = AnnonceService.getInstance();
            annonceService.updateAnnonce(annonce);
            response.sendRedirect("AnnonceList");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
