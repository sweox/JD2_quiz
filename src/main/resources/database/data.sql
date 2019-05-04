

insert into quiz (title, description, difficulty) values ("Простой тест", "Это самый простой тест", 1);
insert into quiz (title, description, difficulty) values ("Cредний уровень", "Этот тест для подготовленных", 5);
insert into quiz (title, description, difficulty) values ("Сложный тест", "Этот тест для продвинутых", 10);



insert into question (question, question_difficulty, fid_quiz) values ("Вопрос простого теста 1", 1, 1);
insert into question (question, question_difficulty, fid_quiz) values ("Вопрос простого теста 2", 1, 1);
insert into question (question, question_difficulty, fid_quiz) values ("Вопрос простого теста 3", 1, 1);
insert into question (question, question_difficulty, fid_quiz) values ("Вопрос простого теста 4", 1, 1);
insert into question (question, question_difficulty, fid_quiz) values ("Вопрос простого теста 5", 1, 1);

insert into question (question, question_difficulty, fid_quiz) values ("Вопрос теста среднего уровня 1", 5, 2);
insert into question (question, question_difficulty, fid_quiz) values ("Вопрос теста среднего уровня 2", 5, 2);
insert into question (question, question_difficulty, fid_quiz) values ("Вопрос теста среднего уровня 3", 5, 2);
insert into question (question, question_difficulty, fid_quiz) values ("Вопрос теста среднего уровня 4", 5, 2);
insert into question (question, question_difficulty, fid_quiz) values ("Вопрос теста среднего уровня 5", 5, 2);

insert into question (question, question_difficulty, fid_quiz) values ("Вопрос сложного теста 1", 10, 3);
insert into question (question, question_difficulty, fid_quiz) values ("Вопрос сложного теста 2", 10, 3);
insert into question (question, question_difficulty, fid_quiz) values ("Вопрос сложного теста 3", 10, 3);
insert into question (question, question_difficulty, fid_quiz) values ("Вопрос сложного теста 4", 10, 3);
insert into question (question, question_difficulty, fid_quiz) values ("Вопрос сложного теста 5", 10, 3);



insert into answer (fid_question, answer, correct) values (1, "Ответ на вопрос 1 -", 0);
insert into answer (fid_question, answer, correct) values (1, "Ответ на вопрос 1 +", 1);
insert into answer (fid_question, answer, correct) values (1, "Ответ на вопрос 1 -", 0);

insert into answer (fid_question, answer, correct) values (2, "Ответ на вопрос 2 -", 0);
insert into answer (fid_question, answer, correct) values (2, "Ответ на вопрос 2 +", 1);

insert into answer (fid_question, answer, correct) values (3, "Ответ на вопрос 3 +", 1);
insert into answer (fid_question, answer, correct) values (3, "Ответ на вопрос 3 -", 0);
insert into answer (fid_question, answer, correct) values (3, "Ответ на вопрос 3 -", 0);

insert into answer (fid_question, answer, correct) values (4, "Ответ на вопрос 4 +", 1);
insert into answer (fid_question, answer, correct) values (4, "Ответ на вопрос 4 -", 0);
insert into answer (fid_question, answer, correct) values (4, "Ответ на вопрос 4 -", 0);

insert into answer (fid_question, answer, correct) values (5, "Ответ на вопрос 5 -", 0);
insert into answer (fid_question, answer, correct) values (5, "Ответ на вопрос 5 -", 0);
insert into answer (fid_question, answer, correct) values (5, "Ответ на вопрос 5 -", 0);
insert into answer (fid_question, answer, correct) values (5, "Ответ на вопрос 5 +", 1);
insert into answer (fid_question, answer, correct) values (5, "Ответ на вопрос 5 -", 0);



insert into answer (fid_question, answer, correct) values (6, "Ответ на вопрос 6 -", 0);
insert into answer (fid_question, answer, correct) values (6, "Ответ на вопрос 6 -", 0);
insert into answer (fid_question, answer, correct) values (6, "Ответ на вопрос 6 +", 1);
insert into answer (fid_question, answer, correct) values (6, "Ответ на вопрос 6 -", 0);

