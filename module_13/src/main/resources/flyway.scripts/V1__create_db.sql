create table client (
    id int primary key auto_increment,
    client_name varchar(300) not null
);

create table planet (
    id varchar(255) primary key not null,
    planet_name varchar(500),
)

create table ticket (
    id int primary key auto_increment,
    created_at TIMESTAMP not null,
    client_id int,
    from_planet_id varchar(500)
    to_planet_id varchar(500)
    foreign key (client_id) references client(id),
    foreign key (from_planet_id) references planet(id),
    foreign key (to_planet_id) references planet(id)
);