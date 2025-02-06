package org.iut.montreuil.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iut.montreuil.DAO.AnnonceDAO;
import org.iut.montreuil.bean.Annonce;
import org.iut.montreuil.connection.ConnectionDB;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/AnnonceList")
public class AnnonceList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AnnonceDAO annonceDAO = new AnnonceDAO(ConnectionDB.getInstance());
            ArrayList<Annonce> annonces = annonceDAO.findAll();

            request.setAttribute("annonces", annonces);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/AnnonceList.jsp").forward(request, response);
    }
}