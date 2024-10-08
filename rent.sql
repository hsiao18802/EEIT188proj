USE [Rent]
GO
/****** Object:  Table [dbo].[access_level]    Script Date: 2024/10/6 下午 01:09:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[access_level](
	[access_level] [int] NOT NULL,
	[access_type] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_access_level] PRIMARY KEY CLUSTERED 
(
	[access_level] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cart]    Script Date: 2024/10/6 下午 01:09:08 ******/
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
/****** Object:  Table [dbo].[chat_record]    Script Date: 2024/10/6 下午 01:09:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chat_record](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[session_id] [nvarchar](255) NOT NULL,
	[members_id] [int] NOT NULL,
	[sender] [nvarchar](50) NOT NULL,
	[message] [nvarchar](max) NOT NULL,
	[timestamp] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[customer_service_request]    Script Date: 2024/10/6 下午 01:09:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customer_service_request](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[members_id] [int] NOT NULL,
	[issue_description] [nvarchar](max) NOT NULL,
	[status] [nvarchar](50) NULL,
	[request_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[discount]    Script Date: 2024/10/6 下午 01:09:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[discount](
	[discount_id] [int] IDENTITY(1,1) NOT NULL,
	[code] [nvarchar](50) NOT NULL,
	[description] [nvarchar](255) NULL,
	[discount_type] [nvarchar](20) NULL,
	[discount_value] [float] NULL,
	[start_date] [date] NULL,
	[end_date] [date] NULL,
	[usage_limit] [int] NULL,
	[usage_count] [int] NULL,
	[is_active] [bit] NULL,
 CONSTRAINT [PK__Discount__BDBE9EF902C9B300] PRIMARY KEY CLUSTERED 
(
	[discount_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[employee]    Script Date: 2024/10/6 下午 01:09:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[employee](
	[employee_id] [int] IDENTITY(1,1) NOT NULL,
	[employee_account] [nvarchar](100) NOT NULL,
	[employee_password] [varchar](255) NOT NULL,
	[employee_email] [varchar](255) NULL,
	[access_level] [int] NULL,
 CONSTRAINT [PK_employee_list] PRIMARY KEY CLUSTERED 
(
	[employee_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[extra_photos]    Script Date: 2024/10/6 下午 01:09:08 ******/
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
/****** Object:  Table [dbo].[members]    Script Date: 2024/10/6 下午 01:09:08 ******/
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
	[black_listed] [bit] NULL,
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
/****** Object:  Table [dbo].[order_product]    Script Date: 2024/10/6 下午 01:09:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_product](
	[order_product_id] [int] IDENTITY(1,1) NOT NULL,
	[order_id] [int] NOT NULL,
	[product_id] [int] NOT NULL,
	[count] [int] NOT NULL,
	[daily_fee_original] [int] NULL,
	[subtotal] [int] NULL,
	[product_name] [nvarchar](100) NULL,
	[main_photo] [varbinary](max) NULL,
 CONSTRAINT [PK__Order_It__3764B6BCBC3B418D] PRIMARY KEY CLUSTERED 
(
	[order_product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orders]    Script Date: 2024/10/6 下午 01:09:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orders](
	[order_id] [int] IDENTITY(1,1) NOT NULL,
	[members_id] [int] NOT NULL,
	[order_creation_date] [datetime] NOT NULL,
	[total_price_amount] [int] NOT NULL,
	[pay_method] [nvarchar](100) NULL,
	[remarks] [nvarchar](255) NULL,
	[shipping_fee] [int] NULL,
	[shipping_method] [nvarchar](255) NULL,
	[rental_start_date] [date] NULL,
	[rental_end_date] [date] NULL,
	[rental_days] [int] NULL,
	[shipping_name] [nvarchar](255) NULL,
	[shipping_phone_number] [nvarchar](255) NULL,
	[shipping_address] [nvarchar](255) NULL,
	[order_status] [smallint] NULL,
	[discount_code] [varchar](255) NULL,
	[discount_value] [float] NULL,
	[merchant_trade_no] [varchar](255) NULL,
	[ecpay_trade_no] [varchar](255) NULL,
 CONSTRAINT [PK__Orders__46596229CA9FA272] PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product]    Script Date: 2024/10/6 下午 01:09:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[product_id] [int] IDENTITY(1,1) NOT NULL,
	[product_name] [nvarchar](100) NULL,
	[daily_fee_original] [int] NULL,
	[max_available_quantity] [int] NULL,
	[main_photo] [varbinary](max) NULL,
	[description] [nvarchar](max) NULL,
	[description_two] [bit] NULL,
	[category_id] [int] NULL,
	[status_id] [int] NULL,
	[add_employee_id] [int] NULL,
	[add_datetime] [datetime] NULL,
	[last_update_employee_id] [int] NULL,
	[last_update_datetime] [datetime] NULL,
 CONSTRAINT [PK__Products__47027DF5AFE354B3] PRIMARY KEY CLUSTERED 
(
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product_cart]    Script Date: 2024/10/6 下午 01:09:08 ******/
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
/****** Object:  Table [dbo].[product_category]    Script Date: 2024/10/6 下午 01:09:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product_category](
	[category_id] [int] IDENTITY(1,1) NOT NULL,
	[category_name] [nvarchar](50) NOT NULL,
	[display_sequence] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product_status]    Script Date: 2024/10/6 下午 01:09:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product_status](
	[status_id] [int] NOT NULL,
	[status] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_producr_status] PRIMARY KEY CLUSTERED 
(
	[status_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[chat_record] ADD  DEFAULT (getdate()) FOR [timestamp]
GO
ALTER TABLE [dbo].[customer_service_request] ADD  DEFAULT ('pending') FOR [status]
GO
ALTER TABLE [dbo].[customer_service_request] ADD  DEFAULT (getdate()) FOR [request_date]
GO
ALTER TABLE [dbo].[discount] ADD  CONSTRAINT [DF__Discount__usage___3DB3258D]  DEFAULT ((0)) FOR [usage_count]
GO
ALTER TABLE [dbo].[discount] ADD  CONSTRAINT [DF__Discount__is_act__3EA749C6]  DEFAULT ((1)) FOR [is_active]
GO
ALTER TABLE [dbo].[members] ADD  CONSTRAINT [DF__Members__registr__04E4BC85]  DEFAULT (getdate()) FOR [registration_date]
GO
ALTER TABLE [dbo].[orders] ADD  CONSTRAINT [DF_Orders_order_creation_date]  DEFAULT (getdate()) FOR [order_creation_date]
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
ALTER TABLE [dbo].[chat_record]  WITH CHECK ADD  CONSTRAINT [FK_chat_record_members] FOREIGN KEY([members_id])
REFERENCES [dbo].[members] ([members_id])
GO
ALTER TABLE [dbo].[chat_record] CHECK CONSTRAINT [FK_chat_record_members]
GO
ALTER TABLE [dbo].[customer_service_request]  WITH CHECK ADD FOREIGN KEY([members_id])
REFERENCES [dbo].[members] ([members_id])
GO
ALTER TABLE [dbo].[employee]  WITH CHECK ADD  CONSTRAINT [FK_employee_access_level] FOREIGN KEY([access_level])
REFERENCES [dbo].[access_level] ([access_level])
GO
ALTER TABLE [dbo].[employee] CHECK CONSTRAINT [FK_employee_access_level]
GO
ALTER TABLE [dbo].[extra_photos]  WITH CHECK ADD  CONSTRAINT [FK_extra_photos_product_list] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([product_id])
GO
ALTER TABLE [dbo].[extra_photos] CHECK CONSTRAINT [FK_extra_photos_product_list]
GO
ALTER TABLE [dbo].[order_product]  WITH CHECK ADD  CONSTRAINT [FK_order_product_order] FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([order_id])
GO
ALTER TABLE [dbo].[order_product] CHECK CONSTRAINT [FK_order_product_order]
GO
ALTER TABLE [dbo].[order_product]  WITH CHECK ADD  CONSTRAINT [FK_order_product_product] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([product_id])
GO
ALTER TABLE [dbo].[order_product] CHECK CONSTRAINT [FK_order_product_product]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK_order_member] FOREIGN KEY([members_id])
REFERENCES [dbo].[members] ([members_id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK_order_member]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK_product_employee] FOREIGN KEY([add_employee_id])
REFERENCES [dbo].[employee] ([employee_id])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK_product_employee]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK_product_employee1] FOREIGN KEY([last_update_employee_id])
REFERENCES [dbo].[employee] ([employee_id])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK_product_employee1]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK_product_list_categories] FOREIGN KEY([category_id])
REFERENCES [dbo].[product_category] ([category_id])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK_product_list_categories]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK_product_producr_status] FOREIGN KEY([status_id])
REFERENCES [dbo].[product_status] ([status_id])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK_product_producr_status]
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
