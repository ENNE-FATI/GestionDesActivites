<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Création de Compte - Gestion d'Activités</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --primary-color: #4facfe;
            --secondary-color: #00f2fe;
            --accent-color: #5e72e4;
            --text-color: #525f7f;
            --light-color: #f8f9fa;
            --dark-color: #8898aa;
            --border-radius: 10px;
        }
        
        body {
            background: linear-gradient(120deg, #e0f7fa, #f5f7ff);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: 'Poppins', sans-serif;
            color: var(--text-color);
            padding: 40px 0;
        }
        
        .register-container {
            max-width: 650px;
            width: 100%;
            margin: 0 auto;
            padding: 35px;
            background-color: white;
            border-radius: var(--border-radius);
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.03);
        }
        
        .register-header {
            text-align: center;
            margin-bottom: 30px;
        }
        
        .register-header h2 {
            color: var(--primary-color);
            font-weight: 700;
            margin-bottom: 10px;
        }
        
        .register-header p {
            color: var(--dark-color);
            font-size: 0.9rem;
        }
        
        .input-group {
            margin-bottom: 15px;
            position: relative;
        }
        
        .input-group-text {
            background-color: white;
            border-right: none;
            color: var(--dark-color);
            border-top-left-radius: var(--border-radius);
            border-bottom-left-radius: var(--border-radius);
        }
        
        .form-control {
            border: 1px solid #e9ecef;
            padding: 10px 15px;
            height: auto;
            border-radius: 0 var(--border-radius) var(--border-radius) 0;
            font-size: 0.9rem;
            border-left: none;
            background-color: #f8f9fa;
        }
        
        .form-control:focus {
            border-color: var(--primary-color);
            box-shadow: none;
            background-color: white;
        }
        
        .form-label {
            font-weight: 500;
            font-size: 0.85rem;
            color: var(--dark-color);
            margin-bottom: 5px;
        }
        
        .btn-register {
            background: linear-gradient(45deg, var(--primary-color), var(--secondary-color));
            border: none;
            width: 100%;
            padding: 12px;
            font-weight: 600;
            font-size: 0.95rem;
            border-radius: var(--border-radius);
            color: white;
            margin-top: 10px;
            transition: all 0.3s;
        }
        
        .btn-register:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(79, 172, 254, 0.4);
        }
        
        .register-footer {
            text-align: center;
            margin-top: 20px;
            color: var(--dark-color);
            font-size: 0.85rem;
        }
        
        .register-footer a {
            color: var(--primary-color);
            text-decoration: none;
            font-weight: 600;
            transition: all 0.3s;
        }
        
        .register-footer a:hover {
            color: var(--accent-color);
        }
        
        .form-check-input:checked {
            background-color: var(--primary-color);
            border-color: var(--primary-color);
        }
        
        .password-requirements {
            font-size: 0.8rem;
            color: #8898aa;
            margin-top: 5px;
            padding-left: 10px;
            border-left: 3px solid var(--secondary-color);
        }
        
        .password-requirements ul {
            padding-left: 20px;
            margin-bottom: 0;
        }
        
        .logo {
            width: 70px;
            height: 70px;
            margin: 0 auto 20px;
            background: linear-gradient(45deg, var(--primary-color), var(--secondary-color));
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            box-shadow: 0 5px 15px rgba(79, 172, 254, 0.3);
        }
        
        .logo i {
            font-size: 35px;
            color: white;
        }
        
        .modal-header {
            background: linear-gradient(45deg, var(--primary-color), var(--secondary-color));
            color: white;
        }
        
        .modal-title {
            font-weight: 600;
        }
        
        .btn-close {
            filter: brightness(0) invert(1);
        }
        
        .form-check-label {
            font-size: 0.85rem;
            color: var(--dark-color);
        }
        
        .form-check-label a {
            color: var(--primary-color);
            text-decoration: none;
            font-weight: 600;
            transition: all 0.3s;
        }
        
        .form-check-label a:hover {
            color: var(--accent-color);
        }
        
        @media (max-width: 768px) {
            .register-container {
                padding: 25px 20px;
                margin: 0 15px;
            }
        }
    </style>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="register-container">
            <div class="register-header">
                <div class="logo">
                    <i class="bi bi-person-circle"></i>
                </div>
                <h2>Créer un compte</h2>
                <p>Rejoignez notre plateforme de gestion d'activités</p>
            </div>
            
            <!-- Formulaire de création de compte -->
            <form action="../InscriptionController" method="post" id="registerForm">
                <!-- Message d'erreur (à afficher conditionnellement) -->
                <% if (request.getAttribute("errorMessage") != null) { %>
                <div class="alert alert-danger" role="alert">
                    <%= request.getAttribute("errorMessage") %>
                </div>
                <% } %>
                
                <!-- Informations personnelles -->
               
                    
                    <div class="row mb-3">
                        <label for="lastName" class="form-label"name="nom">Nom</label>
                        <div class="input-group">
                            <span class="input-group-text"><i class="bi bi-person-fill"></i></span>
                            <input type="text" class="form-control" id="lastName" name="nom" placeholder="Votre nom" required>
                        </div>
                    </div>
               
                
                <!-- Email -->
                <div class="mb-3">
                    <label for="email" class="form-label" name="email">Adresse email</label>
                    <div class="input-group">
                        <span class="input-group-text"><i class="bi bi-envelope"></i></span>
                        <input type="email" class="form-control" id="email" name="email" placeholder="exemple@email.com" required>
                    </div>
                </div>
                
               
                
                <!-- Mot de passe -->
                <div class="mb-3">
                    <label for="password" class="form-label" name="password">Mot de passe</label>
                    <div class="input-group">
                        <span class="input-group-text"><i class="bi bi-lock"></i></span>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Créez un mot de passe" required>
                    </div>
                    <div class="password-requirements mt-1">
                       
                    </div>
                </div>
                
                
                
                <!-- Conditions d'utilisation -->
                <div class="mb-4">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="termsCheck" name="termsCheck" required>
                        <label class="form-check-label" for="termsCheck">
                            J'accepte les <a href="#" data-bs-toggle="modal" data-bs-target="#termsModal">conditions d'utilisation</a> et la <a href="#" data-bs-toggle="modal" data-bs-target="#privacyModal">politique de confidentialité</a>
                        </label>
                    </div>
                </div>
                
                <!-- Bouton d'inscription -->
                <div class="mb-3">
                    <button type="submit" class="btn btn-primary btn-register">Créer mon compte</button>
                </div>
            </form>
            
            <!-- Pied de page du formulaire -->
            <div class="register-footer">
                <p>Vous avez déjà un compte? <a href="Connexion.jsp">Se connecter</a></p>
            </div>
        </div>
    </div>
    
    <!-- Modal pour les conditions d'utilisation -->
    <div class="modal fade" id="termsModal" tabindex="-1" aria-labelledby="termsModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="termsModalLabel">Conditions d'utilisation</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Bienvenue sur notre plateforme de gestion d'activités. En vous inscrivant, vous acceptez les conditions suivantes :</p>
                    <ol>
                        <li>Vous devez fournir des informations exactes et complètes lors de votre inscription.</li>
                        <li>Vous êtes responsable de maintenir la confidentialité de votre compte et mot de passe.</li>
                        <li>Vous acceptez de ne pas utiliser notre service à des fins illégales ou non autorisées.</li>
                        <li>Nous nous réservons le droit de modifier ou de résilier le service pour quelque raison que ce soit, sans préavis.</li>
                        <li>Nous nous réservons le droit de refuser le service à quiconque pour quelque raison que ce soit.</li>
                    </ol>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Modal pour la politique de confidentialité -->
    <div class="modal fade" id="privacyModal" tabindex="-1" aria-labelledby="privacyModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="privacyModalLabel">Politique de confidentialité</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Notre politique de confidentialité explique comment nous collectons, utilisons et protégeons vos informations personnelles :</p>
                    <ol>
                        <li>Nous collectons des informations personnelles uniquement avec votre consentement explicite.</li>
                        <li>Vos données sont utilisées uniquement pour améliorer votre expérience sur notre plateforme.</li>
                        <li>Nous ne vendons pas vos informations personnelles à des tiers.</li>
                        <li>Nous utilisons des mesures de sécurité pour protéger vos informations personnelles.</li>
                        <li>Vous pouvez demander la suppression de vos données à tout moment.</li>
                    </ol>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <!-- Bootstrap JS Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    
    <!-- Script de validation du formulaire -->
   
</body>
</html>