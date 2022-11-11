insert into cozinha(nome) values("Japonesa");
insert into cozinha(nome) values("Chinesa");

insert into restaurante(nome, taxa_frete, cozinha_id) values("Tosh", 10, 1);
insert into restaurante(nome, taxa_frete, cozinha_id) values("Miagy", 8, 1);
insert into restaurante(nome, taxa_frete, cozinha_id) values("China in box", 5, 2);

insert into forma_pagamento(descricao) values("Cartão");
insert into forma_pagamento(descricao) values("Boleto");
insert into forma_pagamento(descricao) values("Vale Refeição");

insert into permissao(nome, descricao) values("João", "Consultar Produtos");
insert into permissao(nome, descricao) values("Maria", "Vender Produtos");
insert into permissao(nome, descricao) values("Carlos", "Consultar Produtos");

insert into estado(nome) values("Santa Catarina");
insert into estado(nome) values("Rio de Janeiro");

insert into cidade(nome, estado_id) values("Palhoça", 1);
insert into cidade(nome, estado_id) values("Florianópolis", 1);
insert into cidade(nome, estado_id) values("Rio de Janeiro", 2);