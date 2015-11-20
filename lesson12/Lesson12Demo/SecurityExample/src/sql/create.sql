 
DROP TABLE IF EXISTS MEMBER;

create table MEMBER( ID BIGINT primary key AUTO_INCREMENT NOT NULL, 
						firstName varchar(25),
						lastName varchar(25),
						AGE BIGINT,
						MEMBERNUMBER BIGINT,
						title varchar(25)
					);
					
	DROP TABLE IF EXISTS users;
					
 create table users(
      username varchar_ignorecase(50) not null primary key,
      password varchar_ignorecase(50) not null,
      enabled boolean not null);

 	DROP TABLE IF EXISTS authorities;
 	
  create table authorities (
      username varchar_ignorecase(50) not null,
      authority varchar_ignorecase(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      create unique index ix_auth_username on authorities (username,authority);	