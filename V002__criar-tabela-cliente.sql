create table cliente(
clienteId bigint not null auto_increment,
nome varchar (100) not null,
cpf varchar(13)  not null,
dataNascimento varchar (11) not null,
email varchar (255) not null,

primary key(clienteId)
);

