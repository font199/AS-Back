set search_path to "carme.quer";

create table instalacions(nomI char(30), adreca varchar(50),primary key (nomI));

create table biblioteques(nomI char(30), publica boolean, primary key (nomI),foreign key (nomI) references instalacions);

create table altresInstalacions(nomI char(30), primary key (nomI),foreign key (nomI) references instalacions);

create table socis(nomS varchar(50), edat integer, nomInst char(30), primary key (nomS), foreign key (nomInst) references instalacions);

create table llibres(isbn char(20), titol varchar(70), primary key (isbn));

create table exemplars(isbn char(20), nomB char(30), quants integer, primary key (isbn,nomB), foreign key (isbn) references llibres, foreign key (nomB) references biblioteques);


