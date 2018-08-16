package md_rayef_enam.emergencybloodservice;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;


public class SelectBloodArea extends AppCompatActivity  {

    Button btnSubmit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_blood_area);

        final Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(SelectBloodArea.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.group));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        final Spinner mySpinner1 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(SelectBloodArea.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.area));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter1);



        Button btnSubmit = (Button)findViewById(R.id.submitButton);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String valMySpinner = mySpinner.getSelectedItem().toString();
                String valMySpinner1 = mySpinner1.getSelectedItem().toString();
                ArrayList<String> values = new ArrayList<String>();
                values.add(valMySpinner);
                values.add(valMySpinner1);
                Intent searchresult = new Intent(SelectBloodArea.this, SearchResult.class).putStringArrayListExtra("blood",values);
                startActivity(searchresult);


            }
        });
    }
}
