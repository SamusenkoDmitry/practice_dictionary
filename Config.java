package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final String CONFIGURATION_BOT_FILE = "./config/bot/bot.properties";
    public static final String CONFIGURATION_DB_FILE = "./config/database/database.properties";

    public static String BOT_NAME;
    public static String BOT_TOKEN;
    public static String BOT_URL;
    public static String BOT_USER;
    public static String BOT_PWD;


    public static void load(){
        Properties botSettings = new Properties();
        try(InputStream is = new FileInputStream(new File(CONFIGURATION_BOT_FILE)){
            botSettings.load(is);
            is.close();
            System.out.println("Конфиг Бота загружен успешно");
        }catch(Exception e){
            System.out.println("Ошибка загрузки");
        }
        Properties databaseSettings= new Properties();
        try(InputStream is = new FileInputStream(new File(CONFIGURATION_DB_FILE)){
            databaseSettings.load(is);
            is.close();
            System.out.println("Конфиг Базы данных успешно загружен ");
        }catch(Exception e){
            System.out.println("Ошибка загрузки Базы данных");
        }
         BOT_NAME = botSettings.getProperty("BotName","Mr_ro123_bot");
        BOT_TOKEN = botSettings.getProperty("BotToken","615362692:AAE68GdaIgdJDGyg16pjgg4pgjU8B-6eZ1w");
        BOT_URL = botSettings.getProperty("DbUrl","");
        BOT_USER = botSettings.getProperty("DbUser","root");
        BOT_PWD = botSettings.getProperty("DbPwd","root");
}
}