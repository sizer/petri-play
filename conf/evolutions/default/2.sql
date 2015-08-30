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

insert into faq (id, title, question, answer) values ( 1, 'title1', 'question1', 'answer1');
insert into faq (id, title, question, answer) values ( 2, 'title2', 'question2', 'answer2');
insert into faq (id, title, question, answer) values ( 3, 'title3', 'question3', 'answer3');
insert into faq (id, title, question, answer) values ( 4, 'title4', 'question4', 'answer4');
insert into faq (id, title, question, answer) values ( 5, 'title5', 'question5', 'answer5');
insert into faq (id, title, question, answer) values ( 6, 'title6', 'question6', 'answer6');
insert into faq (id, title, question, answer) values ( 7, 'title7', 'question7', 'answer7');
insert into faq (id, title, question, answer) values ( 8, 'title8', 'question8', 'answer8');
insert into faq (id, title, question, answer) values ( 9, 'title9', 'question9', 'answer9');

insert into faq_tag (faq_id, tag_id) values (1, 1);
insert into faq_tag (faq_id, tag_id) values (2, 2);
insert into faq_tag (faq_id, tag_id) values (3, 3);
insert into faq_tag (faq_id, tag_id) values (4, 4);
insert into faq_tag (faq_id, tag_id) values (5, 5);
insert into faq_tag (faq_id, tag_id) values (6, 6);
insert into faq_tag (faq_id, tag_id) values (7, 7);
insert into faq_tag (faq_id, tag_id) values (8, 8);
insert into faq_tag (faq_id, tag_id) values (9, 9);

# --- !Downs

delete from faq_tag;
delete from tag;
delete from faq;
