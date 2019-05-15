create index IX_946B1DD7 on Koroneiki_Account (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_875E5602 on Koroneiki_Contact (emailAddress[$COLUMN_LENGTH:75$]);
create index IX_23B9404A on Koroneiki_Contact (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_5C65FBE2 on Koroneiki_ContactAccountRole (accountId, contactRoleId);

create index IX_689B34B6 on Koroneiki_ContactRole (name[$COLUMN_LENGTH:75$], type_, system_);
create index IX_3DBAA169 on Koroneiki_ContactRole (type_);
create index IX_856F85E0 on Koroneiki_ContactRole (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_478EC5E9 on Koroneiki_Project (accountId);
create index IX_E74A30C3 on Koroneiki_Project (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_ADF0CC27 on Koroneiki_Team (uuid_[$COLUMN_LENGTH:75$], companyId);