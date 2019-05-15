create table Koroneiki_AuditEntry (
	auditEntryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	auditSetId LONG,
	fieldClassNameId LONG,
	fieldClassPK LONG,
	action VARCHAR(75) null,
	field VARCHAR(75) null,
	oldLabel VARCHAR(75) null,
	oldValue VARCHAR(75) null,
	newLabel VARCHAR(75) null,
	newValue VARCHAR(75) null,
	description VARCHAR(75) null
);

create table Koroneiki_ExternalIdMapper (
	externalIdMapperId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	externalSource INTEGER,
	externalId VARCHAR(75) null
);