create table rules
(
    id             uuid primary key,
    field_selector varchar   not null,                   -- string representation of field path
    field_type     varchar   not null default 'LOCAL',   -- enum [LOCAL, NON_LOCAL, SYSTEM]
    level          varchar   not null default 'WARNING', -- enum [WARNING, ERROR]
    type           varchar   not null default 'MARC',    -- enum [MARC, BIBFRAME]
    created_at     timestamp not null default current_timestamp,
    updated_at     timestamp,
    updated_by     uuid      not null                    -- user_id

);

create table validations
(
    id              uuid primary key,
    rule_id         uuid    not null,
    type            varchar not null, -- json subtype
    validation_body jsonb   not null,
    foreign key (rule_id) references rules (id)
);

create table requests
(
    id                   uuid primary key,
    external_document_id varchar,
    external_group_id    varchar,                           -- may be used to group documents
    type                 varchar   not null default 'MARC', -- enum [MARC, BIBFRAME]
    created_at           timestamp not null default current_timestamp,
    updated_at           timestamp,
    updated_by           uuid      not null                 -- user_id
);

create table validation_results
(
    id                 uuid primary key,
    request_id         uuid    not null,
    rule_id            uuid    not null,
    validation_id      uuid    not null,
    validation_result  varchar not null, -- [ERROR, WARNING]
    validation_message varchar not null,
    foreign key (request_id) references requests (id),
    foreign key (rule_id) references rules (id),
    foreign key (validation_id) references validations (id)
);