v 1.1 :

- Suppression du slider pour redimensionner les sommets.
- Ajout d'une extension de la classe inw1 (mots 1-parenth�s�s) :  
	->inw2 (mots 2-parenth�s�s) cette classe n'est pas du tout compl�te c'est simplement pour faire le squelette du programme.
- Dans inw1 ajout d'une condition qui permet de v�rifier si un arc et "en dehors" du mot. 
	-> Dans cette classe (qui correspond � la d�finition 1 du document il ne reste plus qu'� faire le point 2 � savoir "un sommet est en relation avec au plus un sommet...."
- A propos des shapes :
	-> Ajout des couleurs pour les s�lection (un clique et double clique).
	-> Ajout de deux bool�en (selected et selected2) pour savoir si l'utilisateur � cliquer ou double cliquer.
	-> R�ecriture des fonctions draw avec des Graphics2D et sauvegarde des shapes dans une variables ( Ellipse2D shape dans CircleShape et Arc2D shape dans ArcShape). Tr�s utile pour la manipulation graphique.
- Le DrawPanel est d�sormais capable de g�rer les simples cliques et les doubles cliques (un exemple avec coloration des sommets ou des arcs est cod�). Je me suis permis de le faire car je pense que se sera utile plus tard et cela peut aussi �tre utilis� pour modifier directement un sommet ou un arc.
- L'ajout des nouvelles m�thodes dans l'interface ComponentShape (les assesseurs communs aux classes shapes).