<?php
        if(isset($_POST['connexion'])) {
            require_once("login.php");
           
            $username = $_POST['username'];
        	$password = $_POST['password'];
        	 
            $co = new Login;
            $co->seConnecter($username, $password);
        } else if (isset($_POST['inscription'])){
            require_once("inscription.php");
            $username = $_POST['username'];
            $password = $_POST['password'];

            $ins = new Inscription;
            $ins->inscrire($username, $password);
        }
        
        else if(isset($_GET['table'])){
            require_once("recupTable.php");
            $table = $_GET['table'];
            $recup_Tab = new RecupTab;
            if($table == "recette"){
                $recup_Tab->getRecette();
            } else if($table == "utilisateur") {
                
            }
            
        } else if (isset($_POST['creerRecette'])) {
            require_once("ajoutRecette.php");
             
            $ajoutRecette = new AjoutRecette;

            $ajoutRecette->ajoutRec($_POST['nom'],$_POST['description'],$_POST['pseudo'],$_POST['tempPrep'],$_POST['tempCuisson'],$_POST['tempRepos']);
        } else if (isset($_POST['creerIngredient'])) {
            require_once("ajoutRecette.php");
            
            $ajoutRecette = new AjoutRecette;
            
            $ajoutRecette->ajoutIngr();
            
        } else if (isset($_POST['creerEtapePrep'])) {
            require_once("ajoutRecette.php");
            
            $ajoutRecette = new AjoutRecette;
            
            $ajoutRecette->ajoutEtape();
        }
            
            
            
            
            
?>