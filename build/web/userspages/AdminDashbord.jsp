<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tableau de bord - Administration</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
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
        .content {
            flex: 1;
            margin-left: 250px;
            padding: 2rem;
            background-color: #f8f9fa;
        }
        .card {
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);
            transition: transform 0.3s;
        }
        .card:hover {
            transform: translateY(-5px);
        }
        .card-icon {
            font-size: 1.5rem;
            color: #6c757d;
        }
        @media (max-width: 768px) {
            .sidebar {
                width: 100%;
                position: relative;
                min-height: auto;
            }
            .content {
                margin-left: 0;
            }
        }
    </style>
</head>
<body>
    <!-- Sidebar -->
    <div class="sidebar">
        <div class="sidebar-header">
            <h4>Administration</h4>
        </div>
        <div class="sidebar-menu">
            <a href="dashboard" class="active">
                <i class="bi bi-speedometer2"></i> Tableau de bord
            </a>
            <a href="GestionActivities.jsp">
                <i class="bi bi-list-check"></i> Activités
            </a>
            <a href="GestionGuide.jsp">
                <i class="bi bi-people"></i> Guides
            </a>
        </div>
        <div class="sidebar-footer">
            <a href="Connexion.jsp" class="btn btn-outline-light w-100">
                <i class="bi bi-box-arrow-left"></i> Déconnexion
            </a>
        </div>
    </div>
    
    <!-- Content -->
    <div class="content">
        <div class="container-fluid">
            <div class="row mb-4">
                <div class="col">
                    <h1>Tableau de bord</h1>
                    <p class="text-muted">Bienvenue dans votre tableau de bord d'administration</p>
                </div>
            </div>
            
            <div class="row g-4">
                <div class="col-md-4">
                    <div class="card h-100">
                        <div class="card-body">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h5 class="card-title mb-0">Total des activités</h5>
                                <div class="card-icon">
                                    <i class="bi bi-activity"></i>
                                </div>
                            </div>
                            <h2 class="mb-1">24</h2>
                            <p class="text-muted small">+5 depuis le mois dernier</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card h-100">
                        <div class="card-body">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h5 class="card-title mb-0">Total des guides</h5>
                                <div class="card-icon">
                                    <i class="bi bi-people"></i>
                                </div>
                            </div>
                            <h2 class="mb-1">12</h2>
                            <p class="text-muted small">+2 depuis le mois dernier</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card h-100">
                        <div class="card-body">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h5 class="card-title mb-0">Activités à venir</h5>
                                <div class="card-icon">
                                    <i class="bi bi-calendar-event"></i>
                                </div>
                            </div>
                            <h2 class="mb-1">6</h2>
                            <p class="text-muted small">Pour les 7 prochains jours</p>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- Activités récentes -->
            <div class="row mt-5">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header bg-white">
                            <h5 class="mb-0">Activités récentes</h5>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Nom</th>
                                            <th>Catégorie</th>
                                            <th>Date</th>
                                            <th>Statut</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>Randonnée Atlas</td>
                                            <td>Nature</td>
                                            <td>20/04/2025</td>
                                            <td><span class="badge bg-success">Active</span></td>
                                        </tr>
                                        <tr>
                                            <td>Visite culturelle</td>
                                            <td>Culture</td>
                                            <td>22/04/2025</td>
                                            <td><span class="badge bg-primary">À venir</span></td>
                                        </tr>
                                        <tr>
                                            <td>Excursion désert</td>
                                            <td>Aventure</td>
                                            <td>10/04/2025</td>
                                            <td><span class="badge bg-secondary">Terminée</span></td>
                                        </tr>
                                        <!-- Exemple sans activité -->
                                        <!-- <tr><td colspan="4" class="text-center">Aucune activité récente</td></tr> -->
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
