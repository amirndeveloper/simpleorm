package ir.amnoori.simpleorm.main;

import ir.amnoori.simpleorm.orm.dao.DaoManager;

public class Main {
    public DaoManager daoManager;

    {
        try {
            daoManager = new DaoManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        DaoManager daoManager;

        {
            try {
                daoManager = new DaoManager();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
