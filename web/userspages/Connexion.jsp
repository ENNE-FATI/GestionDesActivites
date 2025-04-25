<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
    <head>

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            :root {
                --primary-color: #6c5ce7;
                --secondary-color: #a29bfe;
                --accent-color: #fd79a8;
                --text-color: #2d3436;
                --light-color: #f8f9fa;
                --dark-color: #636e72;
                --border-radius: 12px;
            }

            body {
                background-color: #f1f2f6;
                min-height: 100vh;
                display: flex;
                align-items: center;
                justify-content: center;
                font-family: 'Poppins', sans-serif;
                color: var(--text-color);
                padding: 20px;
            }

            .login-container {
                max-width: 800px;
                width: 100%;
                background-color: white;
                border-radius: var(--border-radius);
                box-shadow: 0 10px 30px rgba(0, 0, 0, 0.05);
                overflow: hidden;
                display: flex;
                margin: 0 auto;
            }

            .login-form-container {
                flex: 1;
                padding: 30px;
                display: flex;
                flex-direction: column;
                justify-content: center;
            }

            .login-image-container {
                flex: 1;
                background-image: url('https://images.unsplash.com/photo-1522202176988-66273c2fd55f?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80');
                background-size: cover;
                background-position: center;
                position: relative;
                min-height: 100%;
            }

            .login-image-overlay {
                position: absolute;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                background: linear-gradient(45deg, rgba(108, 92, 231, 0.8), rgba(253, 121, 168, 0.8));
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                padding: 30px;
                color: white;
                text-align: center;
            }

            .login-image-title {
                font-size: 1.8rem;
                font-weight: 700;
                margin-bottom: 15px;
            }

            .login-image-text {
                font-size: 0.9rem;
                line-height: 1.5;
            }

            .login-header {
                text-align: center;
                margin-bottom: 20px;
            }

            .login-header h2 {
                color: var(--primary-color);
                font-weight: 700;
                margin-bottom: 5px;
                font-size: 1.6rem;
            }

            .login-header p {
                color: var(--dark-color);
                font-size: 0.85rem;
            }

            .form-control {
                border: 1px solid #dfe6e9;
                padding: 10px 15px;
                height: auto;
                border-radius: var(--border-radius);
                margin-bottom: 15px;
                font-size: 0.9rem;
            }

            .form-control:focus {
                border-color: var(--primary-color);
                box-shadow: 0 0 0 0.2rem rgba(108, 92, 231, 0.25);
            }

            .form-label {
                font-weight: 500;
                font-size: 0.85rem;
                color: var(--dark-color);
                margin-bottom: 5px;
            }

            .btn-login {
                background: linear-gradient(45deg, var(--primary-color), var(--secondary-color));
                border: none;
                width: 100%;
                padding: 10px;
                font-weight: 600;
                font-size: 0.9rem;
                border-radius: var(--border-radius);
                color: white;
                margin-top: 10px;
                transition: all 0.3s;
            }

            .btn-login:hover {
                transform: translateY(-2px);
                box-shadow: 0 5px 15px rgba(108, 92, 231, 0.4);
            }

            .login-footer {
                text-align: center;
                margin-top: 15px;
                color: var(--dark-color);
                font-size: 0.85rem;
            }

            .login-footer a {
                color: var(--primary-color);
                text-decoration: none;
                font-weight: 600;
                transition: all 0.3s;
            }

            .login-footer a:hover {
                color: var(--accent-color);
            }

            .forgot-password {
                text-align: right;
                margin-top: -10px;
                margin-bottom: 15px;
            }

            .forgot-password a {
                color: var(--dark-color);
                text-decoration: none;
                font-size: 0.75rem;
                transition: all 0.3s;
            }

            .forgot-password a:hover {
                color: var(--primary-color);
            }

            @media (max-width: 768px) {
                .login-container {
                    flex-direction: column-reverse;
                    max-width: 400px;
                }

                .login-image-container {
                    height: 180px;
                }

                .login-form-container {
                    padding: 25px 20px;
                }
            }
        </style>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="login-container">
                <!-- Formulaire à gauche -->
                <div class="login-form-container">
                    <div class="login-header">
                        <h2>Connexion</h2>
                        <p>Accédez à votre espace personnel</p>
                    </div>

                    <!-- Formulaire de connexion -->
                    <form action="../LoginController" method="post">
                        
                        <% if (request.getAttribute("error") != null) {%>
                        <div class="error"><%= request.getAttribute("error")%></div>
                        <% }%>
                        <!-- Champ Nom -->
                      

                        <!-- Champ Email -->
                        <div class="mb-3">
                            <label for="email" class="form-label">Adresse email</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="exemple@email.com" required>
                        </div>

                        <!-- Champ Mot de passe -->
                        <div class="mb-3">
                            <label for="password" class="form-label">Mot de passe</label>
                           <input type="password" class="form-control" id="password" name="motDePasse" placeholder="Votre mot de passe" required>

                        </div>


                        <!-- Bouton de connexion -->
                        <button type="submit" class="btn btn-login">Se connecter</button>
                    </form>

                    <!-- Pied de page du formulaire -->
                    <div class="login-footer">
                        <p>Vous n'avez pas de compte? <a href="Inscription.jsp">Créer un compte</a></p>
                    </div>
                </div>

                <!-- Image à droite -->
                <div class="login-image-container">
                    <div class="login-image-overlay">
                        <div class="login-image-title">Bienvenue sur notre plateforme</div>
                        <div class="login-image-text">
                            Découvrez, participez et organisez des activités passionnantes avec notre communauté
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap Icons -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
        <!-- Bootstrap JS Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>