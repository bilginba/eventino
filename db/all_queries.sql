CREATE DATABASE IF NOT EXISTS event_management; 
USE event_management;

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS administrator;
DROP TABLE IF EXISTS advertiser;
DROP TABLE IF EXISTS corporation;
DROP TABLE IF EXISTS community;
DROP TABLE IF EXISTS Participant;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS non_student;
DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS feedback;
DROP TABLE IF EXISTS send_message;
DROP TABLE IF EXISTS receive_message;
DROP TABLE IF EXISTS give_feedback;
DROP TABLE IF EXISTS check_feedback;
DROP TABLE IF EXISTS account_transaction;
DROP TABLE IF EXISTS system_account_transaction;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS certificate;
DROP TABLE IF EXISTS get_certificate;
DROP TABLE IF EXISTS charity_account_transaction;
DROP TABLE IF EXISTS request_financial_aid;
SET foreign_key_checks = 1;

CREATE TABLE User(
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(70) UNIQUE NOT NULL,
pass VARCHAR(255) NOT NULL,
email VARCHAR(70) UNIQUE NOT NULL,
phone_number VARCHAR(20) UNIQUE,
address VARCHAR(255),
user_type ENUM('Participant','Advertiser','Administrator') NOT NULL
);

CREATE TABLE administrator(
administrator_id INT NOT NULL,
administrator_name VARCHAR(70),
administrator_surname VARCHAR(70),
profile_picture VARCHAR(70),
PRIMARY KEY (administrator_id),
CONSTRAINT FK_administrator_user FOREIGN KEY (administrator_id) REFERENCES user(id)
);

CREATE TABLE advertiser(
advertiser_id INT NOT NULL,
advertiser_name VARCHAR(70),
logo VARCHAR(70),
advertiser_description VARCHAR(70),
advertiser_type ENUM('Community','Corporation'),
PRIMARY KEY (advertiser_id),
CONSTRAINT FK_advertiser_user FOREIGN KEY (advertiser_id) REFERENCES user(id)
);

CREATE TABLE corporation(
corporation_id INT NOT NULL,
sector VARCHAR(255),
PRIMARY KEY (corporation_id),
CONSTRAINT FK_corporation_advertiser_user FOREIGN KEY (corporation_id) REFERENCES advertiser(advertiser_id)
);

CREATE TABLE community(
community_id INT NOT NULL,
corporation_id INT,
community_type VARCHAR(255),
PRIMARY KEY (community_id),
CONSTRAINT FK_community_advertiser_user FOREIGN KEY (community_id) REFERENCES advertiser(advertiser_id),
CONSTRAINT FK_community_corporation_user FOREIGN KEY (corporation_id) REFERENCES corporation(corporation_id)
);

CREATE TABLE Participant(
participant_id INT NOT NULL,
profile_picture VARCHAR(255), 
nationality VARCHAR(70),
birthdate DATE DEFAULT NULL,
surname VARCHAR(70),
participant_name VARCHAR(70),
gender VARCHAR(10),
job_title VARCHAR(70),
foreign_languages VARCHAR(255),
certificates VARCHAR(255),
corporation_id INT,
participant_type ENUM('Student','Non-Student') NOT NULL,
PRIMARY KEY (participant_id),
CONSTRAINT FK_participant_user FOREIGN KEY (participant_id) REFERENCES user(id),
CONSTRAINT FK_Participant_corporation FOREIGN KEY (corporation_id) REFERENCES corporation(corporation_id)
);

CREATE TABLE student(
student_id INT NOT NULL,
student_certificate VARCHAR(255),
university_name VARCHAR(100),
PRIMARY KEY (student_id),
CONSTRAINT FK_student_participant FOREIGN KEY (student_id) REFERENCES participant(participant_id)
);

CREATE TABLE non_student(
non_student_id INT NOT NULL,
PRIMARY KEY (non_student_id),
CONSTRAINT FK_non_student_participant FOREIGN KEY (non_student_id) REFERENCES participant(participant_id)
);

CREATE TABLE message(
message_id INT NOT NULL AUTO_INCREMENT,
message_title VARCHAR(70),
message_date DATE NOT NULL,
message_desc TEXT(2000),
PRIMARY KEY (message_id)
);

CREATE TABLE feedback(
feedback_id INT NOT NULL AUTO_INCREMENT,
feedback_title VARCHAR(70),
feedback_date DATE NOT NULL,
feedback_desc TEXT(2000),
PRIMARY KEY (feedback_id)
);

