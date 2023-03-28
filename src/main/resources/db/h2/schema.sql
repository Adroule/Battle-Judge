DROP TABLE userbattlejudge IF EXISTS;
CREATE TABLE userbattlejudge(
    id          int not null auto_increment,
    name        VARCHAR(30),
    mail        VARCHAR(50),
    password    VARCHAR(60),
    role        int
);