INSERT INTO actor (id,name) VALUES
	 (1,'Paulo'),
	 (2,'Rafael'),
	 (3,'Theo'),
	 (4,'Carlos'),
	 (5,'Davi'),
	 (6,'Laura'),
	 (7,'Natalia'),
	 (8,'Valentina'),
	 (9,'Ester'),
	 (10,'Daniele');

INSERT INTO director (id,name) VALUES
	 (1,'Paulin'),
	 (2,'Joao'),
	 (3,'Thiago'),
	 (4,'Pedro'),
	 (5,'Miguel'),
	 (6,'Helena'),
	 (7,'Alice'),
	 (8,'Joana');

INSERT INTO genre (id,name) VALUES
	 (1,'terror'),
	 (2,'comedia'),
	 (3,'romance'),
	 (4,'aventura');

INSERT INTO movie (id,title,director_id) VALUES
	 (1,'Filmasso',1),
	 (2,'filmeGeneroTeste',1),
	 (3,'Fracture',1),
	 (4,'Sting',1),
	 (5,'Piano',1),
	 (6,'Focus',1),
	 (7,'Yard',1),
	 (8,'Gambit',2),
	 (9,'Reis',3),
	 (10,'Once',3);
INSERT INTO movie (id,title,director_id) VALUES
	 (11,'Tokyo',4),
	 (12,'Love',5),
	 (13,'Remember',6),
	 (14,'Flash',7),
	 (15,'Switch',8);

INSERT INTO `user` (username,password,is_admin,token,is_active) VALUES
                   	 ('123123','$2a$10$uXwEM2YR2dqVlEBXCwp/WOnAH2Yff7UhQaRCYifWxMR8hRfKQraB2',1,NULL,1),
                   	 ('armando','$2a$10$nwaldWqfoGshXa5laO4na.0H05sCWG56iVAB7ppdt8GwtxXj6FosO',0,NULL,1),
                   	 ('benicio','$2a$10$JfJ5rqpMocAO1gQUJTOCneerPBATtbQ0qAaz9j1oActMKVS/S9dQi',0,NULL,1),
                   	 ('camila','$2a$10$T1ukqrOs/zlKEgpj4Wu0M.DyRSw4.ZadcSZRJtCFSkM2aEdsvx/gW',0,NULL,1),
                   	 ('finalUser','$2a$10$XNUOU8O8dM5UEuehT96w5.v6r/G/vIJd55f0uC3xe1J3Gsb1BAGs6',1,NULL,1),
                   	 ('Rafael','$2a$10$Gv5iB2l0WypwPElNQECfE.bo22u7FzaWd7J68I1JEsatRoUVFB4d6',1,NULL,1),
                   	 ('userAdmin','$2a$10$XfjmCObdBdYJPGuslQHgIuG7mNuYSPeKd0zfmtXQ6SGiT23vcu1Aa',1,NULL,1);

INSERT INTO actor_movie (id,actor_id,movie_id) VALUES
	 (1,1,1),
	 (2,2,1),
	 (3,2,2),
	 (4,3,1),
	 (5,4,1),
	 (6,5,1),
	 (7,6,1),
	 (8,7,1),
	 (9,8,1),
	 (10,8,2);
INSERT INTO actor_movie (id,actor_id,movie_id) VALUES
	 (11,8,3),
	 (12,8,4),
	 (13,8,5),
	 (14,5,6),
	 (15,5,7),
	 (16,5,8),
	 (17,3,9),
	 (18,3,10),
	 (19,3,11),
	 (20,6,12);
INSERT INTO actor_movie (id,actor_id,movie_id) VALUES
	 (21,5,13),
	 (22,5,14),
	 (23,5,15);

INSERT INTO genre_movie (id,genre_id,movie_id) VALUES
	 (1,1,2),
	 (2,2,2),
	 (3,4,1),
	 (4,4,3),
	 (5,4,5),
	 (6,4,7),
	 (7,4,8),
	 (8,4,9),
	 (9,4,11),
	 (10,4,13);
INSERT INTO genre_movie (id,genre_id,movie_id) VALUES
	 (11,1,15),
	 (12,1,14),
	 (13,2,12),
	 (14,2,10),
	 (15,2,8),
	 (16,2,6),
	 (17,2,7),
	 (18,2,9),
	 (19,2,1),
	 (20,3,4);
INSERT INTO genre_movie (id,genre_id,movie_id) VALUES
	 (21,4,12);

INSERT INTO vote (score,`user`,movie_id) VALUES
	 (3.4,NULL,1),
	 (3.5,NULL,1),
	 (4.0,NULL,1),
	 (2.5,NULL,2),
	 (2.3,NULL,2),
	 (2.3,NULL,3),
	 (2.7,NULL,3),
	 (2.8,NULL,4),
	 (3.1,NULL,4),
	 (1.4,NULL,4);
INSERT INTO vote (score,`user`,movie_id) VALUES
	 (1.4,NULL,5),
	 (1.6,NULL,5),
	 (1.6,NULL,6),
	 (2.6,NULL,7),
	 (2.6,NULL,8),
	 (2.3,NULL,9),
	 (2.9,NULL,10),
	 (3.0,NULL,11),
	 (3.0,NULL,12),
	 (3.0,NULL,13);
INSERT INTO vote (score,`user`,movie_id) VALUES
	 (3.0,NULL,14),
	 (2.6,NULL,15);

