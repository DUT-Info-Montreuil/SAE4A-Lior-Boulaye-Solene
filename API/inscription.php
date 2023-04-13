<?php

include_once "Connexion.php";

class Inscription extends Connexion{

	public function __construct() {
		self::initConnexion();
	}

	public function inscrire($username,$password) {
		$requete = self::$bdd->prepare("SELECT * FROM utilisateur WHERE pseudo = ?");
		$requete->execute([$username]);
		$utilisateur = $requete->fetch();

		$password = password_hash($_POST['password'], PASSWORD_DEFAULT);

		$response = array();
			
		if ($utilisateur == null) {
			$sth = self::$bdd->prepare('insert into utilisateur (pseudo,password) values (?,?)');
			$sth->execute(array($username,$password));
			
			$response['success'] = true;
        	$response['message'] = 'Inscription Réussie';
		} else {
			$response['success'] = false;
        	$response['message'] = 'Utilisateur existant';
		}
		
		echo json_encode($response);
    }
}