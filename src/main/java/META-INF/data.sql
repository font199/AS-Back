set search_path to "carme.quer";

insert into instalacions values('ajuntament','placa de sant jaume 1');
insert into instalacions values('gimnas eixample','carrer pau claris 20');
insert into instalacions values('biblioteca can roses','carrer deu i mata 57');
insert into instalacions values('biblioteca jaume fuster','placa de lesseps 20-22');
insert into instalacions values('biblioteca borja','avinguda torreblanca 59');
insert into instalacions values('biblioteca la florida','avinguda masnou 89');

insert into altresInstalacions values('ajuntament');
insert into altresInstalacions values('gimnas eixample');

insert into biblioteques values('biblioteca can roses',true);
insert into biblioteques values('biblioteca la florida',true);
insert into biblioteques values('biblioteca jaume fuster',true);
insert into biblioteques values('biblioteca borja',false);

insert into socis values('pere camp',20,'biblioteca jaume fuster');
insert into socis values('anna porta',22,'gimnas eixample');
insert into socis values('ot pi',22,'biblioteca la florida');
insert into socis values('pau xisc',22,'biblioteca la florida');
insert into socis values('pere masnou',30,'biblioteca la florida');
insert into socis values('ona garcia',21,'biblioteca borja');
insert into socis values('josep rius',19,'biblioteca borja');

insert into llibres values('111','Vida extra. Els videojocs com no els has vist mai');
insert into llibres values('222','Videojuegos y mundos de ficcion. De Supermario a Portal');
insert into llibres values('333','De Supermario a Lara Croft, La historia oculta de los videojuegos');
insert into llibres values('444','La invasión de los marcianitos');

insert into exemplars values('111','biblioteca can roses',2);
insert into exemplars values('111','biblioteca jaume fuster',3);
insert into exemplars values('333','biblioteca jaume fuster',4);
insert into exemplars values('222','biblioteca can roses',1);
insert into exemplars values('222','biblioteca jaume fuster',1);