CREATE TABLE send_message(
message_id INT NOT NULL,
user_id INT NOT NULL,
PRIMARY KEY (message_id, user_id),
CONSTRAINT FK_send_message FOREIGN KEY (message_id) REFERENCES message(message_id),
CONSTRAINT FK_user_send FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE receive_message(
message_id INT NOT NULL,
user_id INT NOT NULL,
PRIMARY KEY (message_id, user_id),
CONSTRAINT FK_receive_message FOREIGN KEY (message_id) REFERENCES message(message_id),
CONSTRAINT FK_user_receive FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE give_feedback(
user_id INT NOT NULL,
feedback_id INT NOT NULL,
PRIMARY KEY (user_id, feedback_id),
CONSTRAINT FK_give_feedback FOREIGN KEY (feedback_id) REFERENCES feedback(feedback_id),
CONSTRAINT FK_user_feedback FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE check_feedback(
administrator_id INT NOT NULL,
feedback_id INT NOT NULL,
PRIMARY KEY (administrator_id, feedback_id),
CONSTRAINT FK_check_feedback FOREIGN KEY (feedback_id) REFERENCES feedback(feedback_id),
CONSTRAINT FK_administrator_feedback FOREIGN KEY (administrator_id) REFERENCES administrator(administrator_id)
);

CREATE TABLE account_transaction(
account_transaction_id INT NOT NULL AUTO_INCREMENT,
ticket_id INT,
user_id INT,
amount DECIMAL(15,2) NOT NULL,
account_transaction_date DATETIME NOT NULL,
transaction_type ENUM('create-event','ticket-income','ticket-expense','load','withdraw') NOT NULL,
PRIMARY KEY (account_transaction_id),
CONSTRAINT FK_account_transaction_user FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE system_account_transaction(
system_account_transaction_id INT NOT NULL AUTO_INCREMENT,
account_transaction_id INT NOT NULL,
amount DECIMAL(15,2) NOT NULL,
system_account_transaction_date DATETIME NOT NULL,
transaction_desc ENUM('event-income','wage') NOT NULL,
PRIMARY KEY (system_account_transaction_id),
CONSTRAINT FK_account_transaction_system_account_transaction FOREIGN KEY (account_transaction_id) REFERENCES account_transaction(account_transaction_id)
);

CREATE TABLE event(
event_id INT NOT NULL AUTO_INCREMENT,
advertiser_id INT,
system_account_transaction_id INT,
account_transaction_id INT,
event_address VARCHAR(255),
event_title VARCHAR(70),
event_desc VARCHAR(255),
event_expire_date DATE,
event_publish_date DATE,
event_time DATE,
event_type VARCHAR(70),
event_photo VARCHAR(255),
PRIMARY KEY (event_id),
CONSTRAINT FK_advertiser_event FOREIGN KEY (advertiser_id) REFERENCES advertiser(advertiser_id),
CONSTRAINT FK_system_account_transaction_event FOREIGN KEY (system_account_transaction_id) REFERENCES system_account_transaction(system_account_transaction_id),
CONSTRAINT FK_account_transaction_event FOREIGN KEY (account_transaction_id) REFERENCES account_transaction(account_transaction_id)
);

CREATE TABLE ticket(
ticket_id INT NOT NULL AUTO_INCREMENT,
price DECIMAL(15,2) NOT NULL,
ticket_type ENUM('Student','Non-Student') NOT NULL,
acquisition_date DATETIME,
event_id INT NOT NULL,
participant_id INT,
PRIMARY KEY(ticket_id),
CONSTRAINT FK_event_ticket FOREIGN KEY (event_id) REFERENCES event(event_id),
CONSTRAINT FK_participant_ticket FOREIGN KEY (participant_id) REFERENCES participant(participant_id)
);


ALTER TABLE account_transaction
ADD CONSTRAINT FK_account_transacton_ticket 
FOREIGN KEY (ticket_id) REFERENCES ticket(ticket_id);

CREATE TABLE certificate(
certificate_id INT NOT NULL AUTO_INCREMENT,
certificate_title VARCHAR(70),
certificate_date DATE,
certificate_description TEXT(1000),
event_id INT NOT NULL,
PRIMARY KEY(certificate_id),
CONSTRAINT FK_event_certificate FOREIGN KEY (event_id) REFERENCES event(event_id)
);

CREATE TABLE get_certificate(
participant_id INT NOT NULL,
certificate_id INT NOT NULL,
PRIMARY KEY (certificate_id, participant_id),
CONSTRAINT FK_certificate_get_certificate FOREIGN KEY (certificate_id) REFERENCES certificate(certificate_id),
CONSTRAINT FK_participant_get_certificate FOREIGN KEY (participant_id) REFERENCES participant(participant_id)
);

CREATE TABLE charity_account_transaction(
charity_account_transaction_id INT NOT NULL AUTO_INCREMENT,
ticket_id INT,
amount DECIMAL(15,2) NOT NULL,
charity_account_transaction_date DATETIME NOT NULL,
PRIMARY KEY (charity_account_transaction_id),
CONSTRAINT FK_charity_account_transaction_ticket FOREIGN KEY (ticket_id) REFERENCES ticket(ticket_id)
);

CREATE TABLE request_financial_aid(
ticket_id INT NOT NULL,
student_id INT NOT NULL,
charity_account_transaction_id INT,
administrator_id INT,
is_accepted BOOLEAN,
PRIMARY KEY (ticket_id,student_id),
CONSTRAINT FK_request_financial_aid_ticket FOREIGN KEY (ticket_id) REFERENCES ticket(ticket_id),
CONSTRAINT FK_request_financial_aid_student FOREIGN KEY (student_id) REFERENCES student(student_id),
CONSTRAINT FK_request_financial_aid_charity_account_transaction FOREIGN KEY (charity_account_transaction_id) REFERENCES charity_account_transaction(charity_account_transaction_id),
CONSTRAINT FK_request_financial_aid_administrator FOREIGN KEY (administrator_id) REFERENCES administrator(administrator_id)
);

DELIMITER $$
DROP TRIGGER IF EXISTS after_create_user$$
CREATE TRIGGER after_create_user
    AFTER INSERT ON event_management.user
    FOR EACH ROW BEGIN
		IF(NEW.user_type = 'participant') THEN 
			INSERT INTO participant(participant_id,participant_type) VALUES(NEW.id,'Non-Student');
            INSERT INTO non_student(non_student_id) VALUES(NEW.id);
        ELSEIF(NEW.user_type = 'advertiser') THEN
			INSERT INTO advertiser(advertiser_id) VALUES(NEW.id);
		END IF;
	END$$
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS select_advertiser_type$$
CREATE TRIGGER select_advertiser_type 
    BEFORE UPDATE ON advertiser
    FOR EACH ROW 
BEGIN
	IF(NEW.advertiser_type <> OLD.advertiser_type OR (OLD.advertiser_type IS NULL AND NEW.advertiser_type IS NOT NULL)) THEN
		IF(NEW.advertiser_type = 'community') THEN 
				DELETE FROM corporation
				WHERE corporation.corporation_id = NEW.advertiser_id;
				INSERT INTO community(community_id) VALUES(NEW.advertiser_id);
		ELSEIF(NEW.advertiser_type = 'corporation') THEN
				DELETE FROM community
				WHERE community.community_id = NEW.advertiser_id;
				INSERT INTO corporation(corporation_id) VALUES(NEW.advertiser_id);
		END IF;
	END IF;
END$$
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS select_participant_type$$
CREATE TRIGGER select_participant_type 
    BEFORE UPDATE ON participant
    FOR EACH ROW 
BEGIN
	IF(NEW.participant_type <> OLD.participant_type OR (OLD.participant_type IS NULL AND NEW.participant_type IS NOT NULL)) THEN
		IF(NEW.participant_type = 'student') THEN 
				DELETE FROM non_student
				WHERE non_student.non_student_id = NEW.participant_id;
				INSERT INTO student(student_id) VALUES(NEW.participant_id);
		ELSEIF(NEW.participant_type = 'non-student') THEN
				DELETE FROM student
				WHERE student.student_id = NEW.participant_id;
				INSERT INTO non_student(non_student_id) VALUES(NEW.participant_id);
		END IF;
	END IF;
END$$
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS buy_ticket$$
CREATE TRIGGER buy_ticket
    BEFORE UPDATE ON event_management.ticket
    FOR EACH ROW BEGIN
    DECLARE advertiserid INT;
    DECLARE user_balance INT;
    SET SQL_SAFE_UPDATES=0;
		SELECT SUM(account_transaction.amount)
		INTO user_balance
		FROM account_transaction
		WHERE NEW.participant_id = account_transaction.user_id;
    
		IF(OLD.price <= user_balance) THEN
			INSERT INTO account_transaction VALUES(null,OLD.ticket_id,NEW.participant_id,OLD.price*-1,NOW(),'ticket-expense');
			INSERT INTO account_transaction VALUES(null,OLD.ticket_id,null,OLD.price*(90/100),NOW(),'ticket-income');
			
			UPDATE account_transaction a
			INNER JOIN ticket t ON a.ticket_id = t.ticket_id
			INNER JOIN event e ON t.event_id = e.event_id
			SET a.user_id = e.advertiser_id
			WHERE a.transaction_type = 'ticket-income' and a.ticket_id = t.ticket_id and t.event_id = e.event_id;
		ELSE

			SET NEW.participant_id = null,
			NEW.acquisition_date = null;
        END IF;
    SET SQL_SAFE_UPDATES=1;
	END$$
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS arrange_certificate$$
CREATE TRIGGER arrange_certificate
    AFTER UPDATE ON event_management.event
    FOR EACH ROW BEGIN
    DECLARE sold_ticket_number INT;
    DECLARE ticket_number INT;
		IF(NEW.event_time IS NOT NULL) THEN
			IF(OLD.event_time IS NOT NULL) THEN
				IF(OLD.event_time <> NEW.event_time) THEN
					UPDATE certificate
					SET certificate.certificate_date = NEW.event_time
					WHERE certificate.event_id = NEW.event_id;
                END IF;
			ELSE
				INSERT INTO certificate VALUES(null,null,NEW.event_time,null,NEW.event_id);
			END IF;
        END IF;
	END$$
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS financial_aid_respond$$
CREATE TRIGGER financial_aid_respond
    BEFORE UPDATE ON request_financial_aid
    FOR EACH ROW 
BEGIN
	DECLARE ticket_price INT;
    DECLARE charity_id INT;
    DECLARE charity_balance INT;
	DECLARE supported_event_id INT;
    IF(NEW.is_accepted is true) THEN 
    
		SELECT SUM(charity_account_transaction.amount)
        INTO charity_balance
		FROM charity_account_transaction;
        
		SELECT ticket.price
		INTO ticket_price
		FROM ticket
		WHERE ticket.ticket_id = OLD.ticket_id;
		
		IF(ticket_price <= charity_balance) THEN
			
			INSERT INTO charity_account_transaction VALUES(null,OLD.ticket_id,ticket_price*-1,now());
			
			SELECT charity_account_transaction.charity_account_transaction_id
			INTO charity_id
			FROM charity_account_transaction
			WHERE NEW.ticket_id = charity_account_transaction.ticket_id;
			
			SET NEW.charity_account_transaction_id = charity_id;
			
			SELECT event.event_id
			INTO supported_event_id
			FROM event,ticket
			WHERE ticket.ticket_id = NEW.ticket_id and ticket.event_id = event.event_id and ticket.participant_id IS NULL;
            
			UPDATE ticket
			SET participant_id = NEW.student_id,
			acquisition_date = NOW()
			WHERE event_id = supported_event_id and participant_id IS NULL
			ORDER BY event_id LIMIT 1;
		ELSE
			SET NEW.administrator_id = null,
				NEW.is_accepted = null;
		END IF;
	END IF;
END$$
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS advertiser_expenses$$
CREATE TRIGGER advertiser_expenses
    AFTER INSERT ON event_management.account_transaction
    FOR EACH ROW BEGIN
    DECLARE user_balance INT;
        IF(NEW.transaction_type = 'ticket-expense') THEN
            INSERT INTO charity_account_transaction VALUES(null,NEW.ticket_id,New.amount*-(10/100),now());
		ELSEIF(NEW.transaction_type = 'create-event') THEN

            SELECT SUM(account_transaction.amount)
            INTO user_balance
            FROM account_transaction
            WHERE NEW.user_id = account_transaction.user_id;

            IF(user_balance >= NEW.amount*-1) THEN
			    INSERT INTO system_account_transaction VALUES(null,NEW.account_transaction_id,NEW.amount*-1,NOW(),'event-income');
            ELSE
                DELETE FROM account_transaction
                WHERE account_transaction_id = NEW.account_transaction_id;
            END IF;
        END IF;
	END$$
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS create_event$$
CREATE TRIGGER create_event
    AFTER INSERT ON event_management.system_account_transaction
    FOR EACH ROW BEGIN
    DECLARE event_creator_id INT;
        IF(NEW.transaction_desc = 'event-income') THEN
            SET SQL_SAFE_UPDATES=0;
			INSERT INTO event VALUES(null,null,NEW.system_account_transaction_id,NEW.account_transaction_id,null,null,null,null,null,null,null,null);
   
            UPDATE event e
			INNER JOIN account_transaction a ON e.account_transaction_id = a.account_transaction_id
			SET e.advertiser_id = a.user_id
			WHERE e.account_transaction_id = a.account_transaction_id;
            SET SQL_SAFE_UPDATES=1;
        END IF;
	END$$
DELIMITER ;
