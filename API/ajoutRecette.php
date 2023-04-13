<?php
    require_once("Connexion.php");
    
	class AjoutRecette extends Connexion{

		public function __construct() {
			self::initConnexion();
		}

		public function ajoutRec($nom,$descr,$pseudo,$tpPrep,$tpCui,$tpRep) {
		    
			$sth = self::$bdd->prepare('insert into recette (titre,description,pseudo,temps_prep,temps_cuisson,temps_repos) values (?,?,?,?,?,?)');
			$sth->execute(array($nom,$descr,$pseudo,$tpPrep,$tpCui,$tpRep));
			
			$id = self::$bdd->lastInsertId();
			
			$response['success'] = true;
        	$response['message'] = $id;
		   
			echo json_encode($response);
		}
		
		public function ajoutIngr($nom,$unite,$nombre,$idRecette) {
			
		}
		
		public function ajoutEtape($description,$ordre,$idRecette) {
			
		}
	}
?>