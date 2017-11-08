DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS orders;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE employee
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                  NOT NULL,
  department       VARCHAR                  NOT NULL
);

CREATE TABLE orders (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR    NOT NULL,
  furnitureType    VARCHAR    NOT NULL,
  endTime          TIMESTAMP  NOT NULL,
  department       VARCHAR    NOT NULL,
  employee_id      INTEGER,
  FOREIGN KEY (employee_id) REFERENCES employee (id) ON DELETE CASCADE
);