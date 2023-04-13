<?php
    require_once("Connexion.php");
    
	class Login extends Connexion{

		public function __construct() {
			self::initConnexion();
		}

		public function seConnecter($username, $password) {
			$requete = self::$bdd->prepare("SELECT * FROM utilisateur WHERE pseudo = ?");
			$requete->execute([$username]);
			$utilisateur = $requete->fetch();
			$response = array();
			
		    if (password_verify($password, $utilisateur['password'])) {
				$response['success'] = true;
        		$response['message'] = 'Connexion Réussie';
			} else {
				$response['success'] = false;
        		$response['message'] = 'pseudo ou mot de passe incorrect';
			}
		   
			echo json_encode($response);
		}
	}
?>