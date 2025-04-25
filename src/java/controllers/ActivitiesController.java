/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Guide;
import entities.ActiviteTouristique;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.GuideService;
import services.ActivityService;

/**
 *
 * @author PC
 */
@WebServlet(name = "ActivitiesController", urlPatterns = {"/ActivitiesController"})
public class ActivitiesController extends HttpServlet {
    private GuideService gs;
    private ActivityService as;
    
    @Override
    public void init() throws ServletException {
        super.init();
        gs = new GuideService();
        as = new ActivityService();
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
            String nom = request.getParameter("nom");
            String lieu = request.getParameter("lieu");
            String prix = request.getParameter("prix");
            String description = request.getParameter("description");
            int idGuide = Integer.parseInt(request.getParameter("guide"));
            Guide guide = gs.findById(idGuide);
            
            if (id == null || id.isEmpty()) {
                // Création
                ActiviteTouristique a = new ActiviteTouristique(nom, lieu, (int) Double.parseDouble(prix), description, guide);
                as.create(a);
            } else {
                // Modification
                ActiviteTouristique a = new ActiviteTouristique(nom, lieu, (int) Double.parseDouble(prix), description, guide);
                a.setId(Integer.parseInt(id));
                as.update(a);
            }
            response.sendRedirect("Route?page=activities");
            
        } else if (op.equals("delete")) {
            String id = request.getParameter("id");
            as.delete(as.findById(Integer.parseInt(id)));
            response.sendRedirect("Route?page=activities");
            
        } else if (op.equals("update")) {
            String id = request.getParameter("id");
            ActiviteTouristique a = as.findById(Integer.parseInt(id));
            response.sendRedirect("Route?page=ajouteractivite&id=" + a.getId() 
                    + "&nom=" + a.getNom()
                    + "&lieu=" + a.getLieu()
                    + "&prix=" + a.getPrix()
                    + "&description=" + a.getDescription()
                    + "&guide=" + a.getGuide().getId());
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