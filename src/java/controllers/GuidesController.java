/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Guide;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.GuideService;

/**
 *
 * @author PC
 */
@WebServlet(name = "GuidesController", urlPatterns = {"/GuidesController"})
public class GuidesController extends HttpServlet {
        private GuideService gs;
        
        @Override
        public void init() throws ServletException {
            super.init(); //To change body of generated methods, choose Tools | Templates.
            gs = new GuideService();
        }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String op = request.getParameter("op");
        if (op == null) {
            String id = request.getParameter("id");
            if (id == null || id.isEmpty()) {
                String langue = request.getParameter("langue");
                String nom = request.getParameter("nom");
                String email = request.getParameter("email");
                String motDePasse = request.getParameter("motDePasse");
                gs.create(new Guide(langue, nom, email, motDePasse));
                response.sendRedirect("Route?page=guides");
            }else{
                String langue = request.getParameter("langue");
                String nom = request.getParameter("nom");
                String email = request.getParameter("email");
                String motDePasse = request.getParameter("motDePasse");
                Guide g = new Guide(langue, nom, email, motDePasse);
                g.setId(Integer.parseInt(id));
                gs.update(g);
                response.sendRedirect("Route?page=guides");
                
            }
        } else if (op.equals("delete")) {
            String id = request.getParameter("id");
            gs.delete(gs.findById(Integer.parseInt(id)));
            response.sendRedirect("Route?page=guides");
        } else if (op.equals("update")) {
            String id = request.getParameter("id");
            Guide u = gs.findById(Integer.parseInt(id));
            response.sendRedirect("Route?page=ajouterGuide&id=" + u.getId() + "&langue=" + u.getLangue() + "&nom=" + u.getNom() + "&email=" + u.getEmail() + "&motDePasse=" + u.getMotDePasse());

        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}