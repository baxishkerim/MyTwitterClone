create  sequence  hibernate_sequence start l increment l;


CREATE TABLE usr
(
    id              BIGINT       NOT NULL,
    username        VARCHAR(255) NULL,
    password        VARCHAR(255) NULL,
    active          BIT(1)       NULL,
    email           VARCHAR(255) NULL,
    activation_code VARCHAR(255) NULL,
    CONSTRAINT pk_usr PRIMARY KEY (id)
);


CREATE TABLE user_role (
    user_id int  8 not null,
    roles  varchar (255)
)

CREATE TABLE message
(
    id      BIGINT       NOT NULL,
    text    VARCHAR(255) NULL,
    tag     VARCHAR(255) NULL,
    user_id BIGINT       NULL,
    CONSTRAINT pk_message PRIMARY KEY (id)
);

alter table if exists message
    add constraint message_user_fk
    foreign key (user_id) references usr;

alter table if exists user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr;