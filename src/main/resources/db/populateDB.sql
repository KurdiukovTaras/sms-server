DELETE FROM sms;
DELETE FROM client;
ALTER SEQUENCE global_seq_for_sms RESTART WITH 100000;

INSERT INTO client (name, descripment, phonenumber)
VALUES ('User', 'user@yandex.ru', '+3234234234');
VALUES ('User1', 'user@yandex.ru', '+323423423234');
VALUES ('User2', 'user@yandex.ru', '+323234234234');
VALUES ('User3', 'user@yandex.ru', '+323434234234');
VALUES ('User4', 'user@yandex.ru', '+323423544234');



INSERT INTO sms (date_time, message, readed, client_id) VALUES
  ('2015-05-30 10:00:00', 'Завтрак', true, 100001),
  ('2015-05-30 13:00:00', 'Обед', true, 100002),
  ('2015-05-30 20:00:00', 'Ужин', true, 100003),
  ('2015-05-31 10:00:00', 'Завтрак', true, 100004),
  ('2015-05-31 13:00:00', 'Обед', true, 100001),
  ('2015-05-31 20:00:00', 'Ужин', true, 100002),
  ('2015-06-01 14:00:00', 'Админ ланч', true, 100003),
  ('2015-06-01 21:00:00', 'Админ ужин', true, 100004);
