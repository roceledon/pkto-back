DROP TABLE IF EXISTS USERS;

CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  nick varchar(100) NOT NULL,
  friendCode varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);