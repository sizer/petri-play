# --- Sample dataset

# --- !Ups

insert into tag (id, name) values ( 1, 'tag1');
insert into tag (id, name) values ( 2, 'tag2');
insert into tag (id, name) values ( 3, 'tag3');
insert into tag (id, name) values ( 4, 'tag4');
insert into tag (id, name) values ( 5, 'tag5');
insert into tag (id, name) values ( 6, 'tag6');
insert into tag (id, name) values ( 7, 'tag7');
insert into tag (id, name) values ( 8, 'tag8');
insert into tag (id, name) values ( 9, 'tag9');

insert into qanda (id, title, content, is_question, create_time, update_time) values ( 1, 'title1', 'conent1', 1, '2015-08-01', '2015-09-01');
insert into qanda (id, title, content, is_question, create_time, update_time) values ( 2, 'title2', 'conent2', 1, '2015-08-01', '2015-09-01');
insert into qanda (id, title, content, is_question, create_time, update_time) values ( 3, 'title3', 'conent3', 1, '2015-08-01', '2015-09-01');
insert into qanda (id, title, content, is_question, create_time, update_time) values ( 4, 'title4', 'conent4', 0, '2015-08-01', '2015-09-01');
insert into qanda (id, title, content, is_question, create_time, update_time) values ( 5, 'title5', 'conent5', 0, '2015-08-01', '2015-09-01');
insert into qanda (id, title, content, is_question, create_time, update_time) values ( 6, 'title6', 'conent6', 0, '2015-08-01', '2015-09-01');
insert into qanda (id, title, content, is_question, create_time, update_time) values ( 7, 'title7', 'conent7', 0, '2015-08-01', '2015-09-01');
insert into qanda (id, title, content, is_question, create_time, update_time) values ( 8, 'title8', 'conent8', 0, '2015-08-01', '2015-09-01');
insert into qanda (id, title, content, is_question, create_time, update_time) values ( 9, 'title9', 'conent9', 0, '2015-08-01', '2015-09-01');

insert into qanda_tag (qanda_id, tag_id) values (1, 1);
insert into qanda_tag (qanda_id, tag_id) values (2, 2);
insert into qanda_tag (qanda_id, tag_id) values (3, 3);
insert into qanda_tag (qanda_id, tag_id) values (4, 4);
insert into qanda_tag (qanda_id, tag_id) values (5, 5);
insert into qanda_tag (qanda_id, tag_id) values (6, 6);
insert into qanda_tag (qanda_id, tag_id) values (7, 7);
insert into qanda_tag (qanda_id, tag_id) values (8, 8);
insert into qanda_tag (qanda_id, tag_id) values (9, 9);

# --- !Downs

delete from qanda_tag;
delete from tag;
delete from faq;
