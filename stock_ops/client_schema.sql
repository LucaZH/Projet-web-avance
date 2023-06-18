create table utilisateur
(
    id_utilisateur  integer autoincrement primary key,
    nom_utilisateur varchar(155) not null,
    mot_de_passe    varchar(100) not null,
    email           varchar(50)  not null,
    contact         varchar(10)  not null,
    image           varchar(200)
);

create table permission
(
    id_permission  integer autoincrement primary key,
    nom_permission varchar(255) not null
);


create table permission_utilisateur
(
    id_utilisateur integer not null,
    id_permission  integer not null,
    foreign key (id_utilisateur) references utilisateur (id_utilisateur),
    foreign key (id_permission) references permission (id_permission)
);


create table produit
(
    id_produit     integer autoincrement primary key,
    nom_du_produit varchar(100) not null,
    prix           varchar(20)  not null,
    description    varchar(255),
    stock          integer      not null
);

create table image
(
    id_image   integer autoincrement primary key,
    nom_image  varchar(100),
    id_produit integer not null,
    foreign key (id_produit) references produit (id_produit)
);

create table vente_produit
(
    id_vente       integer autoincrement primary key,
    date_d_achat   datetime default now(),
    quantite       int     not null,
    id_utilisateur integer not null,
    id_produit     integer not null,
    foreign key (id_utilisateur) references utilisateur (id_utilisateur),
    foreign key (id_produit) references utilisateur (id_produit)
);