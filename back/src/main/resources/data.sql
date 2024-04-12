INSERT INTO roles(name)
SELECT 'ADMIN' WHERE NOT EXISTS (SELECT 1 FROM roles WHERE name = 'ADMIN');
INSERT INTO roles(name)
SELECT 'MANAGER' WHERE NOT EXISTS (SELECT 1 FROM roles WHERE name = 'MANAGER');
INSERT INTO roles(name)
SELECT 'ACCOUNTING' WHERE NOT EXISTS (SELECT 1 FROM roles WHERE name = 'ACCOUNTING');
INSERT INTO roles(name)
SELECT 'SQUAD' WHERE NOT EXISTS (SELECT 1 FROM roles WHERE name = 'SQUAD');
INSERT INTO roles(name)
SELECT 'USER' WHERE NOT EXISTS (SELECT 1 FROM roles WHERE name = 'USER');


INSERT INTO squads(name)
SELECT 'DEVELOPMENT' WHERE NOT EXISTS (SELECT 1 FROM squads WHERE name = 'DEVELOPMENT');
INSERT INTO squads(name)
SELECT 'HR' WHERE NOT EXISTS (SELECT 1 FROM squads WHERE name = 'HR');
INSERT INTO squads(name)
SELECT 'SMM' WHERE NOT EXISTS (SELECT 1 FROM squads WHERE name = 'SMM');


INSERT INTO status_codes(code, name)
SELECT '1', 'Bid created' WHERE NOT EXISTS (SELECT 1 FROM status_codes WHERE code = '1');
INSERT INTO status_codes(code, name)
SELECT '2', 'Bid was firstly approved by SQUAD' WHERE NOT EXISTS (SELECT 1 FROM status_codes WHERE code = '2');
INSERT INTO status_codes(code, name)
SELECT '3', 'Bid was firstly rejected by SQUAD' WHERE NOT EXISTS (SELECT 1 FROM status_codes WHERE code = '3');
INSERT INTO status_codes(code, name)
SELECT '4', 'Bid was firstly approved by MANAGER' WHERE NOT EXISTS (SELECT 1 FROM status_codes WHERE code = '4');
INSERT INTO status_codes(code, name)
SELECT '5', 'Bid firstly was approved by ACCOUNTING' WHERE NOT EXISTS (SELECT 1 FROM status_codes WHERE code = '5');
INSERT INTO status_codes(code, name)
SELECT '6', 'Bid firstly was rejected by ACCOUNTING' WHERE NOT EXISTS (SELECT 1 FROM status_codes WHERE code = '6');
INSERT INTO status_codes(code, name)
SELECT '7', 'Bid was secondly approved by SQUAD' WHERE NOT EXISTS (SELECT 1 FROM status_codes WHERE code = '7');
INSERT INTO status_codes(code, name)
SELECT '8', 'Bid was secondly rejected by SQUAD' WHERE NOT EXISTS (SELECT 1 FROM status_codes WHERE code = '8');
INSERT INTO status_codes(code, name)
SELECT '9', 'Bid was secondly approved by MANAGER' WHERE NOT EXISTS (SELECT 1 FROM status_codes WHERE code = '9');
INSERT INTO status_codes(code, name)
SELECT '10', 'Trip active' WHERE NOT EXISTS (SELECT 1 FROM status_codes WHERE code = '10');
INSERT INTO status_codes(code, name)
SELECT '11', 'Trip ended' WHERE NOT EXISTS (SELECT 1 FROM status_codes WHERE code = '11');
INSERT INTO status_codes(code, name)
SELECT '12', 'ACCOUNTING create report' WHERE NOT EXISTS (SELECT 1 FROM status_codes WHERE code = '12');


INSERT INTO users(email, grade, password, user_role)
SELECT 'admin@admin', 3, '$2a$12$8AiPlUiGLsSTCOynrwbDL.2cA6SfI537qEf8vf6rTWdzVhdS.ACI2', 1
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'admin@admin');