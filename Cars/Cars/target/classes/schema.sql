 /* 車の情報を記載するテーブル作成*/ 
 /*liability_ins = 自賠責, voluntary_ins = 任意保険*/
 CREATE TABLE cars(
 	id INT, name VARCHAR(100), car_tax FLOAT, weight_tax FLOAT, liability_ins FLOAT,
 	voluntary_ins FLOAT, month_total FLOAT
 	);
 /*月間固定維持費*/
 INSERT INTO cars VALUES
 	(1, 'WRX STI', 0.33, 0.13, 0.13, 0.22, 2.8),(2, 'GT-R', 0.56, 0.14, 0.13, 2.43, 3.26), (3, 'SwiftSports', 0.29, 0.07, 0.13, 1.92, 2.41),
 	(4, 'Copen',  0.08, 0.02, 0.13, 1.25, 1.48), (5, 'Aqua', 0.29, 0.07, 0.13, 1.25, 2.58), (6, 'Hustler', 0.08, 0.02, 0.13, 1.33, 1.56),
 	(7, 'LX', 0.73, 0.13, 0.13, 3.17, 4.16), (8, 'S550', 0.73, 0.08, 0.13, 3.25, 4.20), (9,'Alphard', 0.38, 0.08, 0.13, 2.33, 2.93),
 	(10, '318i', 0.29, 0.08, 0.13, 2.25, 2.76), (11, 'Prius', 0.33, 0.06, 0.13, 1.92, 2.44), (12, 'X-trail', 0.33, 0.08, 0.13, 2.17, 2.71);
 	
 	
/* 	価格表*/
 CREATE TABLE price(
 	id INT, price INT  
 	); 	
 /*価格（万円）*/
 INSERT INTO price VALUES
 	(1, 450), (2, 1170), (3, 183), (4, 187), (5, 188), (6, 135),
 	(7, 1115), (8, 1360), (9,370), (10, 457), (11, 278), (12, 240);
 
 /*燃費表*/
 CREATE TABLE fuel(
 	id INT, fuel_ec FLOAT  
 	); 
 
 /*(km/l)*/
 INSERT INTO fuel VALUES
 	(1, 9.4), (2, 8.7), (3, 16.4), (4, 22.2), (5, 34.4), (6, 33.4),
 	(7,  6.5), (8, 6.7), (9, 11.6), (10, 13.2), (11,37.2), (12, 16.0);
 	
 	
 CREATE TABLE userspec(
 	income FLOAT,rent FLOAT, utility_c FLOAT, commu_c FLOAT, budget FLOAT
 	); 
 	
 