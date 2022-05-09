create table ers_reimbursement (
	reimb_id serial primary KEY,
	reimb_amount int,
	reimb_submitted TimeStamp,
	reimb_resolved TimeStamp,
	reimb_description varchar(250),
	reimb_receipt bytea,
	reimb_author_fk int references ers_users(ers_users_id),
	reimb_resolver_fk int references ers_users(ers_users_id),
	reimb_status_id_fk int references ers_reimbursement_status(reimb_status_id),
	reimb_type_id_fk int references ers_reimbursement_type(reimb_type_id)
);

create table ers_reimbursement_status (
	reimb_status_id serial primary key,
	reimb_status varchar(10)
);

create table ers_reimbursement_type (
	reimb_type_id serial primary key,
	reimb_type varchar(10)
);

create table ers_users (
	ers_users_id serial primary key,
	ers_username varchar(50),
	ers_password varchar(50),
	user_first_name varchar(100),
	user_last_name varchar(100),
	user_email varchar(150),
	user_role_id_fk int references ers_user_roles(ers_user_role_id)
);

create table ers_user_roles (
	ers_user_role_id serial primary key,
	user_role varchar(10)
);


insert into ers_users (ers_users_id, ers_username, ers_password, user_first_name, user_last_name, user_email)
values (default, 'JasonBourne', 'IDSuperUltimatum', 'David', 'Webb', 'JasonBourne@gmail.com');

insert into ers_reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt)
values (default, 300.29, '2020-10-05 14:01:10-08', '2021-1-15 12:01:12-08', 'laptop', '002');

insert into ers_user_roles (ers_user_role_id, user_role)
values (default, 'Operative');

delete from ers_users where ers_username = 'JasonBourne';

select * from ers_users;

drop table ers_users;

drop table ers_reimbursement;