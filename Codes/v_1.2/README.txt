v 1.2 :

- Impl�mentation de la d�finition 3 (mots 2-parenth�s�s) du document dans la classe inw2.
- Ajout d'un champ en haut de la fen�tre pour rajouter les arcs inverses.
- Int�gration des arcs inverses (d�sol�, mais j'en avais besoin pour la classe inw2).
- Modifications mineures de l'ensemble des classes
	(suppression de la variable string dans le parseur, ajout de la variable inw2 dans le drawpanel, gestion de inw2...)
	-> Si vous avez boss� dessus normalement il n'y aura pas de soucis d'int�gration comme pr�vu.

UPDATE PREVU :
	-> generateGraphicsComponent de la classe Inw1 cr�e des CirclesShapes alors que le parseur cr�e des ArcShapes (incoh�rence des deux classes,
	une et une seule classe doit cr�er les ComponentShapes).
