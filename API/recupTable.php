<?php
    require_once("Connexion.php");
    
	class RecupTab extends Connexion{

		public function __construct() {
			self::initConnexion();
		}
		
		public function getRecette(){
		    if(isset($_GET['pseudo'])){
		        $pseudo = $_GET['pseudo'];
		        $sql = "SELECT * FROM recette WHERE pseudo = ?";
		        $param = array($pseudo);

		    } else {
		        $sql = "SELECT * FROM recette";
    			$param = array();
		    }
		    $requete = self::$bdd->prepare($sql);
    	    $requete->execute($param);
    	    //var_dump($requete->fetchAll());
		    echo json_encode($requete->fetchAll());
		}
		
	}
?>