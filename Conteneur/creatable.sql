clear screen;

drop table personnel;

create table personnel
(
  matricule char(5),
  nom varchar(20) not null,
  numtel number not null,
  categorie char not null,
  tauxHoraire number,
  nbHeures number,
  indemnites number,
  pourcentage number,
  totalVentes number,
  
  constraint pk_personnel primary key (matricule)
);

insert into personnel
values ('M1001', 'a', 0606060606, 'E',  20, 35, null,  null, null);

insert into personnel
values ('M1002', 'b', 0707070707, 'C', 15, 40, null, 10, 100);

insert into personnel
values ('M1003', 'c', 0808080808, 'D', null, null, 30000, null, null);