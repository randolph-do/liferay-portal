create index IX_99321A5A on Koroneiki_ProductConsumption (userId, accountId, projectId, productEntryId);
create index IX_D719E376 on Koroneiki_ProductConsumption (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_EBC2538D on Koroneiki_ProductEntry (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_CB83AD3A on Koroneiki_ProductField (productPurchaseId);

create index IX_3E312B3A on Koroneiki_ProductPurchase (uuid_[$COLUMN_LENGTH:75$], companyId);