insert into answer (fid_question, answer, correct) values (7, "Ответ на вопрос 7 -", 0);
insert into answer (fid_question, answer, correct) values (7, "Ответ на вопрос 7 +", 1);
insert into answer (fid_question, answer, correct) values (7, "Ответ на вопрос 7 -", 0);
insert into answer (fid_question, answer, correct) values (7, "Ответ на вопрос 7 -", 0);

insert into answer (fid_question, answer, correct) values (8, "Ответ на вопрос 8 -", 0);
insert into answer (fid_question, answer, correct) values (8, "Ответ на вопрос 8 -", 0);
insert into answer (fid_question, answer, correct) values (8, "Ответ на вопрос 8 +", 1);

insert into answer (fid_question, answer, correct) values (9, "Ответ на вопрос 9 +", 1);
insert into answer (fid_question, answer, correct) values (9, "Ответ на вопрос 9 -", 0);
insert into answer (fid_question, answer, correct) values (9, "Ответ на вопрос 9 -", 0);

insert into answer (fid_question, answer, correct) values (10, "Ответ на вопрос 10 -", 0);
insert into answer (fid_question, answer, correct) values (10, "Ответ на вопрос 10 -", 0);
insert into answer (fid_question, answer, correct) values (10, "Ответ на вопрос 10 +", 1);
insert into answer (fid_question, answer, correct) values (10, "Ответ на вопрос 10 -", 0);
insert into answer (fid_question, answer, correct) values (10, "Ответ на вопрос 10 -", 0);



insert into answer (fid_question, answer, correct) values (11, "Ответ на вопрос 11 -", 0);
insert into answer (fid_question, answer, correct) values (11, "Ответ на вопрос 11 -", 0);
insert into answer (fid_question, answer, correct) values (11, "Ответ на вопрос 11 -", 0);
insert into answer (fid_question, answer, correct) values (11, "Ответ на вопрос 11 +", 1);

insert into answer (fid_question, answer, correct) values (12, "Ответ на вопрос 12 +", 1);
insert into answer (fid_question, answer, correct) values (12, "Ответ на вопрос 12 -", 0);
insert into answer (fid_question, answer, correct) values (12, "Ответ на вопрос 12 -", 0);
insert into answer (fid_question, answer, correct) values (12, "Ответ на вопрос 12 -", 0);

insert into answer (fid_question, answer, correct) values (13, "Ответ на вопрос 13 -", 0);
insert into answer (fid_question, answer, correct) values (13, "Ответ на вопрос 13 -", 0);
insert into answer (fid_question, answer, correct) values (13, "Ответ на вопрос 13 +", 1);
insert into answer (fid_question, answer, correct) values (13, "Ответ на вопрос 13 -", 0);

insert into answer (fid_question, answer, correct) values (14, "Ответ на вопрос 14 +", 1);
insert into answer (fid_question, answer, correct) values (14, "Ответ на вопрос 14 -", 0);
insert into answer (fid_question, answer, correct) values (14, "Ответ на вопрос 14 -", 0);
insert into answer (fid_question, answer, correct) values (14, "Ответ на вопрос 14 -", 0);

insert into answer (fid_question, answer, correct) values (15, "Ответ на вопрос 15 -", 0);
insert into answer (fid_question, answer, correct) values (15, "Ответ на вопрос 15 +", 0);
insert into answer (fid_question, answer, correct) values (15, "Ответ на вопрос 15 -", 0);
insert into answer (fid_question, answer, correct) values (15, "Ответ на вопрос 15 -", 0);
insert into answer (fid_question, answer, correct) values (15, "Ответ на вопрос 15 -", 0);


insert into participant (name, email, fid_quiz, quiz_time_start, quiz_time_end)
values ("fistParitcipant", "sw@l.r", 2, "12.05.19", "12.05.19");