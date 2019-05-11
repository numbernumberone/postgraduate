数据库课程
1 mysql 中的upsert
INSERT INTO table (id, field, field2) VALUES (1, A, X), (2, B, Y), (3, C, Z)
ON DUPLICATE KEY UPDATE field=VALUES(Col1), field2=VALUES(Col2);