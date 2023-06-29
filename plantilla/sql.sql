-- -----------------------------------------------------
-- Table `pgsql`.`users`
-- -----------------------------------------------------
CREATE TABLE users(
  id serial not null primary key,
  name VARCHAR(155) NOT NULL,
  lastname VARCHAR(155) NOT NULL,
  username VARCHAR(16) UNIQUE NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  token_exp bigint DEFAULT 0,
  enabled boolean DEFAULT false,
  darkmode boolean NULL DEFAULT false,
  created_at TIMESTAMP(0) WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP(0) WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------
-- Table `pgsql`.`roles`
-- -----------------------------------------------------
CREATE TABLE roles (
  id serial not null primary key,
  name VARCHAR(255) NOT NULL,
  user_id int not null,
  constraint fk_user_roles foreign key(user_id) references users(id) on update cascade on delete cascade
);

create unique index role_users_index on roles(name, user_id);


-- -----------------------------------------------------
-- Table `pgsql`.`registration_token`
-- -----------------------------------------------------

create table account_token (
	id serial not null primary key,
	user_id int not null,
	token varchar(85),
	expiration bigint,
	type_token varchar(50) NOT NULL,
	validate boolean default false,
	constraint fk_user_registration_token foreign key(user_id) references users(id) on update cascade on delete cascade
);

create unique index account_token_index on account_token(user_id, type_token);