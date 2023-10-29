insert into client (name) values
    ("Client 1"),
    ("Client 2"),
    ("Client 3"),
    ("Client 4"),
    ("Client 5"),
    ("Client 6"),
    ("Client 7"),
    ("Client 8"),
    ("Client 9"),
    ("Client 10");

insert into planet (id, planet_name) values
    ('MARS', 'Mars'),
    ('VENUS', 'Venus'),
    ('EARTH', 'Earth'),
    ('JUPITER', 'Jupiter'),
    ('SATURN', 'Saturn');

insert into ticket (created_at, client_id, from_planet_id, to_planet_id) values
    ('2023-10-28 12:00:00', 1, 'MARS', 'EARTH'),
    ('2023-10-28 12:30:00', 2, 'VENUS', 'MARS'),
    ('2023-10-28 13:00:00', 3, 'EARTH', 'JUPITER'),
    ('2023-10-28 13:30:00', 4, 'MARS', 'SATURN'),
    ('2023-10-28 14:00:00', 5, 'SATURN', 'VENUS'),
    ('2023-10-28 14:30:00', 6, 'MARS', 'EARTH'),
    ('2023-10-28 15:00:00', 7, 'JUPITER', 'SATURN'),
    ('2023-10-28 15:30:00', 8, 'EARTH', 'MARS'),
    ('2023-10-28 16:00:00', 9, 'MARS', 'VENUS'),
    ('2023-10-28 16:30:00', 10, 'SATURN', 'EARTH');