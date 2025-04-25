package controllers;

import entities.Admin;
import entities.User;
import services.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse"); 
        
        System.out.println(email);
        System.out.println(motDePasse);

        User user = userService.adminLogin(email, motDePasse);

         if (user != null) {
            // Vérifier si l'utilisateur est un admin
            if (user instanceof Admin) {
                response.sendRedirect("userspages/AdminDashbord.jsp");
            } else {
                response.sendRedirect("userspages/UserDashbord.jsp");
            }
        } else {
            // Erreur de login
            request.setAttribute("error", "Email ou mot de passe incorrect !");
            request.getRequestDispatcher("userspages/Connexion.jsp").forward(request, response);
        }
    }
    
}
