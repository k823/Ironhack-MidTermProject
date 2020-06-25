use mid_term_project;


-- PRELOAD USERS
INSERT INTO admin (id, name, password, role) VALUES (1, 'jorge', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ADMIN');
INSERT INTO admin (id, name, password, role) VALUES (2, 'johnnie', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ADMIN');

INSERT INTO account_holder (id, name, password, role, birth_date, city, country, postal_code, street) VALUES
(3, 'javier', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACCOUNT_HOLDER', '1990-10-12', 'springfield', 'usa', 123, 'fake');
INSERT INTO account_holder (id, name, password, role, birth_date, city, country, postal_code, street) VALUES
(4, 'jimmy', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACCOUNT_HOLDER', '1999-12-10', 'shelbyville', 'usa', 321, 'truth');

INSERT INTO third_party (id, name, password, role, hashed_key) VALUES (5, 'BBVA', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'THIRD_PARTY', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC');
INSERT INTO third_party (id, name, password, role, hashed_key) VALUES (6, 'Sabadell', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'THIRD_PARTY', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC');

-- PRELOAD ACCOUNTS
INSERT INTO credit_card_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, credit_limit, interest_rate) VALUES
('1', 'CREDIT_CARD_ACCOUNT', '900.00', 'USD', '2020-06-24', '40.00', 'bananas', 'ACTIVE', '2020-06-24', '3', '100.00', '0.20');

INSERT INTO credit_card_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, credit_limit, interest_rate) VALUES
('2', 'CREDIT_CARD_ACCOUNT', '400.00', 'USD', '2020-06-24', '40.00', 'bananas', 'ACTIVE', '2020-06-24', '4', '100.00', '0.20');

INSERT INTO checking_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, minimum_balance, monthly_maintenance_fee) VALUES
('3', 'CHECKING_ACCOUNT', '360.00', 'USD', '2020-06-24', '40.00', 'bananas', 'ACTIVE', '2020-06-24', '3', '250.00', '12.00');

INSERT INTO student_checking_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner) VALUES
('4', 'STUDENT_CHECKING_ACCOUNT', '360.00', 'USD', '2020-06-24', '40.00', 'bananas', 'ACTIVE', '2020-06-24', '4');

INSERT INTO savings_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, interest_rate, minimum_balance) VALUES
('5', 'SAVINGS_ACCOUNT', '400.00', 'USD', '2020-06-24', '40.00', 'bananas', 'ACTIVE', '2020-06-24', '3', '0.0025', '1000.00');

INSERT INTO savings_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, interest_rate, minimum_balance) VALUES
('6', 'SAVINGS_ACCOUNT', '400.00', 'USD', '2020-06-24', '40.00', 'bananas', 'ACTIVE', '2020-06-24', '4', '0.0025', '1000.00');