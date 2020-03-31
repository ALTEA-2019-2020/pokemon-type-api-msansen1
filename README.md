# pokemon-type-api-msansen1  
pokemon-type-api-msansen1 created by GitHub Classroom  

[![Generic badge](https://img.shields.io/badge/JAVA-11-GREEN.svg)](https://shields.io/)  
An api used as a microservice for the project [Pokemon GameUI](https://github.com/ALTEA-2019-2020/game-ui-msansen1)

[Demo Hosted on Heroku](https://pokemon-type-msn-tp3.herokuapp.com/pokemon-types/)

# Configuration necessaire au lancement :  

NA  

# API disponibles  
[Swagger url](https://pokemon-type-msn-tp3.herokuapp.com/swagger-ui.html)  
[JSON api-docs](https://pokemon-type-msn-tp3.herokuapp.com/v2/api-docs)

## PokemonTypeController:  
	{GET /pokemon-types/{id}, produces [application/json]}: getPokemonTypeFromId(int)  
	{GET /pokemon-types/, params [types], produces [application/json]}: getPokemonTypeFromName(String[])  
	{GET /pokemon-types/, params [name], produces [application/json]}: getPokemonTypeFromName(String)  
	{GET /pokemon-types/, produces [application/json]}: getAllPokemonTypes()  

# Projets liés:  
- [Git GameUI](https://github.com/ALTEA-2019-2020/game-ui-msansen1)
- [Git Pokemon Api](https://github.com/ALTEA-2019-2020/pokemon-type-api-msansen1)
- [Git Trainer Api](https://github.com/ALTEA-2019-2020/trainer-api-msansen1)
- [Git Battle Api](https://github.com/ALTEA-2019-2020/battle-api-msansen1)

