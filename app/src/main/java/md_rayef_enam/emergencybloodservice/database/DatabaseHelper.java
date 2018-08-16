package md_rayef_enam.emergencybloodservice.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

import md_rayef_enam.emergencybloodservice.model.Student;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static  final String DB_NAME = "lict.db";
    ArrayList<String> search=new ArrayList<String>();
    public DatabaseHelper(Context context,ArrayList<String> s) {
        super(context,DB_NAME,null,1);
        search=s;
    }

    @Override
    public  void onCreate(SQLiteDatabase db){
        TableAttributes tableAttributes = new TableAttributes();
        try {
            //db.execSQL("drop table "+TableAttributes.TABLE_NAME);
            //db.execSQL(tableAttributes.getTableQuery());
            db.execSQL("CREATE TABLE USERS ( "+
                    "USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "NAME TEXT,"+
                    "PHONE TEXT,"+
                    "PASSWORD TEXT,"+
                    "ADDRESS TEXT,"+
                    "BLOOD_GROUP TEXT)");
            Log.i("Table Create: ", "Success");
        }catch (SQLException e) {
            Log.e("Table Create: ", e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(Student std) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TableAttributes.NAME, std.getName());
        values.put(TableAttributes.PASSWORD, std.getPassword());
        values.put(TableAttributes.PHONE, std.getPhone());
        values.put(TableAttributes.ADDRESS, std.getAddress());
        values.put(TableAttributes.BLOOD_GROUP, std.getBloodGroup());
        try {
            db.insert(TableAttributes.TABLE_NAME, null, values);
            System.out.println("Table Insert: " + "Succesful");
        } catch (SQLException e) {
            Log.e("Table Insert: ", e.toString());
        } finally {
            db.close();
        }
    }

    public ArrayList<Student> getStudentData() {
        ArrayList<Student> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TableAttributes.TABLE_NAME+" where BLOOD_GROUP='"+ search.get(0)+"' and ADDRESS='"+search.get(1)+"'";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(cursor.getColumnIndex("NAME"));
            String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
            String phone = cursor.getString(cursor.getColumnIndex("PHONE"));
            String address = cursor.getString(cursor.getColumnIndex("ADDRESS"));
            String blood_group = cursor.getString(cursor.getColumnIndex("BLOOD_GROUP"));

            Student std = new Student(name,password,phone,address,blood_group);
            data.add(std);

            cursor.moveToNext();
        }
        return data;
    }
}
