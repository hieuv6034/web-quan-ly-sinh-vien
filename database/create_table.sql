use chuyendecs;
create table classrooms (
	id bigint NOT NULL auto_increment,
    code varchar(255) not null,
    name varchar(255) not null,
    subject_id varchar(255) null,
    teacher_id varchar(255) null,
    course_id varchar(255) null,
    semester_id varchar(255) null,
    createdat timestamp not null,
    updatedat timestamp not null,
    CONSTRAINT PK_classrooms PRIMARY KEY (id)
);
create table courses (
	id bigint NOT NULL auto_increment,
    code varchar(255) not null,
    department_id varchar(255) not null,
    semester_id varchar(255) null,
    start_year varchar(255) not null,
    end_year varchar(255) null,
    createdat timestamp not null,
    updatedat timestamp not null,
    CONSTRAINT uc_courses_code_key unique (code),
    CONSTRAINT PK_courses PRIMARY KEY (id)
    );
create table departments (
	id bigint NOT NULL auto_increment,
    code varchar(255) not null,
    name varchar(255) not null,
    createdat timestamp not null,
    updatedat timestamp not null,
    CONSTRAINT uc_departments_code_key unique (code),
    CONSTRAINT uc_departments_name_key unique (name),
    CONSTRAINT PK_departments PRIMARY KEY (id)
);
CREATE TABLE grades (
    id bigint NOT NULL auto_increment,
    student_id VARCHAR(255) NOT NULL,
    class VARCHAR(255) NULL,
    subject_id VARCHAR(255) NOT NULL,
    grade1 DOUBLE NULL,
    grade2 DOUBLE NULL,
    exam1 DOUBLE NULL,
    average1 DOUBLE NULL,
    letter1 VARCHAR(255) NULL,
    exam2 DOUBLE NULL,
    average2 DOUBLE NULL,
    letter2 VARCHAR(255) NULL,
    createdat TIMESTAMP NOT NULL,
    updatedat TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);
create table kmaclasses (
		id bigint NOT NULL auto_increment,
        code varchar(255) not null,
        name varchar(255) not null,
        course_id varchar(255) not null,
        createdat timestamp not null,
        updatedat timestamp not null,
        CONSTRAINT uc_kmaclasses_code_key unique (code),
        CONSTRAINT PK_kmaclasses PRIMARY KEY (id)
);
create table roles (
	id bigint NOT NULL auto_increment,
    role_name varchar(255) null,
    role_symbol bigint null default 0,
    createdat timestamp not null,
    updatedat timestamp not null,
    CONSTRAINT PK_roles PRIMARY KEY (id)
);
create table users (
	id bigint NOT NULL auto_increment,
    name varchar(255) null,
    email varchar(255) not null,
    password varchar(255) not null,
    rolesid bigint  not null default 0,
    createdat timestamp not null,
    updatedat timestamp not null,
    CONSTRAINT uc_users_email_key unique (email),
    CONSTRAINT PK_users PRIMARY KEY (id)
);
ALTER TABLE users
ADD FOREIGN KEY (rolesid) REFERENCES roles(id);
create table schoolyears (
	id bigint NOT NULL auto_increment,
    display_name varchar(255) not null,
    start varchar(255) not null,
    end varchar(255) null,
    createdat timestamp not null,
    updatedat timestamp not null,
    CONSTRAINT uc_schoolyears_display_name_key unique (display_name),
    CONSTRAINT PK_schoolyears PRIMARY KEY (id)
);
create table semesters (
	id bigint NOT NULL auto_increment,
    name varchar(255) not null,
    course_id varchar(255) not null,
    subject_id varchar(255) not null,
    CONSTRAINT PK_semesters PRIMARY KEY (id)
);
CREATE TABLE subjects (
   id bigint NOT NULL auto_increment,
    code VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    department VARCHAR(255) NOT NULL,
    alls INT NOT NULL,
    theory INT NULL,
    practice INT NULL,
    exercise INT NULL,
    createdat TIMESTAMP NOT NULL,
    updatedat TIMESTAMP NOT NULL,
    CONSTRAINT uc_subjects_code_key UNIQUE (code),
    PRIMARY KEY (id)
);
create table teachers (
	id bigint NOT NULL auto_increment,
    code varchar(255) not null,
    name varchar(255)not null,
    image varchar(255) null,
    department varchar(255) not null,
    gender bool not null,
    phone varchar(255) not null,
    dob varchar(255) null,
    email varchar(255) not null,
    createdat timestamp not null,
    updatedat timestamp not null,
    CONSTRAINT uc_teachers_code_key unique (code),
    CONSTRAINT PK_teachers PRIMARY KEY (id)
);

create table students (
	id bigint NOT NULL auto_increment,
    code varchar(255) not null,
    name varchar(255) not null,
	gender bool null,
    image varchar(255) null,
    class varchar(255) null,
    bank_number varchar(255) null,
    bank varchar(255) null,
    school_year_id varchar(255) null,
    dob varchar(255) null,
    address varchar(255) null,
    identify_number varchar(255) null,
    identify_date varchar(255) null,
    identify_address varchar(255) null,
    province varchar(255) null,
    district varchar(255) null,
    ward varchar(255) null,
    nationality varchar(255) null,
    ethnic varchar(255) null,
    religion varchar(255) null,
    wish varchar(255) null,
    graduation_year varchar(255) null,
    family varchar(255) null,
    training_object varchar(255) null,
    affiliates varchar(255) null,
    personal_phone varchar(255) null,
    family_phone varchar(255) null,
    office_phone varchar(255) null,
    email varchar(255) null,
    news_to_person varchar(255) null,
    news_to_address varchar(255) null,
    date_join_army varchar(255) null,
    level varchar(255) null,
    cultural_level varchar(255) null,
    unit varchar(255) null,
    salary_type varchar(255) null,
    salary_group varchar(255) null,
    salary_level varchar(255) null,
    salary_factor varchar(255) null,
    salary_date varchar(255) null,
    service varchar(255) null,
    health varchar(255) null,
    date_join_union varchar(255) null,
    date_join_party varchar(255) null,
    
    entry_date varchar(255) null,
    graduation_date varchar(255) null,
    job varchar(255) null,
    laudatory varchar(255) null,
    discipline varchar(255) null,
    createdat timestamp not null,
    updatedat timestamp not null,
    CONSTRAINT PK_students PRIMARY KEY (id)
);


