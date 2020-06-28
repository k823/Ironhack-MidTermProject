use mid_term_project;


-- PRELOAD USERS
INSERT INTO admin (id, name, password, role) VALUES (10, 'jorge', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ADMIN');
INSERT INTO admin (id, name, password, role) VALUES (11, 'johnnie', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ADMIN');

INSERT INTO account_holder (id, name, password, role, birth_date, city, country, postal_code, street) VALUES
(12, 'javier', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACCOUNT_HOLDER', '1990-10-12', 'springfield', 'usa', 123, 'fake');
INSERT INTO account_holder (id, name, password, role, birth_date, city, country, postal_code, street) VALUES
(13, 'jimmy', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACCOUNT_HOLDER', '1999-12-10', 'shelbyville', 'usa', 321, 'truth');

INSERT INTO third_party (id, name, password, role, hashed_key) VALUES
(14, 'BBVA', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'THIRD_PARTY', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC');
INSERT INTO third_party (id, name, password, role, hashed_key) VALUES
(15, 'Sabadell', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'THIRD_PARTY', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC');

-- PRELOAD ACCOUNTS
INSERT INTO credit_card_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, credit_limit, interest_rate, max_transactions24hrs) VALUES
(10, 'CREDIT_CARD_ACCOUNT', '900.00', 'USD', '2020-06-24', '40.00', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACTIVE', '2020-06-24', '12', '100.00', '0.20', 10);

INSERT INTO credit_card_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, credit_limit, interest_rate, max_transactions24hrs) VALUES
(11, 'CREDIT_CARD_ACCOUNT', '400.00', 'USD', '2020-06-24', '40.00', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACTIVE', '2020-06-24', '13', '100.00', '0.20', 10);

INSERT INTO checking_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, minimum_balance, monthly_maintenance_fee, max_transactions24hrs) VALUES
(12, 'CHECKING_ACCOUNT', '360.00', 'USD', '2020-06-24', '40.00', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACTIVE', '2020-06-24', '12', '250.00', '12.00', 10);

INSERT INTO student_checking_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, max_transactions24hrs) VALUES
(13, 'STUDENT_CHECKING_ACCOUNT', '360.00', 'USD', '2020-06-24', '40.00', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACTIVE', '2020-06-24', '13', 10);

INSERT INTO savings_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, interest_rate, minimum_balance, max_transactions24hrs) VALUES
(14, 'SAVINGS_ACCOUNT', '400.00', 'USD', '2020-06-24', '40.00', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACTIVE', '2020-06-24', '12', '0.0025', '1000.00', 10);

INSERT INTO savings_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, interest_rate, minimum_balance, max_transactions24hrs) VALUES
(15, 'SAVINGS_ACCOUNT', '400.00', 'USD', '2020-06-24', '40.00', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACTIVE', '2020-06-24', '13', '0.0025', '1000.00', 10);

INSERT INTO credit_card_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, credit_limit, interest_rate, max_transactions24hrs) VALUES
(20, 'CREDIT_CARD_ACCOUNT', '900.00', 'USD', '2020-06-24', '40.00', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACTIVE', '2020-06-24', '12', '100.00', '0.20', 10);

INSERT INTO credit_card_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, credit_limit, interest_rate, max_transactions24hrs) VALUES
(21, 'CREDIT_CARD_ACCOUNT', '400.00', 'USD', '2020-06-24', '40.00', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACTIVE', '2020-06-24', '13', '100.00', '0.20', 10);

INSERT INTO checking_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, minimum_balance, monthly_maintenance_fee, max_transactions24hrs) VALUES
(22, 'CHECKING_ACCOUNT', '360.00', 'USD', '2020-06-24', '40.00', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACTIVE', '2020-06-24', '12', '250.00', '12.00', 10);

INSERT INTO student_checking_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, max_transactions24hrs) VALUES
(23, 'STUDENT_CHECKING_ACCOUNT', '360.00', 'USD', '2020-06-24', '40.00', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACTIVE', '2020-06-24', '13', 10);

INSERT INTO savings_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, interest_rate, minimum_balance, max_transactions24hrs) VALUES
(24, 'SAVINGS_ACCOUNT', '400.00', 'USD', '2020-06-24', '40.00', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACTIVE', '2020-06-24', '12', '0.0025', '1000.00', 10);

INSERT INTO savings_account (id, account_type, amount, currency, created_at, penalty_fee, secret_key, status, updated_at, primary_owner, interest_rate, minimum_balance, max_transactions24hrs) VALUES
(25, 'SAVINGS_ACCOUNT', '400.00', 'USD', '2020-06-24', '40.00', '$2a$10$en0dAnBZn.gHxE1lZm5dS.wJ2h8ArJqF7hWN7yoMvSYAwoa2y/9LC', 'ACTIVE', '2020-06-24', '13', '0.0025', '1000.00', 10);
