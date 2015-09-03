# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table abstract_trail_model (
  create_time               timestamp,
  create_user_id            integer,
  update_time               timestamp,
  update_user_id            integer,
  id_delete                 integer)
;

create table comment (
  id                        bigint not null,
  create_time               timestamp,
  create_user_id            integer,
  update_time               timestamp,
  update_user_id            integer,
  id_delete                 integer,
  comment                   varchar(255),
  constraint pk_comment primary key (id))
;

create table faq (
  id                        bigint not null,
  create_time               timestamp,
  create_user_id            integer,
  update_time               timestamp,
  update_user_id            integer,
  id_delete                 integer,
  title                     varchar(255),
  question                  varchar(255),
  answer                    varchar(255),
  constraint pk_faq primary key (id))
;

create table roll (
  id                        bigint not null,
  create_time               timestamp,
  create_user_id            integer,
  update_time               timestamp,
  update_user_id            integer,
  id_delete                 integer,
  name                      varchar(255),
  constraint pk_roll primary key (id))
;

create table tag (
  id                        bigint not null,
  create_time               timestamp,
  create_user_id            integer,
  update_time               timestamp,
  update_user_id            integer,
  id_delete                 integer,
  name                      varchar(255),
  constraint pk_tag primary key (id))
;

create table user (
  id                        bigint not null,
  create_time               timestamp,
  create_user_id            integer,
  update_time               timestamp,
  update_user_id            integer,
  id_delete                 integer,
  name                      varchar(255),
  password                  varchar(255),
  is_active                 integer,
  constraint pk_user primary key (id))
;


create table faq_tag (
  faq_id                         bigint not null,
  tag_id                         bigint not null,
  constraint pk_faq_tag primary key (faq_id, tag_id))
;
create sequence comment_seq;

create sequence faq_seq;

create sequence roll_seq;

create sequence tag_seq;

create sequence user_seq;




alter table faq_tag add constraint fk_faq_tag_faq_01 foreign key (faq_id) references faq (id) on delete restrict on update restrict;

alter table faq_tag add constraint fk_faq_tag_tag_02 foreign key (tag_id) references tag (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists abstract_trail_model;

drop table if exists comment;

drop table if exists faq;

drop table if exists faq_tag;

drop table if exists roll;

drop table if exists tag;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists comment_seq;

drop sequence if exists faq_seq;

drop sequence if exists roll_seq;

drop sequence if exists tag_seq;

drop sequence if exists user_seq;

