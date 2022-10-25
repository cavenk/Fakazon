Drop database TPJava;

/* Création de la BD */
CREATE DATABASE TPJava;

/* Utiliser la BD TPJava */
USE TPJava;

/* Création de tables */
CREATE TABLE Role (
    idRole int not null,
    role varchar(40) not null,
    PRIMARY KEY (idRole)
);

CREATE TABLE Adresse(
    idAdresse int not null auto_increment,
    adresse varchar(150) not null,
    ville varchar(60) not null,
    province varchar(60) not null,
    pays varchar (60) not null,
    codePostal varchar(7) not null,
    PRIMARY KEY (idAdresse)
);

CREATE TABLE Utilisateur (
    idUtilisateur int not null auto_increment,
    prenom varchar(40) not null,
    nom varchar(40) not null,
    dateNaissance date not null,
    telephone varchar(40) not null,
    courriel varchar(40) not null,
    motPass varchar(15) not null,
    idRole int not null,
    idAdresse int,
    idAdresseLivraison int,
    PRIMARY KEY(idUtilisateur),
    UNIQUE(courriel),
    FOREIGN KEY(idRole) references Role(idRole),
    FOREIGN KEY(idAdresse) references Adresse(idAdresse),
    FOREIGN KEY(idAdresseLivraison) references Adresse(idAdresse)
);

CREATE TABLE Categorie(
    idCategorie int not null auto_increment,
    nom varchar (40) not null,
    description varchar (100) not null,
    PRIMARY KEY(idCategorie)
);

CREATE TABLE Produit(
    idProduit int not null auto_increment,
    nom varchar(100) not null,
    prix numeric(8,2) not null,
    image varchar(200) not null,
    quantite numeric(3) not null,
    idCategorie int not null,
    PRIMARY KEY(idProduit),
    FOREIGN KEY(idCategorie) references Categorie(idCategorie)
);



-- CREATE TABLE Facture(
--     idFacture int auto_increment not null,
--     dateFacture date not null,
--     idUtilisateur int not null,
--     idPanier int,
--     PRIMARY KEY(idFacture),
--     FOREIGN KEY(idUtilisateur) references Utilisateur(idUtilisateur)
--     FOREIGN KEY(idPanier) references Panier(idPanier)
-- );

-- CREATE TABLE FactureItem
-- (
-- idFactureItem int auto_increment,
-- idProduit int,
-- idFacture int,
-- quantiteParItem int, 
-- prixParItem numeric(8,2),
-- PRIMARY KEY(idFactureItem),
-- FOREIGN KEY(idProduit) references Produit(idProduit),
-- FOREIGN KEY(idFacture) references Facture(idFacture)
-- FOREIGN KEY(idPanier) references Panier(idPanier)
-- );

/* Quelques données */
INSERT INTO Role value
(1,'administrateur'),
(2,'utilisateur');

INSERT INTO adresse values
(1,'523 rue Monsieur','Longueuil','Quebec','Canada','N4L P2F'),
(2,'666 rue porier','Longueuil','Quebec','Canada','N4L P2F');

INSERT INTO Utilisateur values
(1,'Leblanc','François','1985-06-23','514-844-1212','leblancf@gmail.com','123456',1, null, null),
(2,'Roi','Stephane','1988-11-08','450-564-7896','roi@gmail.com','123456789',2 ,1 ,2);

INSERT INTO Categorie values
(1,'Celullaires Iphone','Tous les iPhone'),
(2,'Celullaires Samsung','Tous les Samsung'),
(3,'Special du mois','Celullaires en special');


INSERT INTO Produit values
(1,'iPhone 14 Pro Max',1500.00,'https://www.bell.ca/Styles/images/iPhone_14_Pro_Max_DeepPurple_5G-plus_lrg1.png',10,1),
(2,'Samsung Galaxy S22 Ultra',1400.00,'https://images.ctfassets.net/8utyj17y1gom/6trf52R6VcJPrSeqAV2I4C/73d17fb48007378c49e68f9c98d2a384/galaxy-s22-ultra-black-front.png',7,2),
(3,'Samsung Galaxy Z Flip3',699.00,'https://images.ctfassets.net/t00ajdlq0g9p/7GoLqLQ8JYNEIDSM0e6qnd/746911fde929d66b313f74b4e868750c/galaxy-flip3-cream-angle.png',15,3),
(4,'iPhone 13 Pro Max',1400.00,'https://videotron.com/sites/default/files/styles/original_large/public/mobility_product/iPhone_13_Pro_Max_Silver_Pure_Back_iPhone_13_Pro_Max_Silver_Pure_Front_2-up_Screen__USEN_0.webp?itok=ZUIIWkkg',5,1),
(5,'Samsung Galaxy S22 +',1350.00,'https://videotron.com/sites/default/files/styles/original/public/mobility_product/Image1_15.webp?itok=GKJkQiKN',2,2);

-- INSERT INTO Facture value
-- (1,'2022-10-18',1),
-- (2,'2022-10-21',2);

-- INSERT INTO FactureItem value
-- (1,1,1,1),
-- (2,2,2,2);
