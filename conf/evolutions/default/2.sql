# --- Sample dataset

# --- !Ups

-- most highest table
insert into roll (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (1, 'roll1','2015-08-01', 1, '2015-09-01', 1, 0);
insert into roll (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (2, 'roll2','2015-08-01', 1, '2015-09-01', 1, 0);
insert into roll (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (3, 'roll3','2015-08-01', 1, '2015-09-01', 1, 0);
insert into roll (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (4, 'roll4','2015-08-01', 1, '2015-09-01', 1, 0);
insert into roll (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (5, 'roll5','2015-08-01', 1, '2015-09-01', 1, 0);
insert into roll (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (6, 'roll6','2015-08-01', 1, '2015-09-01', 1, 0);
insert into roll (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (7, 'roll7','2015-08-01', 1, '2015-09-01', 1, 0);
insert into roll (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (8, 'roll8','2015-08-01', 1, '2015-09-01', 1, 0);
insert into roll (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (9, 'roll9','2015-08-01', 1, '2015-09-01', 1, 0);

insert into tag (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (1, 'tag1','2015-08-01', 1, '2015-09-01', 1, 0);
insert into tag (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (2, 'tag2','2015-08-01', 1, '2015-09-01', 1, 0);
insert into tag (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (3, 'tag3','2015-08-01', 1, '2015-09-01', 1, 0);
insert into tag (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (4, 'tag4','2015-08-01', 1, '2015-09-01', 1, 0);
insert into tag (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (5, 'tag5','2015-08-01', 1, '2015-09-01', 1, 0);
insert into tag (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (6, 'tag6','2015-08-01', 1, '2015-09-01', 1, 0);
insert into tag (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (7, 'tag7','2015-08-01', 1, '2015-09-01', 1, 0);
insert into tag (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (8, 'tag8','2015-08-01', 1, '2015-09-01', 1, 0);
insert into tag (id, name, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (9, 'tag9','2015-08-01', 1, '2015-09-01', 1, 0);

insert into user (id, name, password, is_active, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (1, 'user1', 'password1', 1,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into user (id, name, password, is_active, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (2, 'user2', 'password2', 1,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into user (id, name, password, is_active, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (3, 'user3', 'password3', 1,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into user (id, name, password, is_active, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (4, 'user4', 'password4', 1,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into user (id, name, password, is_active, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (5, 'user5', 'password5', 1,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into user (id, name, password, is_active, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (6, 'user6', 'password6', 1,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into user (id, name, password, is_active, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (7, 'user7', 'password7', 1,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into user (id, name, password, is_active, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (8, 'user8', 'password8', 1,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into user (id, name, password, is_active, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (9, 'user9', 'password9', 1,'2015-08-01', 1, '2015-09-01', 1, 0);

-- middle table
insert into qanda (id, is_question, qanda_id, title, content, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (1, 1, null, 'very long long long 長いタイトル', 'content1','2015-08-01', 1, '2015-09-01', 1, 0);
insert into qanda (id, is_question, qanda_id, title, content, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (2, 1, null, 'title', 'content1','2015-08-01', 1, '2015-09-01', 1, 0);
insert into qanda (id, is_question, qanda_id, title, content, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (3, 1, null, 'title', 'content1','2015-08-01', 1, '2015-09-01', 1, 0);
insert into qanda (id, is_question, qanda_id, title, content, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (4, 1, null, 'title', 'content1','2015-08-01', 1, '2015-09-01', 1, 0);
insert into qanda (id, is_question, qanda_id, title, content, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (5, 1, null, 'title', 'content1','2015-08-01', 1, '2015-09-01', 1, 0);
insert into qanda (id, is_question, qanda_id, title, content, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (6, 0, 2, 'title', 'content1','2015-08-01', 1, '2015-09-01', 1, 0);
insert into qanda (id, is_question, qanda_id, title, content, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (7, 0, 1, 'title', 'content1','2015-08-01', 1, '2015-09-01', 1, 0);
insert into qanda (id, is_question, qanda_id, title, content, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (8, 0, 2, 'title', 'content1','2015-08-01', 1, '2015-09-01', 1, 0);
insert into qanda (id, is_question, qanda_id, title, content, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (9, 0, 4, 'title', 'content1','2015-08-01', 1, '2015-09-01', 1, 0);

-- most lowest table
insert into comment (id, qanda_id, comment, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (1, 1, 'comment1','2015-08-01', 1, '2015-09-01', 1, 0);
insert into comment (id, qanda_id, comment, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (2, 2, 'comment2','2015-08-01', 1, '2015-09-01', 1, 0);
insert into comment (id, qanda_id, comment, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (3, 3, 'comment3','2015-08-01', 1, '2015-09-01', 1, 0);
insert into comment (id, qanda_id, comment, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (4, 1, 'comment4','2015-08-01', 1, '2015-09-01', 1, 0);
insert into comment (id, qanda_id, comment, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (5, 5, 'comment5','2015-08-01', 1, '2015-09-01', 1, 0);
insert into comment (id, qanda_id, comment, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (6, 6, 'comment6','2015-08-01', 1, '2015-09-01', 1, 0);
insert into comment (id, qanda_id, comment, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (7, 6, 'comment7','2015-08-01', 1, '2015-09-01', 1, 0);
insert into comment (id, qanda_id, comment, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (8, 6, 'comment8','2015-08-01', 1, '2015-09-01', 1, 0);
insert into comment (id, qanda_id, comment, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (9, 9, 'comment9','2015-08-01', 1, '2015-09-01', 1, 0);

insert into evaluation (id, user_id, qanda_id, is_good, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (1, 1, 1, 1,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into evaluation (id, user_id, qanda_id, is_good, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (2, 2, 2, 1,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into evaluation (id, user_id, qanda_id, is_good, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (3, 3, 1, 1,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into evaluation (id, user_id, qanda_id, is_good, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (4, 4, 4, 1,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into evaluation (id, user_id, qanda_id, is_good, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (5, 5, 5, 0,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into evaluation (id, user_id, qanda_id, is_good, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (6, 6, 1, 0,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into evaluation (id, user_id, qanda_id, is_good, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (7, 7, 7, 0,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into evaluation (id, user_id, qanda_id, is_good, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (8, 8, 3, 0,'2015-08-01', 1, '2015-09-01', 1, 0);
insert into evaluation (id, user_id, qanda_id, is_good, create_time, create_user_id, update_time, update_user_id, is_delete)
  values (9, 9, 9, 0,'2015-08-01', 1, '2015-09-01', 1, 0);

insert into user_roll (user_id, roll_id)
  values (1, 1);
insert into user_roll (user_id, roll_id)
  values (2, 2);
insert into user_roll (user_id, roll_id)
  values (3, 3);
insert into user_roll (user_id, roll_id)
  values (4, 4);
insert into user_roll (user_id, roll_id)
  values (5, 5);
insert into user_roll (user_id, roll_id)
  values (6, 6);
insert into user_roll (user_id, roll_id)
  values (7, 7);
insert into user_roll (user_id, roll_id)
  values (8, 8);
insert into user_roll (user_id, roll_id)
  values (9, 9);

insert into qanda_tag (qanda_id, tag_id)
  values (1, 1);
insert into qanda_tag (qanda_id, tag_id)
  values (2, 2);
insert into qanda_tag (qanda_id, tag_id)
  values (1, 3);
insert into qanda_tag (qanda_id, tag_id)
  values (4, 4);
insert into qanda_tag (qanda_id, tag_id)
  values (3, 5);
insert into qanda_tag (qanda_id, tag_id)
  values (2, 6);
insert into qanda_tag (qanda_id, tag_id)
  values (1, 4);
insert into qanda_tag (qanda_id, tag_id)
  values (1, 8);
insert into qanda_tag (qanda_id, tag_id)
  values (5, 9);

# --- !Downs

delete from comment;
delete from evaluation;
delete from user_roll;
delete from qanda_tag;
delete from qanda;
delete from roll;
delete from tag;
delete from user;
