package org.iut.montreuil.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iut.montreuil.Service.AnnonceService;
import org.iut.montreuil.bean.Annonce;

import java.io.IOException;

@WebServlet("/AnnonceAdd")
public class AnnonceAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Annonce annonce = new Annonce(
                request.getParameter("titre"),
                request.getParameter("description"),
                request .getParameter("adresse"),
                request.getParameter("mail")
        );

        try {
            AnnonceService annonceService = AnnonceService.getInstance();
            annonceService.saveAnnonce(annonce);
            response.sendRedirect("AnnonceList");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}