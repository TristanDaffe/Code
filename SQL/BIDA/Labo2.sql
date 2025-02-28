USE Labo2;
CREATE TABLE [dbo].[DimDate](
    [DateKey] [int] NOT NULL,
    [DayFrenchName] [nvarchar](100) NOT NULL,
    [DayEnglishName] [nvarchar](100) NOT NULL,
    [MonthFrenchName] [nvarchar](100) NOT NULL,
    [MonthEnglishName] [nvarchar](100) NOT NULL,
    [WeekNumber] [int] NOT NULL,
    [DayOfWeekNumber] [int] NOT NULL,
    [DayOfYearNumber] [int] NOT NULL,
 CONSTRAINT [PK_DimDate] PRIMARY KEY CLUSTERED 
(
    [DateKey] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
 
GO
/****** Object:  Table [dbo].[FactPost]    Script Date: 26-10-17 09:50:18 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FactPost](
    [DateCreatedKey] [int] NOT NULL,
    [Score] [int] NOT NULL,
    [FavoriteCount] [int] NOT NULL,
    [ViewCount] [int] NOT NULL,
    [AnswerCount] [int] NOT NULL,
    [PostKey] [bigint] IDENTITY(1,1) NOT NULL,
    [DateClosedKey] [int] NOT NULL,
 CONSTRAINT [PK_FactPost] PRIMARY KEY CLUSTERED 
(
    [PostKey] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
 
GO
ALTER TABLE [dbo].[FactPost]  WITH CHECK ADD  CONSTRAINT [FK_FactPost_DimDate] FOREIGN KEY([DateCreatedKey])
REFERENCES [dbo].[DimDate] ([DateKey])
GO
ALTER TABLE [dbo].[FactPost] CHECK CONSTRAINT [FK_FactPost_DimDate]
GO
ALTER TABLE [dbo].[FactPost]  WITH CHECK ADD  CONSTRAINT [FK_FactPost_DimDate1] FOREIGN KEY([DateClosedKey])
REFERENCES [dbo].[DimDate] ([DateKey])
GO
ALTER TABLE [dbo].[FactPost] CHECK CONSTRAINT [FK_FactPost_DimDate1]
GO