# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table account (
  id                        bigint not null,
  male                      boolean not null,
  firstname                 varchar(255) not null,
  lastname                  varchar(255) not null,
  email                     varchar(255) not null,
  authenticationKey         varchar(255),
  language                  varchar(255) not null,
  keep_session_open         boolean,
  password                  varchar(255) not null,
  is_admin                  boolean default false not null,
  is_super_admin            boolean default false not null,
  creation_date             timestamp not null,
  last_update               timestamp not null,
  constraint uq_account_email unique (email),
  constraint pk_account primary key (id))
;

create table session (
  id                        bigint not null,
  account_id                bigint not null,
  connection_date           timestamp,
  from_android              boolean,
  creation_date             timestamp not null,
  last_update               timestamp not null,
  constraint pk_session primary key (id))
;

create table translation (
  id                        bigint not null,
  creation_date             timestamp not null,
  last_update               timestamp not null,
  constraint pk_translation primary key (id))
;

create table translation_value (
  id                        bigint not null,
  translation_id            bigint,
  language_code             varchar(255) not null,
  content                   TEXT not null,
  creation_date             timestamp not null,
  last_update               timestamp not null,
  constraint pk_translation_value primary key (id))
;

create sequence account_seq;

create sequence session_seq;

create sequence translation_seq;

create sequence translation_value_seq;

alter table session add constraint fk_session_account_1 foreign key (account_id) references account (id);
create index ix_session_account_1 on session (account_id);
alter table translation_value add constraint fk_translation_value_translati_2 foreign key (translation_id) references translation (id);
create index ix_translation_value_translati_2 on translation_value (translation_id);



# --- !Downs

drop table if exists account cascade;

drop table if exists session cascade;

drop table if exists translation cascade;

drop table if exists translation_value cascade;

drop sequence if exists account_seq;

drop sequence if exists session_seq;

drop sequence if exists translation_seq;

drop sequence if exists translation_value_seq;

