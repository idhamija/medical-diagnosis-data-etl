-- Drop Schema
-- DROP SCHEMA IF EXISTS targetdb;

-- Create Schema
-- CREATE SCHEMA targetdb;

-- Use Schema
-- USE targetdb;

-- Drop Fact tables.
 DROP TABLE IF EXISTS fact_test_report;

-- Drop Dimension tables.
 DROP TABLE IF EXISTS dim_prescription;
 DROP TABLE IF EXISTS dim_date;
 DROP TABLE IF EXISTS dim_doctor;
 DROP TABLE IF EXISTS dim_lab;
 DROP TABLE IF EXISTS dim_patient;
 DROP TABLE IF EXISTS dim_test_type;
 DROP TABLE IF EXISTS dim_time;

-- Create the Dimension tables.
CREATE TABLE dim_date (
    date_id DATE PRIMARY KEY NOT NULL,
    day  	SMALLINT,
    month   SMALLINT,
    year    SMALLINT
);

CREATE TABLE dim_time (
    time_id SMALLINT PRIMARY KEY NOT NULL,
    hour   	SMALLINT,
    minute 	SMALLINT
);

CREATE TABLE dim_doctor (
    doctor_id     INTEGER PRIMARY KEY NOT NULL,
    doctor_name   VARCHAR(50),
    department	  VARCHAR(50),
    hospital_name VARCHAR(50),
    state      	  VARCHAR(50),
    city       	  VARCHAR(50),
    district   	  VARCHAR(50),
    pincode		  INTEGER
);

CREATE TABLE dim_lab (
    lab_id   INTEGER PRIMARY KEY NOT NULL,
    lab_name VARCHAR(50),
    state    VARCHAR(50),
    city     VARCHAR(50),
    district VARCHAR(50),
    pincode  INTEGER
);

CREATE TABLE dim_patient (
    patient_id INTEGER PRIMARY KEY NOT NULL,
    gender     VARCHAR(50),
    height     DOUBLE,
    weight     DOUBLE,
    state      VARCHAR(50),
    city       VARCHAR(50),
    district   VARCHAR(50)
);

CREATE TABLE dim_prescription (
    prescription_id INTEGER PRIMARY KEY NOT NULL,
    doctor_id    	INTEGER,
    date_id      	DATE,
    diagnosis    	VARCHAR(50),
    treatment		VARCHAR(50)
);

CREATE TABLE dim_test_type (
    test_type_id INTEGER PRIMARY KEY NOT NULL,
    test_name    VARCHAR(50),
    min_value    DOUBLE,
    max_value    DOUBLE,
    unit		 VARCHAR(50)
);

-- Create the Fact tables
CREATE TABLE fact_test_report (
    test_report_id  INTEGER PRIMARY KEY NOT NULL,
    patient_id      INTEGER,
    doctor_id       INTEGER,
    prescription_id INTEGER,
    lab_id          INTEGER,
    test_type_id    INTEGER,
    date_id         DATE,
    time_id         SMALLINT,
    patient_age     SMALLINT,
    test_value      DOUBLE,
    severity     	VARCHAR(50),
    -- test_image      BLOB,
    test_timestamp  TIMESTAMP
);


ALTER TABLE dim_prescription ADD CONSTRAINT dim_prescription_fk0 FOREIGN KEY (doctor_id) REFERENCES dim_doctor(doctor_id);
ALTER TABLE dim_prescription ADD CONSTRAINT dim_prescription_fk1 FOREIGN KEY (date_id) REFERENCES dim_date(date_id);

ALTER TABLE fact_test_report ADD CONSTRAINT fact_test_report_fk0 FOREIGN KEY  (test_type_id) REFERENCES dim_test_type(test_type_id);
ALTER TABLE fact_test_report ADD CONSTRAINT fact_test_report_fk1 FOREIGN KEY  (patient_id) REFERENCES dim_patient(patient_id);
ALTER TABLE fact_test_report ADD CONSTRAINT fact_test_report_fk2 FOREIGN KEY  (doctor_id) REFERENCES dim_doctor(doctor_id);
ALTER TABLE fact_test_report ADD CONSTRAINT fact_test_report_fk3 FOREIGN KEY  (prescription_id) REFERENCES dim_prescription(prescription_id);
ALTER TABLE fact_test_report ADD CONSTRAINT fact_test_report_fk4 FOREIGN KEY  (lab_id) REFERENCES dim_lab(lab_id);
ALTER TABLE fact_test_report ADD CONSTRAINT fact_test_report_fk5 FOREIGN KEY  (date_id) REFERENCES dim_date(date_id);
ALTER TABLE fact_test_report ADD CONSTRAINT fact_test_report_fk6 FOREIGN KEY  (time_id) REFERENCES dim_time(time_id);
