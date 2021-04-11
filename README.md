# ASO-PokedexModyo
## Proyecto generado con Spring Boot
    Java: 11
  
## Deploy
El despliegue se realiza de forma automática mediante github actions hacia una cuenta en HEROKU, cada vez que se realiza un push al mastesr. En el archivo main.yml se encuentra la configuración.  Para desplegar en una cuenta en Heroku se debe definir un SECRET en Github, esto es, Ir a la pestaña Settings del proyecto, en la opción Secrets y agregar un nuevo registro con el nombre HEROKU_SECRET_KEY, el valor que contiene se obtiene del API Key en la configuración de la cuenta en Heroku.
