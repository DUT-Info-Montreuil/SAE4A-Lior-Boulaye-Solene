<?php
/*dutinfopw201636
neqeragy*/
class Connexion {
	
	protected static $bdd;	

	public function __construct() {
        self::initConnexion();
	}

	public static function initConnexion() {
		/*$dsn = 'mysql:dbname=dutinfopw201636;host=database-etudiants.iut.univ-paris8.fr';
		$user = 'dutinfopw201636';
		$password = 'neqeragy';*/

		/*$dsn = 'mysql:dbname=enjoymeal;host=localhost';
		$user = 'enjoymeal';
		$password = 'azerty';*/
		
		$dsn = 'mysql:dbname=id20584955_enjoymeal;host=localhost';
		$user = 'id20584955_enjoy';
		$password = 'Azerty-12345';

		self::$bdd = new PDO($dsn, $user, $password);
	}
}

?>