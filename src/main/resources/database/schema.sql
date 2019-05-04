

-- # ======== Create Schema ===========
create schema if not exists quiz default character set = utf8mb4;

-- # ========= switch over to our table ===============
use quiz;

-- # ======== Create Tables ============
create table if not exists quiz
(
  id_quiz     int primary key auto_increment not null,
  title       varchar(64)                    not null,
  description varchar(255),
  difficulty  int

) engine = InnoDb,
  default charset = UTF8mb4;

create table if not exists question
(
  id_question         int primary key auto_increment not null,
  question            varchar(255)                   not null,
  question_difficulty int                            not null,
  fid_quiz            int                            not null
) engine = InnoDb,
  character set = utf8mb4;

create table if not exists answer
(
  id_answer int primary key auto_increment not null,
  fid_question       int                            not null,
  answer             varchar(255),
  correct            tinyint
) engine = InnoDb,
  character set = utf8mb4;

create table if not exists participant
(
  id_participant  int primary key auto_increment not null,
  name            varchar(45),
  email           varchar(45),
  fid_quiz        int                            not null,
  quiz_time_start datetime,
  quiz_time_end   datetime
) engine = InnoDB,
  character set = utf8mb4;

create table if not exists participant_answer
(
  id_participant_answer int primary key auto_increment not null,
  fid_participant       int                            not null,
  fid_quiz              int                            not null,
  fid_question          int                            not null,
  fid_answer   int                            not null,
  question_time_start   datetime,
  question_time_end     datetime
) engine = InnoDB,
  character set = utf8mb4;

-- # ============ Alter Table for add Constraint ===========

alter table question
  add constraint FK_question_has_quiz
    foreign key (fid_quiz)
      references quiz (id_quiz)
      on delete no action
      on update no action;

alter table answer
  add constraint FK_answer_has_question
    foreign key (fid_question)
      references question (id_question)
      on delete no action
      on update no action;

alter table participant
  add constraint FK_participant_has_quiz
    foreign key (fid_quiz)
      references quiz (id_quiz)
      on delete no action
      on update no action;

alter table participant_answer
  add constraint FK_participant_answer_has_participant
    foreign key (fid_participant)
      references participant (id_participant)
      on delete no action
      on update no action,
  add constraint FK_participant_answer_has_quiz
    foreign key (fid_quiz)
      references quiz (id_quiz)
      on delete no action
      on update no action,
  add constraint FK_participant_answer_has_question
    foreign key (fid_question)
      references question (id_question)
      on delete no action
      on update no action,
  add constraint FK_participant_answer_has_answer
    foreign key (fid_answer)
      references answer (id_answer)
      on delete no action
      on update no action;