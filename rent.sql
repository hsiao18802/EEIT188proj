USE [master]
GO
/****** Object:  Database [Rent]    Script Date: 2024/9/23 下午 05:31:30 ******/
CREATE DATABASE [Rent]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'RentalDraftDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\RentalDraftDB .mdf' , SIZE = 73728KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'RentalDraftDB _log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\RentalDraftDB _log.ldf' , SIZE = 73728KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [Rent] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Rent].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Rent] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Rent] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Rent] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Rent] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Rent] SET ARITHABORT OFF 
GO
ALTER DATABASE [Rent] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Rent] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Rent] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Rent] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Rent] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Rent] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Rent] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Rent] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Rent] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Rent] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Rent] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Rent] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Rent] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Rent] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Rent] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Rent] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Rent] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Rent] SET RECOVERY FULL 
GO
ALTER DATABASE [Rent] SET  MULTI_USER 
GO
ALTER DATABASE [Rent] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Rent] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Rent] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Rent] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Rent] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Rent] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'Rent', N'ON'
GO
ALTER DATABASE [Rent] SET QUERY_STORE = ON
GO
ALTER DATABASE [Rent] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [Rent]
GO
/****** Object:  Table [dbo].[access_level]    Script Date: 2024/9/23 下午 05:31:31 ******/
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
/****** Object:  Table [dbo].[cart]    Script Date: 2024/9/23 下午 05:31:31 ******/
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
/****** Object:  Table [dbo].[employee]    Script Date: 2024/9/23 下午 05:31:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[employee](
	[employee_id] [int] IDENTITY(1,1) NOT NULL,
	[employee_account] [nvarchar](100) NOT NULL,
	[employee_password] [varchar](255) NOT NULL,
	[employee_email] [varchar](255) NOT NULL,
	[access_level] [int] NOT NULL,
 CONSTRAINT [PK_employee_list] PRIMARY KEY CLUSTERED 
(
	[employee_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[extra_photos]    Script Date: 2024/9/23 下午 05:31:31 ******/
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
/****** Object:  Table [dbo].[members]    Script Date: 2024/9/23 下午 05:31:31 ******/
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
/****** Object:  Table [dbo].[order]    Script Date: 2024/9/23 下午 05:31:31 ******/
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
/****** Object:  Table [dbo].[order_product]    Script Date: 2024/9/23 下午 05:31:31 ******/
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
/****** Object:  Table [dbo].[product]    Script Date: 2024/9/23 下午 05:31:31 ******/
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
/****** Object:  Table [dbo].[product_cart]    Script Date: 2024/9/23 下午 05:31:31 ******/
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
/****** Object:  Table [dbo].[product_category]    Script Date: 2024/9/23 下午 05:31:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product_category](
	[category_id] [int] IDENTITY(1,1) NOT NULL,
	[category_name] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product_status]    Script Date: 2024/9/23 下午 05:31:31 ******/
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
USE [master]
GO
ALTER DATABASE [Rent] SET  READ_WRITE 
GO
