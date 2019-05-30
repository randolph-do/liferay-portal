create index IX_F0E63C02 on Koroneiki_AuditEntry (classNameId, classPK);

create index IX_E6C22B10 on Koroneiki_ExternalLink (classNameId, classPK);
create index IX_B82E9C47 on Koroneiki_ExternalLink (domain[$COLUMN_LENGTH:75$], entityName[$COLUMN_LENGTH:75$], entityId[$COLUMN_LENGTH:75$]);