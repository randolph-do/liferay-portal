create table Koroneiki_ProductConsumption (
	uuid_ VARCHAR(75) null,
	productConsumptionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	accountId LONG,
	projectId LONG,
	productEntryId LONG
);

create table Koroneiki_ProductEntry (
	uuid_ VARCHAR(75) null,
	productEntryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null
);

create table Koroneiki_ProductField (
	productFieldId LONG not null primary key,
	companyId LONG,
	userId LONG,
	productPurchaseId LONG,
	name VARCHAR(75) null,
	value VARCHAR(75) null
);

create table Koroneiki_ProductPurchase (
	uuid_ VARCHAR(75) null,
	productPurchaseId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	accountId LONG,
	projectId LONG,
	productEntryId LONG,
	startDate DATE null,
	endDate DATE null,
	quantity INTEGER
);