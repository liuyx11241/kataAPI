# kataAPI
Kata API pour SG

### application.properties
C'est la configuration par defaut pour env TEST avec une DB H2 integre.
Il faut attaquer le vrai serveur SQL pour le prod

Pouvoir switcher en env PROD par spring.profiles.active=prod

### Swagger API
http://localhost:8080/swagger-ui.html

Un script SQL (data.sql) sera execute au moment du lancement Springboot pour inserer 10 rooms.


### Python
Utiliser Python3.7 pour tester. N'oublier pas l'ajout de lib requests, 

> pipenv install requests

or
> pip install requests

### Next
1. Ajouter des tests Mock Controller
2. Ameliorer le descriptif API
3. Ameliorer l'export API Swagger
4. Prevoir l'evol
