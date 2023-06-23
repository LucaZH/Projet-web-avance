create table admin
(
    id_admin     integer primary key autoincrement not null,
    email        varchar(20) not null,
    mot_de_passe varchar(20) not null
);

create table offre
(
    id_offre            integer primary key autoincrement not null,
    nom                 varchar(20) not null,
    espace_stockage     integer     not null,
    prix                float       not null,
    frequence_sauvegard integer     not null,
    id_admin            integer     not null,
    foreign key (id_admin) references admin (id_admin)
);

create table entreprise
(
    id_entreprise  integer primary key autoincrement not null,
    nom_entreprise varchar(100)       not null,
    mot_de_passe   varchar(100)       not null,
    nif            varchar(30)        not null,
    stat          varchar(30)        not null,
    email           varchar(50)        not null,
    logo           varchar(100),
    phone          varchar(10) unique not null,
    localisation   varchar(20)        not null,
    proprio        varchar(50)        not null,
    id_offre       integer            not null,
    foreign key (id_offre) references offre (id_offre)
);

create table base_de_donne
(
    id_base_donne integer primary key autoincrement not null,
    lien          varchar(50) not null,
    id_entreprise integer     not null,
    foreign key (id_entreprise) references entreprise (id_entreprise)

)