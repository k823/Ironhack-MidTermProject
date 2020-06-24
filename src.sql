CREATE SCHEMA mid_term_project;
USE mid_term_project;

INSERT INTO admin (id, name, password, role) VALUES (1, 'jorge', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ADMIN');

SELECT * FROM admin;

INSERT INTO account_holder (id, name, password, role, birth_date, city, country, postal_code, street) VALUES (2, 'javier', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACCOUNT_HOLDER', '1990-10-12', 'springfield', 'usa', 123, 'fake');

SELECT * FROM account_holder;

INSERT INTO third_party (id, name, password, role, hashed_key) VALUES (3, 'BBVA', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'THIRD_PARTY', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC');
SELECT * FROM third_party;

INSERT INTO credit_card_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, credit_limit, interest_rate) VALUES 
('1', 'CREDIT_CARD_ACCOUNT', '900.00', 'USD', '2020-06-24', '40.00', 'bananas', 'ACTIVE', '2020-06-24', '3', '100.00', '0.20');

INSERT INTO credit_card_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, credit_limit, interest_rate) VALUES 
('2', 'CREDIT_CARD_ACCOUNT', '400.00', 'USD', '2020-06-24', '40.00', 'bananas', 'ACTIVE', '2020-06-24', '4', '100.00', '0.20');

SELECT * FROM credit_card_account;