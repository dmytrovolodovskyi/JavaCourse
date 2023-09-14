insert into buildings (address)
values
    ("street 1"),
    ("street 2"),
    ("street 3"),
    ("street 4"),
    ("street 5"),
    ("street 6"),
    ("street 7"),
    ("street 8"),
    ("street 9");

insert into flats (floor, number, area, building_id)
values
    (1, 101, 45.8, 1),
    (2, 102, 45.8, 2),
    (3, 103, 45.8, 3),
    (4, 104, 45.8, 4),
    (5, 105, 45.8, 5),
    (6, 106, 45.8, 6),
    (7, 107, 45.8, 7),
    (8, 108, 45.8, 8),
    (9, 109, 45.8, 9);

insert into members (name, flat_id)
values
    ("Name 1", 1),
    ("Name 2", 2),
    ("Name 3", 3),
    ("Name 4", 4),
    ("Name 5", 5),
    ("Name 6", 6),
    ("Name 7", 7),
    ("Name 8", 8),
    ("Name 9", 9);

insert into residents (name, email, has_access, member_id, flat_id)
values
    ("Name 1", "name1@gmail.com", 1, 1, 1),
    ("Name 2", "name1@gmail.com", 0, 2, 2),
    ("Name 3", "name1@gmail.com", 1, 3, 3),
    ("Name 4", "name1@gmail.com", 0, 4, 4),
    ("Name 5", "name1@gmail.com", 1, 5, 5),
    ("Name 6", "name1@gmail.com", 0, 6, 6),
    ("Name 7", "name1@gmail.com", 1, 7, 7),
    ("Name 8", "name1@gmail.com", 0, 8, 8),
    ("Name 9", "name1@gmail.com", 1, 9, 9);


insert into roles (role, member_id)
values
    ("member", 1),
    ("member", 2),
    ("member", 3),
    ("member", 4),
    ("member", 5),
    ("staff", 6),
    ("staff", 7),
    ("staff", 8),
    ("staff", 9);