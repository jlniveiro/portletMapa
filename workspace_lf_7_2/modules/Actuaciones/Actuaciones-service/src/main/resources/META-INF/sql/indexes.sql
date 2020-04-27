create index IX_DAA7D0 on Actuaciones_Actuacion (codTecnico);
create index IX_D722A551 on Actuaciones_Actuacion (comunidadAutonoma[$COLUMN_LENGTH:75$]);
create index IX_BEAF9AB5 on Actuaciones_Actuacion (groupId, status);
create index IX_F27AEC44 on Actuaciones_Actuacion (longitud, latitud);
create index IX_7C0F096 on Actuaciones_Actuacion (nombre[$COLUMN_LENGTH:75$], comunidadAutonoma[$COLUMN_LENGTH:75$], provincia[$COLUMN_LENGTH:75$], situacion[$COLUMN_LENGTH:75$]);
create index IX_BF2CDD02 on Actuaciones_Actuacion (provincia[$COLUMN_LENGTH:75$]);
create index IX_436E4021 on Actuaciones_Actuacion (status);
create index IX_B512756F on Actuaciones_Actuacion (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_62478BB1 on Actuaciones_Actuacion (uuid_[$COLUMN_LENGTH:75$], groupId);