USE Rent;

-- �Ъ`�N�A�o�|�R��product_categories���즳���e
-- �Ъ`�N�A�o�|�R��product_categories���즳���e
-- �Ъ`�N�A�o�|�R��product_categories���즳���e

DELETE FROM [dbo].[product_categories];

DBCC CHECKIDENT ('[dbo].[product_categories]', RESEED, 0);

INSERT INTO [dbo].[product_categories] (category_name) VALUES
('�b�O'),
('�ɹ�'),
('�ө��ιq��'),
('�\�p�Ϋ~'),
('���'),
('�S��u��'),
('���|����');
