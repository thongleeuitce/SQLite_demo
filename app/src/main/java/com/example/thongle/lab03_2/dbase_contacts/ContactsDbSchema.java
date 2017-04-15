package com.example.thongle.lab03_2.dbase_contacts;

/**
 * Created by thongle on 15/04/2017.
 */

public class ContactsDbSchema {
    public static final class ContactsTable{
        public static final String NAME = "Contact";
        public static final class Colunms{
            public static final String KEY_ID = "id";
            public static final String KEY_NAME = "name";
            public static final String KEY_PHONE_NUMBER = "phone_number";
        }
    }
}
