/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Guide;
import entities.ActiviteTouristique;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ActivityService;
import services.GuideService;

/**
 *
 * @author AMINE
 */
@WebServlet(name = "Route", urlPatterns = {"/Route"})
public class Route extends HttpServlet {

    GuideService gs;
    ActivityService as;

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
        as = new ActivityService();
        gs = new GuideService();
        String page = request.getParameter("page");

        switch (page) {
            case "profile":
                request.getRequestDispatcher("userspages/AdlinDashbord.jsp").forward(request, response);
                break;
            case "guides":
                List<Guide> guides = gs.findAll();
                request.setAttribute("guides", guides);
                request.getRequestDispatcher("userspages/GestionGuide.jsp").forward(request, response);
                break;

            case "activites":
                List<ActiviteTouristique> activites = as.findAll();
                request.setAttribute("activites", activites);
                request.getRequestDispatcher("userspages/GestionActivities.jsp").forward(request, response);
                break;
            case "ajouteractivite":
                request.getRequestDispatcher("userspages/ajouteractivite.jsp").forward(request, response);
                break;
            case "addGuides":
                request.getRequestDispatcher("userspages/addGuides.jsp").forward(request, response);
                break;
            case "deconnexion":
                request.getRequestDispatcher("userspages/login.jsp").forward(request, response);
                break;

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
