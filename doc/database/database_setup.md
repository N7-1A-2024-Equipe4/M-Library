Configuration de la base de données MySQL et création de l'utilisateur
```mysql
CREATE DATABASE mlibrary;
USE mlibrary;
CREATE USER 'mlibrary'@'%' IDENTIFIED BY 'mot_de_passe';
GRANT ALL ON mlibrary.* TO 'mlibrary'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
```

Configuration du serveur distant

`/etc/mysql/mysql.conf.d/mysqld.cnf`:
```cnf
...
bind-address            = 0.0.0.0
...
```
```bash
sudo firewall-cmd --zone=public --permanent --add-port=3306/tcp
sudo firewall-cmd --zone=public --permanent --add-port=3306/udp
```
