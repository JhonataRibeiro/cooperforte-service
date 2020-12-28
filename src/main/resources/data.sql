insert into perfil(id, papel) values (1,'USUARIO')
insert into perfil(id, papel) values (2,'ADMIN')

insert into usuario(id, nome, perfil, senha, email) values (1, 'Admin', 2, '$2a$10$OcR7cgVliPasiknwWkGEJe1lMZKsbtpTevciuvb/ph1s6ot9HiraK', 'admin')
insert into usuario(id, nome, perfil, senha, email) values (2, 'Usuario', 1, '$2a$10$OcR7cgVliPasiknwWkGEJe1lMZKsbtpTevciuvb/ph1s6ot9HiraK', 'usuario')