/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import entities.Touriste;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.TouristeService;

/**
 *
 * @author hibaa
 */
@WebServlet(name = "InscriptionController", urlPatterns = {"/InscriptionController"})
public class InscriptionController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TouristeService ts = new TouristeService();

        String op = request.getParameter("op");
        if (op == null) {
            String id = request.getParameter("id");
            if (id == null || id.isEmpty()) {
                String nom = request.getParameter("nom");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                System.out.println(nom);
                System.out.println(email);
                System.out.println(password);
                ts.create(new Touriste( nom,  email, password));
                response.sendRedirect("userspages/Inscription.jsp");
            } else {
                 String nom = request.getParameter("nom");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                ts.create(new Touriste( nom,  email, password));
                Touriste u = new Touriste( nom, email, password);
                u.setId(Integer.parseInt(id));
                ts.update(u);
                response.sendRedirect("Inscription.jsp");
            }
        } else if (op.equals("delete")) {
            String id = request.getParameter("id");
            ts.delete(ts.findById(Integer.parseInt(id)));
            response.sendRedirect("users.jsp");
        } else if (op.equals("update")) {
            String id = request.getParameter("id");
            Touriste u = ts.findById(Integer.parseInt(id));
            response.sendRedirect("Inscription.jsp?id=" + u.getId() + "&nom=" + u.getNom()  + "&email=" + u.getEmail() + "&password=" + u.getMotDePasse());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}