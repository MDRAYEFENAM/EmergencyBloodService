package md_rayef_enam.emergencybloodservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import md_rayef_enam.emergencybloodservice.database.DatabaseHelper;
import md_rayef_enam.emergencybloodservice.model.Student;

public class SignUpPage extends AppCompatActivity {
    EditText editTextName, editTextPhone, editTextPassword, editTextAddress, editTextBloodGroup ;
    ListView listView;
    ArrayList<Student> arrayList;
    //ArrayAdapter<Student> adapter;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        editTextName = (EditText) findViewById(R.id.etName);
        editTextPhone = (EditText) findViewById(R.id.etPhone);
        editTextPassword = (EditText) findViewById(R.id.etPassword);
        editTextAddress = (EditText) findViewById(R.id.etAddress);
        editTextBloodGroup = (EditText) findViewById(R.id.etBloodGroup);
        listView = (ListView) findViewById(R.id.etList);

        dbHelper = new DatabaseHelper(SignUpPage.this,null);

    }

    public void saveDataIntoDB(View view) {
        boolean error = false;

        Student std = new Student("","","","","");

        String name = editTextName.getText().toString();
        if (name.isEmpty()){
            editTextName.setError("username is missing");
        }else{
            if(name.length()<6){
                editTextName.setError("username is too short");
            }else{
                std.setName(name);
            }
        }


        String phoneNo = editTextPhone.getText().toString();
        if(phoneNo.isEmpty()){
            editTextPhone.setError("Phone no is missing!");
            error = true;
        }else if(phoneNo.length() == 11) {
            if (phoneNo.startsWith("018") || phoneNo.startsWith("017") || phoneNo.startsWith("016") || phoneNo.startsWith("015")) {
                std.setPhone(phoneNo);
            } else {
                editTextPhone.setError("Phone no is not valid!");
            }
        } else {
            editTextPhone.setError("Phone no should be 11 digit!");
            error = true;
        }

        String password = editTextPassword.getText().toString();
        std.setPassword(password);

        String address = editTextAddress.getText().toString();
        std.setAddress(address);

        String bloodGroup = editTextBloodGroup.getText().toString();
        if (bloodGroup.isEmpty()){
            editTextBloodGroup.setError("Blood Group is missing");
        }else  {
                std.setBloodGroup(bloodGroup);
            }


        if(error){
            Toast.makeText( SignUpPage.this,  "Data is not saved", Toast.LENGTH_LONG).show();
        }else {
            clearData(view);
            dbHelper.insertData(std);

            Toast.makeText( SignUpPage.this,  "Data is saved", Toast.LENGTH_LONG).show();
        }
    }

    public void clearData(View view){
        editTextName.setText(null);
        editTextPhone.setText(null);
        editTextPassword.setText(null);
        editTextAddress.setText(null);
        editTextBloodGroup.setText(null);
    }

    public void jump(View view) {
       // ArrayList<Student> students=dbHelper.getStudentData();

        //for(Student st:students){
           // System.out.println(st.getName());
        //}
        Intent intent = new Intent(SignUpPage.this, MainActivity.class);
        startActivity(intent);
    }
}

