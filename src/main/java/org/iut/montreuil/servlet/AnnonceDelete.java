package org.iut.montreuil.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iut.montreuil.Interface.AnnonceService;
import org.iut.montreuil.Service.AnnonceServiceImpl;

import java.io.IOException;

@WebServlet("/AnnonceDelete")
public class AnnonceDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            AnnonceService annonceService = AnnonceServiceImpl.getInstance();
            annonceService.deleteAnnonce(annonceService.getAnnonceById(id));
            response.sendRedirect("AnnonceList");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
