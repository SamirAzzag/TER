v 1.1 :

- Suppression du slider pour redimensionner les sommets.
- Ajout d'une extension de la classe inw1 (mots 1-parenthésés) :  
	->inw2 (mots 2-parenthésés) cette classe n'est pas du tout complète c'est simplement pour faire le squelette du programme.
- Dans inw1 ajout d'une condition qui permet de vérifier si un arc et "en dehors" du mot. 
	-> Dans cette classe (qui correspond à la définition 1 du document il ne reste plus qu'à faire le point 2 à savoir "un sommet est en relation avec au plus un sommet...."
- A propos des shapes :
	-> Ajout des couleurs pour les sélection (un clique et double clique).
	-> Ajout de deux booléen (selected et selected2) pour savoir si l'utilisateur à cliquer ou double cliquer.
	-> Réecriture des fonctions draw avec des Graphics2D et sauvegarde des shapes dans une variables ( Ellipse2D shape dans CircleShape et Arc2D shape dans ArcShape). Très utile pour la manipulation graphique.
- Le DrawPanel est désormais capable de gérer les simples cliques et les doubles cliques (un exemple avec coloration des sommets ou des arcs est codé). Je me suis permis de le faire car je pense que se sera utile plus tard et cela peut aussi être utilisé pour modifier directement un sommet ou un arc.
- L'ajout des nouvelles méthodes dans l'interface ComponentShape (les assesseurs communs aux classes shapes).