use eobrazovanje;

INSERT INTO authority (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authority (id, name) VALUES (2, 'ROLE_PROFESOR');
INSERT INTO authority (id, name) VALUES (3, 'ROLE_STUDENT');
--za admina je sifra admin
INSERT INTO user (id, password,username) VALUES (1, '$2a$04$SwzgBrIJZhfnzOw7KFcdzOTiY6EFVwIpG7fkF/D1w26G1.fWsi.aK','admin');
--za profesora i studenta je user
INSERT INTO user (id, password,username) VALUES (2, '$2a$04$Amda.Gm4Q.ZbXz9wcohDHOhOBaNQAkSS1QO26Eh8Hovu3uzEpQvcq','profesor');
INSERT INTO user (id, password,username) VALUES (3, '$2a$04$Amda.Gm4Q.ZbXz9wcohDHOhOBaNQAkSS1QO26Eh8Hovu3uzEpQvcq','student');
--lozinka je Elena 
--INSERT INTO user (id, password, username) VALUES (4, '$2a$10$Nig935e8V2Zgx0zDd31RJe1bdHchJiG9wvS8VDO.UFIKt7O.WbRIS', 'Elena');

INSERT INTO user_authority (id, authority,user) VALUES (1, 1, 1);
INSERT INTO user_authority (id, authority,user) VALUES (2, 2, 2);
INSERT INTO user_authority (id, authority,user) VALUES (3, 3, 3);
--INSERT INTO user_authority (id, authority,user) VALUES (4, 1, 4);

INSERT INTO admin (id,user) VALUES (1,1);
--INSERT INTO admin (id,user) VALUES (2,4);

INSERT INTO professor (id, first_name,last_name,user) VALUES (1, 'Sima','Popovic',2);
INSERT INTO professor (id, first_name,last_name,user) VALUES (2, 'Mirko','Popovic',2);
INSERT INTO professor (id, first_name,last_name,user) VALUES (3, 'Stevan','Bagic',2);
INSERT INTO professor (id, first_name,last_name,user) VALUES (4, 'Marko','Markovic',2);
INSERT INTO professor (id, first_name,last_name,user) VALUES (5, 'Darko','Matkovic',2);
INSERT INTO professor (id, first_name,last_name,user) VALUES (6, 'Kosta','Vukov',2);

INSERT INTO type_of_financing (id, code,name) VALUES (1, 'SF','self financing');
INSERT INTO type_of_financing (id, code,name) VALUES (2, 'BU','budget');

INSERT INTO student (id, account_number,card_amount,card_number,email,first_name,last_name,model_number,phone_number,reference_number,started_college_in,umnc,type_of_financing,user) VALUES (1, '1236548-896-6',800.00,'125-698-365','pera@gmail.com','Pera','Simic',97,'065-489-986','1254-78-65',2015,'145879652345',1,3);

INSERT INTO financial_card (id, initial_state,total_cost,total_payment,total_payout,student) VALUES (1, 800.00,1000.00,5000.00,5000.00,1);

INSERT INTO pay_out (id, date_of_pay_out,description_pay_out,pay_out_amount,financial_card) VALUES (1, '2015-11-05','Prijava ispita',500.00,1);
INSERT INTO pay_out (id, date_of_pay_out,description_pay_out,pay_out_amount,financial_card) VALUES (2, '2013-11-05','Overa semestra',2000.00,1);

INSERT INTO payment (id, date_of_payment,payment_amount,payment_description,financial_card) VALUES (1, '2012-11-05',200.00,'Osnove web programiranja',1);
INSERT INTO payment (id, date_of_payment,payment_amount,payment_description,financial_card) VALUES (2, '2013-11-05',2000.00,'Overa semestra',1);

INSERT INTO pay_out (id, date_of_pay_out,description_pay_out,pay_out_amount,financial_card) VALUES (1, '2015-11-05','Prijava ispita',500.00,1);
INSERT INTO pay_out (id, date_of_pay_out,description_pay_out,pay_out_amount,financial_card) VALUES (2, '2013-11-05','Overa semestra',2000.00,1);

INSERT INTO payment (id, payment_date ,payment_amount,payment_description,financial_card) VALUES (1, '2012-11-05',200.00,'Osnove web programiranja',1);
INSERT INTO payment (id, payment_date ,payment_amount,payment_description,financial_card) VALUES (2, '2013-11-05',2000.00,'Overa semestra',1);


INSERT INTO document_type (id, code,name) VALUES (1, 'FO','form');
INSERT INTO document_type (id, code,name) VALUES (2, 'CR','certificate');

INSERT INTO document (id, title,url,document_type,student) VALUES (1, 'Student certificate','path/to/certificate',2,1);
INSERT INTO document (id, title,url,document_type,student) VALUES (2, 'The appearance of the payment slip','path/to/form',1,1);

INSERT INTO courses (course_id, ects,course_code,course_end_date,course_start_date,course_title) VALUES (1, 8,'OWP','2015-11-05','2013-11-05','Osnove web programiranje');
INSERT INTO courses (course_id, ects,course_code,course_end_date,course_start_date,course_title) VALUES (2, 6,'OSA','2015-11-05','2013-11-05','Osnove softverske arhitekture');
INSERT INTO courses (course_id, ects,course_code,course_end_date,course_start_date,course_title) VALUES (3, 5,'SIT','2015-11-05','2013-11-05','Sistemski softver');
INSERT INTO courses (course_id, ects,course_code,course_end_date,course_start_date,course_title) VALUES (4, 4,'POP','2015-11-05','2013-11-05','Platforme za objektno programiranje');
INSERT INTO courses (course_id, ects,course_code,course_end_date,course_start_date,course_title) VALUES (5, 7,'RA','2015-11-05','2013-11-05','Racunari');
INSERT INTO courses (course_id, ects,course_code,course_end_date,course_start_date,course_title) VALUES (6, 8,'WD','2015-11-05','2013-11-05','Web dizajn');
INSERT INTO courses (course_id, ects,course_code,course_end_date,course_start_date,course_title) VALUES (7, 9,'AND','2015-11-05','2013-11-05','Android');

INSERT INTO teaching_type (id, code,name) VALUES (1, 'LE','lecturer');
INSERT INTO teaching_type (id, code,name) VALUES (2, 'TA','teacher assistant');
INSERT INTO teaching_type (id, code,name) VALUES (3, 'LA','laboratory assistant');

INSERT INTO teaching (id, end_date,start_date,courses,professor,teaching_type) VALUES (1, '2015-11-05','2013-11-05',1,1,1);
--INSERT INTO teaching (id, end_date,start_date,courses,professor,teaching_type) VALUES (2, '2015-11-05','2013-11-05',2,1,2);

INSERT INTO enrollments (enrollment_id, enrollment_end_date,enrollment_start_date,courses,student) VALUES (1, '2015-11-05','2013-11-05',1,1);
INSERT INTO enrollments (enrollment_id, enrollment_end_date,enrollment_start_date,courses,student) VALUES (2, '2015-11-05','2013-11-05',2,1);

INSERT INTO exam (id, exam_date,grade,points,status,enrollments) VALUES (1, '2015-05-10',8,71.00,true,1);
INSERT INTO exam (id, exam_date,grade,points,status,enrollments) VALUES (2, '2016-05-09',8,71.00,false,2);
INSERT INTO exam (id, exam_date,grade,points,status,enrollments) VALUES (3, '2016-05-11',7,70.00,true,1);
INSERT INTO exam (id, exam_date,grade,points,status,enrollments) VALUES (4, '2015-05-10',9,81.00,true,1);
INSERT INTO exam (id, exam_date,grade,points,status,enrollments) VALUES (5, '2016-05-09',5,42.00,false,2);
INSERT INTO exam (id, exam_date,grade,points,status,enrollments) VALUES (6, '2016-05-07',10,91.00,true,1);
INSERT INTO exam (id, exam_date,grade,points,status,enrollments) VALUES (7, '2016-05-07',6,53.00,true,1);

INSERT INTO exam_period (id, end_date,name,payment_amount,start_date,exam) VALUES (1, '2020-02-10','january',200.0,'2020-01-10',1);
INSERT INTO exam_period (id, end_date,name,payment_amount,start_date,exam) VALUES (2, '2020-02-20','february',200.0,'2020-02-11',1);
INSERT INTO exam_period (id, end_date,name,payment_amount,start_date,exam) VALUES (3, '2020-05-10','april',200.0,'2020-05-04',2);
INSERT INTO exam_period (id, end_date,name,payment_amount,start_date,exam) VALUES (4, '2020-06-15','june',200.0,'2020-06-10',2);
INSERT INTO exam_period (id, end_date,name,payment_amount,start_date,exam) VALUES (5, '2020-07-25','july',200.0,'2020-07-15',3);
INSERT INTO exam_period (id, end_date,name,payment_amount,start_date,exam) VALUES (6, '2020-09-20','september',200.0,'2020-09-10',3);
INSERT INTO exam_period (id, end_date,name,payment_amount,start_date,exam) VALUES (7, '2020-10-20','october',200.0,'2020-10-11',3);

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


