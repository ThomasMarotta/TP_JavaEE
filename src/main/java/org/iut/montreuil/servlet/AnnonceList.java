package org.iut.montreuil.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iut.montreuil.Interface.AnnonceService;
import org.iut.montreuil.Service.AnnonceServiceImpl;
import org.iut.montreuil.bean.Annonce;

import java.io.IOException;
import java.util.List;

@WebServlet("/AnnonceList")
public class AnnonceList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AnnonceService annonceService = AnnonceServiceImpl.getInstance();

           List<Annonce> annonces = annonceService.getAnnonces();

            request.setAttribute("annonces", annonces);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/AnnonceList.jsp").forward(request, response);
    }
}