DROP TABLE rules_set;

CREATE TABLE rules_set (
  rule_id_pk      NUMBER(10),
  ruleset_id      VARCHAR2(100),
  rule_id         NUMBER(10),
  priority        NUMBER(10),
  attribute_name  VARCHAR2(100),
  attribute_value VARCHAR2(100)
);

DROP SEQUENCE rule_id_seq;

CREATE SEQUENCE rule_id_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1;

insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 1, 1, 'Exchange', 'NSDQ');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 1, 2, 'ClientId', '1001');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 1, 3, 'Country', 'US');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 1, null, 'Value', '10');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 2, 1, 'Exchange', 'NYSE');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 2, 2, 'ClientId', '1001');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 2, 3, 'Country', 'US');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 2, null, 'Value', '20');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 3, 1, 'Exchange', 'BSE');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 3, 2, 'ClientId', '1001');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 3, 3, 'Country', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 3, null, 'Value', '10');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 4, 1, 'Exchange', 'BSE');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 4, 2, 'ClientId', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 4, 3, 'Country', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 4, null, 'Value', '5');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 5, 1, 'Exchange', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 5, 2, 'ClientId', '2001');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 5, 3, 'Country', 'IN');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 5, null, 'Value', '2');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 6, 1, 'Exchange', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 6, 2, 'ClientId', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 6, 3, 'Country', 'US');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 6, null, 'Value', '6');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 7, 1, 'Exchange', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 7, 2, 'ClientId', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 7, 3, 'Country', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 7, null, 'Value', '20');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 8, 1, 'Exchange', 'NSE');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 8, 2, 'ClientId', '2001');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 8, 3, 'Country', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Instrument', 8, null, 'Value', '20');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 9, 1, 'Exchange', 'NSE');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 9, 2, 'ClientId', '2001');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 9, 3, 'Country', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 9, 4, 'TaxCode', 'AA');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 9, 5, 'AlternateCode', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 9, null, 'Value', '100');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 10, 1, 'Exchange', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 10, 2, 'ClientId', '3001');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 10, 3, 'Country', 'IN');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 10, 4, 'TaxCode', 'AB');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 10, 5, 'AlternateCode', 'CD');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 10, null, 'Value', '90');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 11, 1, 'Exchange', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 11, 2, 'ClientId', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 11, 3, 'Country', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 11, 4, 'TaxCode', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 11, 5, 'AlternateCode', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 11, null, 'Value', '50');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 12, 1, 'Exchange', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 12, 2, 'ClientId', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 12, 3, 'Country', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 12, 4, 'TaxCode', 'YZ');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 12, 5, 'AlternateCode', '*');
insert into rules_set values (RULE_ID_SEQ.NEXTVAL, 'Tax', 12, null, 'Value', '200');

commit;
/
