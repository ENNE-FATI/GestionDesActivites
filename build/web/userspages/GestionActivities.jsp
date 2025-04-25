<%-- 
    Document   : activities
    Created on : 25 avr. 2025, 10:56:11
    Author     : pc
--%>

<%@page import="entities.ActiviteTouristique"%>
<%@page import="services.ActivityService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Formulaire de guide - Administration</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
        <style>
            body {
                min-height: 100vh;
                display: flex;
            }

            .sidebar {
                width: 250px;
                background-color: #212529;
                color: white;
                min-height: 100vh;
                position: fixed;
                left: 0;
                top: 0;
                z-index: 100;
            }

            .sidebar-header {
                padding: 1rem;
                border-bottom: 1px solid rgba(255, 255, 255, 0.1);
            }

            .sidebar-menu {
                padding: 1rem 0;
            }

            .sidebar-menu a {
                display: flex;
                align-items: center;
                padding: 0.75rem 1rem;
                color: rgba(255, 255, 255, 0.8);
                text-decoration: none;
                transition: all 0.3s;
            }

            .sidebar-menu a:hover, .sidebar-menu a.active {
                background-color: rgba(255, 255, 255, 0.1);
                color: white;
            }

            .sidebar-menu i {
                margin-right: 10px;
            }

            .sidebar-footer {
                padding: 1rem;
                border-top: 1px solid rgba(255, 255, 255, 0.1);
                position: absolute;
                bottom: 0;
                width: 100%;
            }

            /* Main content area */
            .main-content {
                margin-left: 250px;
                padding: 20px;
                width: calc(100% - 250px);
            }

            fieldset {
                border: none;
                background-color: white;
                border-radius: 10px;
                box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
                padding: 30px;
                width: 100%;
                max-width: 900px;
            }

            legend {
                font-size: 24px;
                font-weight: 600;
                color: #333;
                padding: 0 10px;
                margin-bottom: 20px;
                position: relative;
            }

            legend::after {
                content: '';
                display: block;
                width: 50px;
                height: 3px;
                background-color: #4a6fdc;
                margin-top: 8px;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 15px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.05);
            }

            th, td {
                padding: 15px;
                text-align: left;
                border-bottom: 1px solid #eee;
            }

            th {
                background-color: #f8f9fa;
                font-weight: 600;
                color: #444;
                position: sticky;
                top: 0;
            }

            tbody tr:hover {
                background-color: #f9f9f9;
            }

            tbody tr:last-child td {
                border-bottom: none;
            }

            a {
                text-decoration: none;
                padding: 8px 12px;
                border-radius: 5px;
                font-weight: 500;
                font-size: 14px;
                transition: all 0.3s ease;
                display: inline-block;
            }

            a[href*="delete"] {
                background-color: #ff5252;
                color: white;
            }

            a[href*="delete"]:hover {
                background-color: #e04646;
            }

            a[href*="update"] {
                background-color: #4a6fdc;
                color: white;
            }

            a[href*="update"]:hover {
                background-color: #3a5fc8;
            }

            .empty-message {
                text-align: center;
                padding: 20px;
                color: #666;
                font-style: italic;
            }

            .error-message {
                text-align: center;
                padding: 20px;
                color: #ff5252;
                font-style: italic;
            }

            .actions-container {
                display: flex;
                gap: 8px;
            }

            .add-button {
                display: inline-block;
                background-color: #4CAF50;
                color: white;
                padding: 10px 15px;
                border-radius: 5px;
                margin-top: 20px;
                font-weight: 500;
                transition: background-color 0.3s;
            }

            .add-button:hover {
                background-color: #3e9142;
            }

            @media (max-width: 768px) {
                .sidebar {
                    width: 0;
                    overflow: hidden;
                }

                .main-content {
                    margin-left: 0;
                    width: 100%;
                }

                table {
                    display: block;
                    overflow-x: auto;
                    white-space: nowrap;
                }

                fieldset {
                    padding: 20px;
                }

                th, td {
                    padding: 10px;
                }

                a {
                    padding: 6px 10px;
                    font-size: 13px;
                }
            }
        </style>
        <!-- Font Awesome for icons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    </head>
    <body>
        <!-- Sidebar -->
  <div class="sidebar">
        <div class="sidebar-header">
            <h4>Administration</h4>
        </div>
        <div class="sidebar-menu">
            <a href="AdminDashbord.jsp">
                <i class="bi bi-speedometer2"></i> Tableau de bord
            </a>
            <a href="GestionActivities.jsp">
                <i class="bi bi-list-check" class="active"></i> Activités
            </a>
            <a href="GestionGuide.jsp" >
                <i class="bi bi-people"></i> Guides
            </a>
        </div>
        <div class="sidebar-footer">
            <a href="Connexion.jsp" class="btn btn-outline-light w-100">
                <i class="bi bi-box-arrow-left"></i> Déconnexion
            </a>
        </div>
    </div>

        <!-- Main content -->
        <div class="main-content">
            <fieldset>
                <legend>Liste des activités</legend>

                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nom</th>
                            <th>Lieu</th>
                            <th>Prix</th>
                            <th>Guide</th>
                            <th>Actions</th>
                        </tr>
                    </thead>

                    <tbody>
                        <%
                            try {
                                ActivityService as = new ActivityService();
                                java.util.List<ActiviteTouristique> activities = as.findAll();
                                if (activities != null && !activities.isEmpty()) {
                                    for (ActiviteTouristique a : activities) {
                                        if (a != null) {
                        %>
                        <tr>
                            <td><%= a.getId()%></td>
                            <td><%= a.getNom() != null ? a.getNom() : ""%></td>
                            <td><%= a.getLieu() != null ? a.getLieu() : ""%></td>
                            <td>€<%= String.format("%.2f", a.getPrix())%></td>
                            <td><%= (a.getGuide() != null) ? (a.getGuide().getNom() != null ? a.getGuide().getNom() : "Sans nom") : "Non assigné"%></td>
                            <td class="actions-container">
                                <a href="${pageContext.request.contextPath}/ActivitiesController?id=<%= a.getId()%>&op=delete">Supprimer</a>
                                <a href="${pageContext.request.contextPath}/ActivitiesController?id=<%= a.getId()%>&op=update">Modifier</a>
                            </td>
                        </tr>
                        <%
                                }
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="6" class="empty-message">Aucune activité trouvée</td>
                        </tr>
                        <%
                            }
                        } catch (Exception e) {
                        %>
                        <tr>
                            <td colspan="6" class="error-message">Erreur lors du chargement des activités: <%= e.getMessage()%></td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>

                <a href="Route?page=ajouteractivite" class="add-button">Ajouter une activité</a>
            </fieldset>
        </div>
    </body>
</html>