create table veiculo(
	veiculoId bigInt not null auto_increment,
	marca varchar(50) not null,
	modelo varchar(50)not null,
	ano varchar(4)not null,
	
	
	primary key(veiculoId)
);