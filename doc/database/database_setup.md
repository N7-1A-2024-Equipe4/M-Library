Configuration de la base de données MySQL et création de l'utilisateur
```mysql
CREATE DATABASE mlibrary;
USE mlibrary;
CREATE USER 'mlibrary'@'%' IDENTIFIED BY 'mot_de_passe';
GRANT ALL ON mlibrary.* TO 'mlibrary'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
```
