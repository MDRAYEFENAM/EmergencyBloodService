package md_rayef_enam.emergencybloodservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;

import md_rayef_enam.emergencybloodservice.database.TableAttributes;


public class MainActivity extends AppCompatActivity {

    Button searchBtn,profileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button searchBtn = (Button)findViewById(R.id.searchButton);
        Button profileBtn = (Button)findViewById(R.id.profileButton);


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selectbloodarea = new Intent(MainActivity.this,SelectBloodArea.class);
                startActivity(selectbloodarea);

            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signuppage = new Intent(MainActivity.this,SignUpPage.class);
                startActivity(signuppage);

            }
        });

    }
}













