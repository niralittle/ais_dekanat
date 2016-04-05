CREATE TABLE cathedra
(
    cathedra_id INT(11) PRIMARY KEY NOT NULL,
    name VARCHAR(80),
    department_department_id INT(11),
    CONSTRAINT FK_o0au1torgv8xtd6jixlfrnn4m FOREIGN KEY (department_department_id) REFERENCES department (department_id)
);
CREATE INDEX FK_o0au1torgv8xtd6jixlfrnn4m ON cathedra (department_department_id);
CREATE TABLE department
(
    department_id INT(11) PRIMARY KEY NOT NULL,
    main_info TEXT,
    name VARCHAR(255)
);
CREATE TABLE final_report
(
    grade INT(11),
    student_student_id INT(11) NOT NULL,
    finalTest_final_id INT(11) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (student_student_id, finalTest_final_id),
    CONSTRAINT FK_osuog6gjb38fnvg439sbolbp7 FOREIGN KEY (student_student_id) REFERENCES student (student_id),
    CONSTRAINT FK_qw3xa73wtd1p61xssfhxxsbl5 FOREIGN KEY (finalTest_final_id) REFERENCES final_test (final_id)
);
CREATE INDEX FK_qw3xa73wtd1p61xssfhxxsbl5 ON final_report (finalTest_final_id);
CREATE TABLE professor
(
    professor_id INT(11) PRIMARY KEY NOT NULL,
    academic_degree VARCHAR(255),
    full_name VARCHAR(255),
    cathedra_cathedra_id INT(11),
    CONSTRAINT FK_i8uysssfxo5l08jnmfcf308f4 FOREIGN KEY (cathedra_cathedra_id) REFERENCES cathedra (cathedra_id)
);
CREATE INDEX FK_i8uysssfxo5l08jnmfcf308f4 ON professor (cathedra_cathedra_id);
CREATE TABLE room
(
    room_id INT(11) PRIMARY KEY NOT NULL,
    name VARCHAR(255)
);
CREATE TABLE student
(
    student_id INT(11) PRIMARY KEY NOT NULL,
    fullName VARCHAR(255),
    group_group_id INT(11),
    CONSTRAINT FK_t2fyim152mg2u4l6ltwc8jqn5 FOREIGN KEY (group_group_id) REFERENCES universitygroup (group_id)
);
CREATE INDEX FK_t2fyim152mg2u4l6ltwc8jqn5 ON student (group_group_id);
CREATE TABLE subject
(
    subject_id INT(11) PRIMARY KEY NOT NULL,
    final_type INT(11),
    name VARCHAR(255)
);
CREATE TABLE syllabus
(
    syllabus_id INT(11) PRIMARY KEY NOT NULL,
    class_type INT(11),
    group_group_id INT(11),
    professor_professor_id INT(11),
    subject_subject_id INT(11),
    CONSTRAINT FK_3p50hd3vi9hivg0bkoqjnx17q FOREIGN KEY (subject_subject_id) REFERENCES subject (subject_id),
    CONSTRAINT FK_655f6etd2lfmuc3f927rxujk FOREIGN KEY (professor_professor_id) REFERENCES professor (professor_id),
    CONSTRAINT FK_i8awgtll69aoft3xrktqn50oq FOREIGN KEY (group_group_id) REFERENCES universitygroup (group_id)
);
CREATE INDEX FK_3p50hd3vi9hivg0bkoqjnx17q ON syllabus (subject_subject_id);
CREATE INDEX FK_655f6etd2lfmuc3f927rxujk ON syllabus (professor_professor_id);
CREATE INDEX FK_i8awgtll69aoft3xrktqn50oq ON syllabus (group_group_id);
CREATE TABLE universitygroup
(
    group_id INT(11) PRIMARY KEY NOT NULL,
    course INT(11),
    name VARCHAR(255),
    department_department_id INT(11),
    CONSTRAINT FK_i41vvql8wlasdoo8wksaupsko FOREIGN KEY (department_department_id) REFERENCES department (department_id)
);
CREATE INDEX FK_i41vvql8wlasdoo8wksaupsko ON universitygroup (department_department_id);
CREATE TABLE final_test
(
    final_id INT(11) PRIMARY KEY NOT NULL,
    time DATE,
    group_group_id INT(11),
    room_room_id INT(11),
    subject_subject_id INT(11),
    CONSTRAINT FK_4peldt1wlssc4kpocoua94pms FOREIGN KEY (room_room_id) REFERENCES room (room_id),
    CONSTRAINT FK_fq9a2qlqy3ktkuj2y42ide98 FOREIGN KEY (subject_subject_id) REFERENCES subject (subject_id),
    CONSTRAINT FK_jgl98wwnub7ix3tlf47irgu66 FOREIGN KEY (group_group_id) REFERENCES universitygroup (group_id)
);
CREATE INDEX FK_4peldt1wlssc4kpocoua94pms ON final_test (room_room_id);
CREATE INDEX FK_fq9a2qlqy3ktkuj2y42ide98 ON final_test (subject_subject_id);
CREATE INDEX FK_jgl98wwnub7ix3tlf47irgu66 ON final_test (group_group_id);
CREATE TABLE dekanat_user
(
    id INT(11) PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    login VARCHAR(255),
    password VARCHAR(255)
);