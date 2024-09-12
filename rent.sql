USE [Rent]
GO
/****** Object:  Table [dbo].[cart]    Script Date: 2024/9/12 下午 05:10:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cart](
	[cart_id] [int] IDENTITY(1,1) NOT NULL,
	[product_id] [int] NOT NULL,
	[members_id] [int] NOT NULL,
	[count] [int] NULL,
	[rental_start_date] [datetime] NULL,
	[rental_end_date] [datetime] NULL,
 CONSTRAINT [PK_cart] PRIMARY KEY CLUSTERED 
(
	[cart_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[employee]    Script Date: 2024/9/12 下午 05:10:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[employee](
	[employee_id] [int] IDENTITY(1,1) NOT NULL,
	[employee_account] [nvarchar](100) NOT NULL,
	[employee_password] [varchar](255) NOT NULL,
	[employee_email] [varchar](255) NOT NULL,
	[access_level] [varchar](255) NOT NULL,
 CONSTRAINT [PK_employee_list] PRIMARY KEY CLUSTERED 
(
	[employee_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[extra_photos]    Script Date: 2024/9/12 下午 05:10:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[extra_photos](
	[photo_id] [int] IDENTITY(1,1) NOT NULL,
	[photo] [image] NOT NULL,
	[product_id] [int] NOT NULL,
 CONSTRAINT [PK__Photos__CB48C83D749950D7] PRIMARY KEY CLUSTERED 
(
	[photo_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[members]    Script Date: 2024/9/12 下午 05:10:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[members](
	[members_id] [int] IDENTITY(1,1) NOT NULL,
	[members_username] [nvarchar](50) NOT NULL,
	[members_password] [varbinary](max) NOT NULL,
	[realname] [varchar](50) NULL,
	[email] [nvarchar](100) NOT NULL,
	[phone] [nvarchar](20) NULL,
	[address] [nvarchar](255) NULL,
	[registration_date] [datetime] NULL,
	[member_photo] [image] NULL,
 CONSTRAINT [PK__Members__B29B853429FFB376] PRIMARY KEY CLUSTERED 
(
	[members_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UQ__Members__AB6E61643130A324] UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UQ__Members__F3DBC572B5E6C5AF] UNIQUE NONCLUSTERED 
(
	[members_username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[order]    Script Date: 2024/9/12 下午 05:10:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order](
	[order_id] [int] IDENTITY(1,1) NOT NULL,
	[members_id] [int] NOT NULL,
	[order_creation_date] [datetime] NOT NULL,
	[total_price_amount] [int] NOT NULL,
	[rent_retrun_status] [nvarchar](20) NOT NULL,
	[pay_method] [nvarchar](100) NULL,
	[remarks] [nvarchar](255) NULL,
	[status] [nchar](10) NULL,
	[shipping_fee] [int] NULL,
	[shipping_method] [nvarchar](20) NULL,
 CONSTRAINT [PK__Orders__46596229CA9FA272] PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[order_product]    Script Date: 2024/9/12 下午 05:10:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_product](
	[order_product_id] [int] IDENTITY(1,1) NOT NULL,
	[order_id] [int] NOT NULL,
	[product_id] [int] NOT NULL,
	[count] [int] NOT NULL,
	[rental_start_date] [datetime] NULL,
	[rental_end_date] [datetime] NULL,
	[daily_fee_original] [int] NULL,
	[subtotal] [int] NULL,
	[shipping_fee] [int] NULL,
	[shipping_method] [nvarchar](50) NULL,
	[pay_method] [nvarchar](100) NULL,
 CONSTRAINT [PK__Order_It__3764B6BCBC3B418D] PRIMARY KEY CLUSTERED 
(
	[order_product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product]    Script Date: 2024/9/12 下午 05:10:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[product_id] [int] IDENTITY(1,1) NOT NULL,
	[product_name] [nvarchar](100) NOT NULL,
	[daily_fee_original] [int] NOT NULL,
	[max_available_quantity] [int] NOT NULL,
	[main_photo] [varbinary](max) NULL,
	[description] [nvarchar](max) NULL,
	[category_id] [int] NULL,
	[add_datetime] [datetime] NULL,
	[add_employee_id] [int] NULL,
	[last_update_datetime] [datetime] NULL,
	[last_update_employee_id] [int] NULL,
 CONSTRAINT [PK__Products__47027DF5AFE354B3] PRIMARY KEY CLUSTERED 
(
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product_cart]    Script Date: 2024/9/12 下午 05:10:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product_cart](
	[product_cart_id] [int] NOT NULL,
	[product_id] [int] NULL,
	[cart_id] [int] NULL,
	[count] [int] NULL,
	[rental_start_date] [datetime] NULL,
	[rental_end_date] [datetime] NULL,
	[main_photo] [varbinary](max) NULL,
	[remarks] [varbinary](max) NULL,
 CONSTRAINT [PK_product_cart] PRIMARY KEY CLUSTERED 
(
	[product_cart_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product_categories]    Script Date: 2024/9/12 下午 05:10:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product_categories](
	[category_id] [int] IDENTITY(1,1) NOT NULL,
	[category_name] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[members] ADD  CONSTRAINT [DF__Members__registr__04E4BC85]  DEFAULT (getdate()) FOR [registration_date]
GO
ALTER TABLE [dbo].[order] ADD  CONSTRAINT [DF__Orders__order_da__440B1D61]  DEFAULT (getdate()) FOR [order_creation_date]
GO
ALTER TABLE [dbo].[cart]  WITH CHECK ADD  CONSTRAINT [FK__cart__members_id__40F9A68C] FOREIGN KEY([members_id])
REFERENCES [dbo].[members] ([members_id])
GO
ALTER TABLE [dbo].[cart] CHECK CONSTRAINT [FK__cart__members_id__40F9A68C]
GO
ALTER TABLE [dbo].[cart]  WITH CHECK ADD  CONSTRAINT [FK__cart__product_id__40058253] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([product_id])
GO
ALTER TABLE [dbo].[cart] CHECK CONSTRAINT [FK__cart__product_id__40058253]
GO
ALTER TABLE [dbo].[extra_photos]  WITH CHECK ADD  CONSTRAINT [FK_extra_photos_product_list] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([product_id])
GO
ALTER TABLE [dbo].[extra_photos] CHECK CONSTRAINT [FK_extra_photos_product_list]
GO
ALTER TABLE [dbo].[order]  WITH CHECK ADD  CONSTRAINT [FK_order_member] FOREIGN KEY([members_id])
REFERENCES [dbo].[members] ([members_id])
GO
ALTER TABLE [dbo].[order] CHECK CONSTRAINT [FK_order_member]
GO
ALTER TABLE [dbo].[order_product]  WITH CHECK ADD  CONSTRAINT [FK_order_prodcut_product] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([product_id])
GO
ALTER TABLE [dbo].[order_product] CHECK CONSTRAINT [FK_order_prodcut_product]
GO
ALTER TABLE [dbo].[order_product]  WITH CHECK ADD  CONSTRAINT [FK_order_prodcut_product1] FOREIGN KEY([daily_fee_original])
REFERENCES [dbo].[product] ([product_id])
GO
ALTER TABLE [dbo].[order_product] CHECK CONSTRAINT [FK_order_prodcut_product1]
GO
ALTER TABLE [dbo].[order_product]  WITH CHECK ADD  CONSTRAINT [FK_order_product_order] FOREIGN KEY([order_id])
REFERENCES [dbo].[order] ([order_id])
GO
ALTER TABLE [dbo].[order_product] CHECK CONSTRAINT [FK_order_product_order]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK_product_list_categories] FOREIGN KEY([category_id])
REFERENCES [dbo].[product_categories] ([category_id])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK_product_list_categories]
GO
ALTER TABLE [dbo].[product_cart]  WITH CHECK ADD  CONSTRAINT [FK_product_cart_cart] FOREIGN KEY([cart_id])
REFERENCES [dbo].[cart] ([cart_id])
GO
ALTER TABLE [dbo].[product_cart] CHECK CONSTRAINT [FK_product_cart_cart]
GO
ALTER TABLE [dbo].[product_cart]  WITH CHECK ADD  CONSTRAINT [FK_product_cart_product] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([product_id])
GO
ALTER TABLE [dbo].[product_cart] CHECK CONSTRAINT [FK_product_cart_product]
GO
