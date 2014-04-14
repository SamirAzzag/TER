v 1.2 :

- Implémentation de la définition 3 (mots 2-parenthésés) du document dans la classe inw2.
- Ajout d'un champ en haut de la fenêtre pour rajouter les arcs inverses.
- Intégration des arcs inverses (désolé, mais j'en avais besoin pour la classe inw2).
- Modifications mineures de l'ensemble des classes
	(suppression de la variable string dans le parseur, ajout de la variable inw2 dans le drawpanel, gestion de inw2...)
	-> Si vous avez bossé dessus normalement il n'y aura pas de soucis d'intégration comme prévu.

UPDATE PREVU :
	-> generateGraphicsComponent de la classe Inw1 crée des CirclesShapes alors que le parseur crée des ArcShapes (incohérence des deux classes,
	une et une seule classe doit créer les ComponentShapes).
