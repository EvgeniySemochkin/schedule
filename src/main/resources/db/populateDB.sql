DELETE FROM employee;
DELETE FROM orders;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO employee (name, department)
VALUES ('ИвановММ_1', 'CUSHIONED_FURNITURE'),
       ('ИвановММ_2', 'CUSHIONED_FURNITURE'),
       ('ИвановММ_3', 'CUSHIONED_FURNITURE'),
       ('ПетровСХ_4', 'STORAGE'),
       ('ПетровСХ_5', 'STORAGE'),
       ('СидоровОМ_6', 'OFFICE'),
       ('СидоровОМ_7', 'OFFICE'),
       ('СидоровОМ_8', 'OFFICE');


INSERT INTO orders (name, furnituretype, endtime, department, employee_id) VALUES
  ('кровать', 'BED', '2017-12-01 10:00:00', 'CUSHIONED_FURNITURE', 100001),
  ('шкаф', 'WARDROBE', '2017-12-01 10:00:00', 'STORAGE', 100004),
  ('стол', 'TABLE', '2017-12-01 10:00:00', 'OFFICE', 100006);


INSERT INTO orders (name, furnituretype, endtime, department) VALUES
  ('диван', 'SOFA', '2017-12-01 10:00:00', 'CUSHIONED_FURNITURE'),
  ('кресло', 'ARMCHAIR', '2017-12-01 10:00:00', 'CUSHIONED_FURNITURE'),
  ('тумба', 'BEDSIDE_TABLE', '2017-12-01 10:00:00', 'STORAGE'),
  ('полка', 'SHELF', '2017-12-01 10:00:00', 'STORAGE'),
  ('стул', 'CHAIR', '2017-12-01 10:00:00', 'OFFICE'),
  ('кресло-качалка', 'ROCKING_CHAIR', '2017-12-01 10:00:00', 'OFFICE');
