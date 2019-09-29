package project.dao;

public class Query {
    public static final String query="\n" +
            "DECLARE @secondDate  DATETIME = Cast('28.10.2017 00:00:00' AS DATETIME)\n" +
            "SELECT\n" +
            "\n" +
            "    CASE\n" +
            "        WHEN [Электроэнергия] ='Объем' OR [Электроэнергия] ='Объем1' THEN '      Объем'\n" +
            "        WHEN [Электроэнергия] ='Цена' OR [Электроэнергия] ='Цена1' THEN '      Цена'\n" +
            "        ELSE [Электроэнергия]\n" +
            "        END\n" +
            "        AS [Электроэнергия]\n" +
            "\n" +
            "     ,CASE\n" +
            "          WHEN [Электроэнергия] ='Объем' OR [Электроэнергия] ='Объем1' OR [Электроэнергия] ='  Объем' THEN 'МВтч'\n" +
            "          WHEN [Электроэнергия] ='Цена' OR [Электроэнергия] ='Цена1' OR [Электроэнергия] ='  Цена' THEN 'руб/МВтч'\n" +
            "          ELSE 'тыс.руб'\n" +
            "    END\n" +
            "        AS [Единицы]\n" +
            "\n" +
            "     ,[Факт]\n" +
            "\n" +
            "FROM\n" +
            "    (SELECT\n" +
            "         CAST (SUM(Query.[Объем]) AS float)\n" +
            "             AS [Объем1]\n" +
            "          ,CAST (SUM(Query.[Объем]) AS float)\n" +
            "             AS [Объем]\n" +
            "          ,CAST (ROUND (SUM(Query.[Цена РСВ])/SUM(Query.[Объем]),2) AS float)\n" +
            "             AS [Цена1]\n" +
            "          ,CAST (ROUND (SUM(Query.[Цена БР])/SUM(Query.[Объем]),2) AS float)\n" +
            "             AS  [Цена]\n" +
            "          ,CAST (ROUND((SUM(Query.[Цена БР])/1000),2) AS float)\n" +
            "             AS [    Покупка электроэнергии перепродажа]\n" +
            "          , CAST (ROUND ((SUM(Query.[Цена РСВ])/1000),2) AS float)\n" +
            "             AS [    Выручка за электроэнергию перепродажа]\n" +
            "          ,CAST (SUM(Query.[Объем])*2 AS float)\n" +
            "             AS [  Объем]\n" +
            "          ,CAST(ROUND (((SUM(Query.[Цена БР])+SUM(Query.[Цена РСВ]))/SUM(Query.[Объем]))/2,2)AS float)\n" +
            "             AS [  Цена]\n" +
            "          ,CAST (ROUND ((SUM(Query.[Цена БР])/1000)+(SUM(Query.[Цена РСВ])/1000),2) AS float)\n" +
            "             AS [Выручка за электроэнергию]\n" +
            "          ,CAST (ROUND(SUM(Query.[Объем])*2*((SUM(Query.[Цена БР])+SUM(Query.[Цена РСВ]))/SUM(Query.[Объем]))/2,3) AS float)\n" +
            "             AS [Маржинальный доход]\n" +
            "     FROM\n" +
            "\n" +
            "         (SELECT\n" +
            "              ABS(ISNULL([ИВ1-],0) + ISNULL([ИВС-],0))\n" +
            "                  AS [Объем]\n" +
            "               ,ABS(ISNULL([ИВ1-],0) + ISNULL([ИВС-],0))*[Цена РСВ]\n" +
            "                  AS [Цена РСВ]\n" +
            "               ,CASE\n" +
            "                    WHEN [ИБР]>=[Ц заявки] THEN [Ц заявки]*ABS(ISNULL([ИВ1-],0) + ISNULL([ИВС-],0))\n" +
            "                    ELSE [ИБР]*ABS(ISNULL([ИВ1-],0) + ISNULL([ИВС-],0))\n" +
            "                 END\n" +
            "                  AS [Цена БР]\n" +
            "\n" +
            "          FROM master.[dbo].[__exercise_table]\n" +
            "          WHERE [dt]<@secondDate)\n" +
            "             AS Query)\n" +
            "        AS Query2\n" +
            "        UNPIVOT(\n" +
            "        [Факт] for [Электроэнергия]\n" +
            "        in(\n" +
            "            [Маржинальный доход]\n" +
            "            ,[Выручка за электроэнергию]\n" +
            "            ,[  Цена]\n" +
            "            ,[  Объем]\n" +
            "            ,[    Выручка за электроэнергию перепродажа]\n" +
            "            ,[Цена1]\n" +
            "            ,[Объем1]\n" +
            "            ,[    Покупка электроэнергии перепродажа]\n" +
            "            ,[Цена]\n" +
            "            ,[Объем]\n" +
            "            )\n" +
            "        ) AS pvt";
}
