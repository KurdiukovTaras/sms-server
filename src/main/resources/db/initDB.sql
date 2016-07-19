DROP TABLE IF EXISTS sms;
DROP TABLE IF EXISTS client;
DROP SEQUENCE IF EXISTS global_seq_for_sms;

CREATE SEQUENCE global_seq_for_sms START 100000;

CREATE TABLE client
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq_for_sms'),
  name       TEXT NOT NULL,
  descripment TEXT NOT NULL,
  phoneNumber TEXT NOT NULL
);
CREATE UNIQUE INDEX client_unique_id ON client (id);

CREATE TABLE sms (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq_for_sms'),
  client_id     INTEGER NOT NULL,
  date_time    TIMESTAMP NOT NULL,
  message TEXT NOT NULL,
  readed    BOOL DEFAULT TRUE,
  FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX sms_unique_client_datetime_idx ON sms(client_id, date_time)
