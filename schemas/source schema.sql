-- Drop Schema
DROP SCHEMA IF EXISTS sourcedb;

-- Create Schema
CREATE SCHEMA sourcedb;

-- Use Schema
USE sourcedb;

-- Drop Tables
-- DROP TABLE IF EXISTS address;
-- DROP TABLE IF EXISTS doctor;
-- DROP TABLE IF EXISTS hospital;
-- DROP TABLE IF EXISTS lab;
-- DROP TABLE IF EXISTS patient;
-- DROP TABLE IF EXISTS prescription;
-- DROP TABLE IF EXISTS test_report;
-- DROP TABLE IF EXISTS test_type;
-- DROP TABLE IF EXISTS visit;

-- Create Tables
CREATE TABLE address (
    pincode  INTEGER PRIMARY KEY NOT NULL,
    state    VARCHAR(50),
    city 	 VARCHAR(50),
    district VARCHAR(50)
);

CREATE TABLE doctor (
    doctor_id   INTEGER PRIMARY KEY NOT NULL,
    doctor_name VARCHAR(50),
    department	VARCHAR(50),
    hospital_id INTEGER
);

CREATE TABLE hospital (
    hospital_id   	 INTEGER PRIMARY KEY NOT NULL,
    hospital_name 	 VARCHAR(50),
    hospital_pincode INTEGER
);

CREATE TABLE lab (
    lab_id     	INTEGER PRIMARY KEY NOT NULL,
    lab_name   	VARCHAR(50),
    lab_pincode INTEGER
);

CREATE TABLE patient (
    patient_id 		INTEGER PRIMARY KEY NOT NULL,
    patient_name	VARCHAR(50),
    dob		   		DATE,
    gender		    VARCHAR(50),
    height    		DOUBLE,
    weight  		DOUBLE,
    patient_pincode INTEGER
);

CREATE TABLE prescription (
    prescription_id   INTEGER PRIMARY KEY NOT NULL,
    doctor_id    	  INTEGER,
    diagnosis    	  VARCHAR(50),
    treatment		  VARCHAR(50),
    prescription_date DATE DEFAULT (CURRENT_DATE)
);

CREATE TABLE test_report (
    test_report_id  INTEGER PRIMARY KEY NOT NULL,
    test_type_id    INTEGER,
    visit_id        INTEGER,
    prescription_id INTEGER DEFAULT 0,
    test_value      DOUBLE,
    test_image      BLOB
);

CREATE TABLE test_type (
    test_type_id INTEGER PRIMARY KEY NOT NULL,
    test_name    VARCHAR(50),
    min_value    DOUBLE,
    max_value    DOUBLE,
    unit		 VARCHAR(50)
);

CREATE TABLE visit (
    visit_id		INTEGER PRIMARY KEY NOT NULL,
    patient_id      INTEGER,
    doctor_id       INTEGER,
    lab_id          INTEGER,
    visit_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE doctor ADD CONSTRAINT doctor_fk0 FOREIGN KEY (hospital_id) REFERENCES hospital(hospital_id);

ALTER TABLE hospital ADD CONSTRAINT hospital_fk0 FOREIGN KEY (hospital_pincode) REFERENCES address(pincode);

ALTER TABLE lab ADD CONSTRAINT lab_fk0 FOREIGN KEY (lab_pincode) REFERENCES address(pincode);

ALTER TABLE patient ADD CONSTRAINT patient_fk0 FOREIGN KEY (patient_pincode) REFERENCES address(pincode);

ALTER TABLE prescription ADD CONSTRAINT prescription_fk0 FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id);

ALTER TABLE test_report ADD CONSTRAINT test_report_fk0 FOREIGN KEY (visit_id) REFERENCES visit(visit_id);
ALTER TABLE test_report ADD CONSTRAINT test_report_fk1 FOREIGN KEY (prescription_id) REFERENCES prescription(prescription_id);
ALTER TABLE test_report ADD CONSTRAINT test_report_fk2 FOREIGN KEY (test_type_id) REFERENCES test_type(test_type_id);

ALTER TABLE visit ADD CONSTRAINT visit_fk0 FOREIGN KEY (patient_id) REFERENCES patient(patient_id);
ALTER TABLE visit ADD CONSTRAINT visit_fk1 FOREIGN KEY (lab_id) REFERENCES lab(lab_id);
ALTER TABLE visit ADD CONSTRAINT visit_fk2 FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id);


INSERT INTO address (pincode, state, city, district) VALUES ('0', '', '', '');
INSERT INTO hospital (hospital_id, hospital_name, hospital_pincode) VALUES ('0', '', '0');
INSERT INTO doctor (doctor_id, doctor_name, department, hospital_id) VALUES ('0', '', '', '0');
INSERT INTO prescription (prescription_id, doctor_id, diagnosis, treatment, prescription_date) VALUES ('0', '0', '', '', '3000-01-01');
