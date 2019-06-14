create table Koroneiki_Account (
	uuid_ VARCHAR(75) null,
	accountId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	logoId LONG,
	addressId LONG,
	contactEmailAddress VARCHAR(75) null,
	profileEmailAddress VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	faxNumber VARCHAR(75) null,
	website VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	statusMessage VARCHAR(75) null
);

create table Koroneiki_Contact (
	uuid_ VARCHAR(75) null,
	contactId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	firstName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	languageId VARCHAR(75) null
);

create table Koroneiki_ContactAccountRole (
	contactId LONG not null,
	accountId LONG not null,
	contactRoleId LONG not null,
	primary key (contactId, accountId, contactRoleId)
);

create table Koroneiki_ContactProjectRole (
	contactId LONG not null,
	projectId LONG not null,
	contactRoleId LONG not null,
	primary key (contactId, projectId, contactRoleId)
);

create table Koroneiki_ContactRole (
	uuid_ VARCHAR(75) null,
	contactRoleId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description STRING null,
	type_ INTEGER,
	system_ BOOLEAN
);

create table Koroneiki_ContactTeamRole (
	contactId LONG not null,
	teamId LONG not null,
	contactRoleId LONG not null,
	primary key (contactId, teamId, contactRoleId)
);

create table Koroneiki_Project (
	uuid_ VARCHAR(75) null,
	projectId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	accountId LONG,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	industry VARCHAR(75) null,
	tier VARCHAR(75) null,
	notes STRING null,
	soldBy VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	statusMessage VARCHAR(75) null
);

create table Koroneiki_Team (
	uuid_ VARCHAR(75) null,
	teamId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	accountId LONG,
	name VARCHAR(75) null
);

create table Koroneiki_TeamProjectRole (
	teamId LONG not null,
	projectId LONG not null,
	teamRoleId LONG not null,
	primary key (teamId, projectId, teamRoleId)
);

create table Koroneiki_TeamRole (
	uuid_ VARCHAR(75) null,
	teamRoleId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	type_ INTEGER
);