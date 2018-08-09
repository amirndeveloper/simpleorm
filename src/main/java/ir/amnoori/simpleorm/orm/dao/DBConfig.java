package ir.amnoori.simpleorm.orm.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class  DBConfig {

    private DBConfig() {
        
    }

    private static final String DB_USER;

    private static final String DB_PASS;

    private static final String DB_URL;

    private static final List<String> ENTITY_PATH ;

    static {

        ResourceBundle bundle = ResourceBundle.getBundle("DBConfig");


        Field[] fields = DBConfigSchema.class.getDeclaredFields();
        for (int i =0 ; i<fields.length;i++)
        {
            if (!fields[i].getName().equals("ENTITY")){
                try {
                    DBConfig.class.getField(String.valueOf(fields[i])).set(null,null);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            else {

            }
        }


        bundle.getString(DBConfigSchema.DB_PASS);

        if (!bundle.getString(DBConfigSchema.DB_PASS).equals(""))
            DB_PASS = bundle.getString(DBConfigSchema.DB_PASS);
        else {
            try {
                throw new Exception("the DB_PASS property  not correctly set in DBConfig.properties");
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                DB_PASS = "";
            }
        }
        if (!bundle.getString(DBConfigSchema.DB_USER).equals(""))
            DB_USER = bundle.getString(DBConfigSchema.DB_PASS);
        else {
            try {
                throw new Exception("the DB_PASS property  not correctly set in DBConfig.properties");
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                DB_PASS = "";
            }
        }
        DB_URL = "";
        ENTITY_PATH = new ArrayList<String>();
        DB_USER = "";



    }

    public static String getDbUser() {
        return DB_USER;
    }

    public static String getDbPass() {
        return DB_PASS;
    }

    public static String getDbUrl() {
        return DB_URL;
    }

    public static List<String> getEntityPath() {
        return ENTITY_PATH;
    }
}
