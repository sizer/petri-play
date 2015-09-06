# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table comment (
  id                        bigint         not null,
  qanda_id                  bigint         not null,
  comment                   varchar(1000),
  create_time               timestamp      not null,
  create_user_id            integer        not null,
  update_time               timestamp      not null,
  update_user_id            integer        not null,
  is_delete                 integer        not null,
  constraint pk_comment     primary key (id))
;

create table evaluation (
  id                        bigint         not null,
  user_id                   bigint         not null,
  qanda_id                  bigint         not null,
  is_good                   integer,
  create_time               timestamp      not null,
  create_user_id            integer        not null,
  update_time               timestamp      not null,
  update_user_id            integer        not null,
  is_delete                 integer        not null,
  constraint pk_evaluation  primary key (id))
;

create table qanda (
  id                        bigint         not null,
  user_id                   bigint         not null,
  is_question               integer        not null,
  qanda_id                  bigint,
  title                     varchar(2000),
  content                   varchar(2000),
  create_time               timestamp      not null,
  create_user_id            integer        not null,
  update_time               timestamp      not null,
  update_user_id            integer        not null,
  is_delete                 integer        not null,
  constraint pk_qanda       primary key (id))
;

create table roll (
  id                        bigint         not null,
  name                      varchar(20),
  create_time               timestamp      not null,
  create_user_id            integer        not null,
  update_time               timestamp      not null,
  update_user_id            integer        not null,
  is_delete                 integer        not null,
  constraint pk_roll        primary key (id))
;

create table tag (
  id                        bigint         not null,
  name                      varchar(20),
  create_time               timestamp      not null,
  create_user_id            integer        not null,
  update_time               timestamp      not null,
  update_user_id            integer        not null,
  is_delete                 integer        not null,
  constraint pk_tag         primary key (id))
;

create table user (
  id                        bigint         not null,
  name                      varchar(20),
  password                  varchar(255),
  is_active                 integer,
  create_time               timestamp      not null,
  create_user_id            integer        not null,
  update_time               timestamp      not null,
  update_user_id            integer        not null,
  is_delete                 integer        not null,
  constraint pk_user        primary key (id))
;

create table qanda_tag (
  qanda_id                  bigint         not null,
  tag_id                    bigint         not null,
  constraint pk_qanda_tag   primary key (qanda_id, tag_id))
;

create table user_roll (
  user_id                   bigint         not null,
  roll_id                   bigint         not null,
  constraint pk_user_roll   primary key (user_id, roll_id))
;

create sequence comment_seq;
create sequence evaluation_seq;
create sequence faq_seq;
create sequence qanda_seq;
create sequence roll_seq;
create sequence tag_seq;
create sequence user_seq;

alter table comment    add constraint fk_comment_qanda_1    foreign key (qanda_id) references qanda (id) on delete restrict on update restrict;
alter table evaluation add constraint fk_evaluation_user_1  foreign key (qanda_id) references qanda (id) on delete restrict on update restrict;
alter table evaluation add constraint fk_evaluation_user_2  foreign key (user_id)  references user (id)  on delete restrict on update restrict;
alter table qanda      add constraint fk_qanda_user_1       foreign key (qanda_id) references qanda (id) on delete restrict on update restrict;
alter table qanda      add constraint fk_qanda_user_2       foreign key (user_id)  references user (id)  on delete restrict on update restrict;
alter table qanda_tag  add constraint fk_qanda_tag_qanda_01 foreign key (qanda_id) references qanda (id) on delete restrict on update restrict;
alter table qanda_tag  add constraint fk_qanda_tag_tag_02   foreign key (tag_id)   references tag (id)   on delete restrict on update restrict;
alter table user_roll  add constraint fk_user_roll_user_01  foreign key (user_id)  references user (id)  on delete restrict on update restrict;
alter table user_roll  add constraint fk_user_roll_roll_02  foreign key (roll_id)  references roll (id)  on delete restrict on update restrict;

create index ix_comment_qanda_1   on comment (qanda_id);
create index ix_evaluation_user_2 on evaluation (user_id);
create index ix_qanda_user_3      on qanda (user_id);

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists comment;
drop table if exists evaluation;
drop table if exists faq;
drop table if exists qanda;
drop table if exists qanda_tag;
drop table if exists roll;
drop table if exists tag;
drop table if exists user;
drop table if exists user_roll;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists comment_seq;
drop sequence if exists evaluation_seq;
drop sequence if exists faq_seq;
drop sequence if exists qanda_seq;
drop sequence if exists roll_seq;
drop sequence if exists tag_seq;
drop sequence if exists user_seq;
