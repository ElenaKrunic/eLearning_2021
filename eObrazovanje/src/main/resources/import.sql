use eobrazovanje;

INSERT INTO authority (id, name) VALUES (1, 'ADMIN');
INSERT INTO authority (id, name) VALUES (2, 'PROFESOR');
INSERT INTO authority (id, name) VALUES (3, 'STUDENT');

INSERT INTO user (id, password,username) VALUES (1, 'nekalozinka','admin');
INSERT INTO user (id, password,username) VALUES (2, 'nekalozinka','profesor');
INSERT INTO user (id, password,username) VALUES (3, 'nekalozinka','student');

INSERT INTO user_authority (id, authority,user) VALUES (1, 1,1);
INSERT INTO user_authority (id, authority,user) VALUES (2, 2,2);
INSERT INTO user_authority (id, authority,user) VALUES (3, 3,3);


INSERT INTO admin (id, user) VALUES (1, 1);

INSERT INTO professor (id, first_name,last_name,user) VALUES (1, 'Sima','Popovic',2);



INSERT INTO type_of_financing (id, code,name) VALUES (1, 'SF','self financing');
INSERT INTO type_of_financing (id, code,name) VALUES (2, 'BU','budget');

INSERT INTO student (id, account_number,card_amount,card_number,email,first_name,last_name,model_number,phone_number,reference_number,started_college_in,umnc,type_of_financing,user) VALUES
 (1, '1236548-896-6',800.00,'125-698-365','pera@gmail.com','Pera','Simic',97,'065-489-986','1254-78-965-65',2015,'145879652345',1,3);

INSERT INTO financial_card (id, initial_state,total_cost,total_payment,total_payout,student) VALUES (1, 800.00,1000.00,2000.00,5000.00,1);

INSERT INTO pay_out (id, date_of_pay_out,description_pay_out,pay_out_amount,financial_card) VALUES (1, '2015-11-05 14:29:36','Prijava ispita',500.00,1);
INSERT INTO pay_out (id, date_of_pay_out,description_pay_out,pay_out_amount,financial_card) VALUES (2, '2013-11-05 14:29:36','Overa semestra',2000.00,1);

INSERT INTO payment (id, date_of_payment,payment_amount,payment_description,financial_card) VALUES (1, '2012-11-05 14:29:36','Osnove web programiranja',200.00,1);
INSERT INTO payment (id, date_of_payment,payment_amount,payment_description,financial_card) VALUES (2, '2013-11-05 14:29:36','Overa semestra',2000.00,1);


INSERT INTO document_type (id, code,name) VALUES (1, 'FO','form');
INSERT INTO document_type (id, code,name) VALUES (2, 'CR','certificate');

INSERT INTO document (id, title,url,document_type,student) VALUES (1, 'Student certificate','path/to/certificate',2,1);
INSERT INTO document (id, title,url,document_type,student) VALUES (2, 'The appearance of the payment slip','path/to/form',1,1);

INSERT INTO courses (course_id, ects,course_code,course_end_date,course_start_date,course_title) VALUES (1, 8,'OWP','2015-11-05','2013-11-05','Osnove web programiranje');
INSERT INTO courses (course_id, ects,course_code,course_end_date,course_start_date,course_title) VALUES (2, 6,'OSA','2015-11-05','2013-11-05','Osnove softverske arhitekture');

INSERT INTO teaching_type (id, code,name) VALUES (1, 'LE','lecturer');
INSERT INTO teaching_type (id, code,name) VALUES (2, 'TA','teacher assistant');
INSERT INTO teaching_type (id, code,name) VALUES (3, 'LA','laboratory assistant');

INSERT INTO teaching (id, end_date,start_date,courses,professor,teaching_type) VALUES (1, '2015-11-05','2013-11-05',1,1,1);
INSERT INTO teaching (id, end_date,start_date,courses,professor,teaching_type) VALUES (2, '2015-11-05','2013-11-05',2,1,2);

INSERT INTO enrollments (enrollment_id, enrollment_end_date,enrollment_start_date,courses,student) VALUES (1, '2015-11-05','2013-11-05',1,1);
INSERT INTO enrollments (enrollment_id, enrollment_end_date,enrollment_start_date,courses,student) VALUES (2, '2015-11-05','2013-11-05',2,1);

INSERT INTO exam_period (id, end_date,name,payment_amount,start_date) VALUES (1, '2020-02-10','january',200.0,'2020-01-10');
INSERT INTO exam_period (id, end_date,name,payment_amount,start_date) VALUES (2, '2020-02-20','february',200.0,'2020-02-11');
INSERT INTO exam_period (id, end_date,name,payment_amount,start_date) VALUES (3, '2020-04-20','april',200.0,'2020-05-04');
INSERT INTO exam_period (id, end_date,name,payment_amount,start_date) VALUES (4, '2020-10-07','june',200.0,'10-06-2020');
INSERT INTO exam_period (id, end_date,name,payment_amount,start_date) VALUES (5, '2020-20-07','july',200.0,'2020-11-07');
INSERT INTO exam_period (id, end_date,name,payment_amount,start_date) VALUES (6, '2020-20-09','september',200.0,'2020-10-09');
INSERT INTO exam_period (id, end_date,name,payment_amount,start_date) VALUES (7, '2020-20-10','october',200.0,'2020-11-10');

INSERT INTO preexam_obligation_status (id, code,name) VALUES (1, 'NA','not appeared');
INSERT INTO preexam_obligation_status (id, code,name) VALUES (2, 'FA','failed');
INSERT INTO preexam_obligation_status (id, code,name) VALUES (3, 'PA','passed');
INSERT INTO preexam_obligation_status (id, code,name) VALUES (4, 'CN','canceled');

INSERT INTO preexam_obligation_type (id, code,name) VALUES (1, 'HM','homework');
INSERT INTO preexam_obligation_type (id, code,name) VALUES (2, 'PE','preexam');
INSERT INTO preexam_obligation_type (id, code,name) VALUES (3, 'SW','seminary work');


INSERT INTO preexam_obligation (id, date_of_obligation,location,passed,points,exam,preexam_obligation_status,preexam_obligation_type,student_id) VALUES (1, '2015-01-11','NTP',true,71.00,1,1,1,1);
INSERT INTO preexam_obligation (id, date_of_obligation,location,passed,points,exam,preexam_obligation_status,preexam_obligation_type,student_id) VALUES (2, '2015-01-11','NTP',false,10.00,2,2,2,1);
INSERT INTO preexam_obligation (id, date_of_obligation,location,passed,points,exam,preexam_obligation_status,preexam_obligation_type,student_id) VALUES (3, '2015-01-11','NTP',true,71.00,2,1,2,1);


INSERT INTO exam (id, exam_date,grade,points,status,enrollments,exam_period) VALUES (1, '2015-01-11',8,71.00,true,1,1);
INSERT INTO exam (id, exam_date,grade,points,status,enrollments,exam_period) VALUES (2, '2016-01-12',8,71.00,false,2,1);
INSERT INTO exam (id, exam_date,grade,points,status,enrollments,exam_period) VALUES (3, '2016-02-11',8,71.00,true,2,1);
