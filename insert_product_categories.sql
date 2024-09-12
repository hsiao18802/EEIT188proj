USE Rent;

-- 請注意，這會刪除product_categories的原有內容
-- 請注意，這會刪除product_categories的原有內容
-- 請注意，這會刪除product_categories的原有內容

DELETE FROM [dbo].[product_categories];

DBCC CHECKIDENT ('[dbo].[product_categories]', RESEED, 0);

INSERT INTO [dbo].[product_categories] (category_name) VALUES
('帳篷'),
('床墊'),
('照明及電器'),
('餐廚用品'),
('桌椅'),
('露營工具'),
('療育玩偶');
