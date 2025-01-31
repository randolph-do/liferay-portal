create table SegmentsEntry (
	uuid_ VARCHAR(75) null,
	segmentsEntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	segmentsEntryKey VARCHAR(75) null,
	name STRING null,
	description STRING null,
	active_ BOOLEAN,
	criteria TEXT null,
	source VARCHAR(75) null,
	type_ VARCHAR(75) null,
	lastPublishDate DATE null
);

create table SegmentsEntryRel (
	segmentsEntryRelId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	segmentsEntryId LONG,
	classNameId LONG,
	classPK LONG
);

create table SegmentsExperience (
	uuid_ VARCHAR(75) null,
	segmentsExperienceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	segmentsEntryId LONG,
	segmentsExperienceKey VARCHAR(75) null,
	classNameId LONG,
	classPK LONG,
	name STRING null,
	priority INTEGER,
	active_ BOOLEAN,
	lastPublishDate DATE null
);

create table SegmentsExperiment (
	uuid_ VARCHAR(75) null,
	segmentsExperimentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	segmentsEntryId LONG,
	segmentsExperienceId LONG,
	segmentsExperimentKey VARCHAR(75) null,
	classNameId LONG,
	classPK LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	typeSettings TEXT null,
	status INTEGER
);

create table SegmentsExperimentRel (
	segmentsExperimentRelId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	segmentsExperimentId LONG,
	segmentsExperienceId LONG,
	split DOUBLE
);