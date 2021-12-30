package util;

import model.User;

public class ConfigModel {

    private User currentUser = null;
    private static ConfigModel instance;

    static {
        instance =  WriterReaderHelper.readFromFile();
    }

    public static ConfigModel getInstance() {
        if (instance == null) instance = new ConfigModel();
        return instance;
    }

    public static void sync() {
        WriterReaderHelper.writeToFile(instance);
    }



    public User getCurrentUser() {
        return currentUser;
    }
    public void setCurrentUser(User user) {
        currentUser=user;
    }

}

