# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table faq (
  id                        bigint not null,
  title                     varchar(255),
  question                  varchar(255),
  answer                    varchar(255),
  added_date                timestamp,
  updated_date              timestamp,
  constraint pk_faq primary key (id))
;

create table tag (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_tag primary key (id))
;


create table faq_tag (
  faq_id                         bigint not null,
  tag_id                         bigint not null,
  constraint pk_faq_tag primary key (faq_id, tag_id))
;
create sequence faq_seq;

create sequence tag_seq;




alter table faq_tag add constraint fk_faq_tag_faq_01 foreign key (faq_id) references faq (id) on delete restrict on update restrict;

alter table faq_tag add constraint fk_faq_tag_tag_02 foreign key (tag_id) references tag (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists faq;

drop table if exists faq_tag;

drop table if exists tag;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists faq_seq;

drop sequence if exists tag_seq;

