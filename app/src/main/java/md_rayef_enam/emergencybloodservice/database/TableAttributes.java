package md_rayef_enam.emergencybloodservice.database;

/**
 * Created by Md_Rayef_Enam on 08-Jun-18.
 */

public  class TableAttributes {
    public static final String TABLE_NAME = "users";
    public static final String USER_ID = "user_id";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String PASSWORD = "password";
    public static final String ADDRESS = "address";
    public static final String BLOOD_GROUP="blood_group";

    public String getTableQuery() {
        return "CREATE TABLE "+TABLE_NAME+" ( "+
                USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                NAME+ " TEXT,"+
                PHONE+ " TEXT,"+
                PASSWORD+ " TEXT,"+
                ADDRESS+ " TEXT,"+
                BLOOD_GROUP+ " TEXT)";
    }
}
