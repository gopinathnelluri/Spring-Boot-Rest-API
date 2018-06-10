DROP TABLE vehicles;
CREATE TABLE vehicles (vehicle_id bigint auto_increment, 
	brand varchar(255),
	model varchar(255),
	year int, 
	speed int, 
	type varchar(255), 
	description varchar(255));