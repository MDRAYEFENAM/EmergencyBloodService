package md_rayef_enam.emergencybloodservice;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import md_rayef_enam.emergencybloodservice.database.DatabaseHelper;
import md_rayef_enam.emergencybloodservice.model.Student;

public class SearchResult extends AppCompatActivity {
    TextView textViewUsername, textViewBloodGroup;
    DatabaseHelper dbHelper;
    private ListView listView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<String> s= getIntent().getStringArrayListExtra("blood");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        dbHelper = new DatabaseHelper(SearchResult.this,s);
        //textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        //textViewBloodGroup = (TextView) findViewById(R.id.textViewBloodGroup);
        System.out.println(s.get(0)+"---------------------\n\n");
        System.out.println(s.get(1));

        ArrayList<Student> students=dbHelper.getStudentData();
        listView = (ListView) findViewById(R.id.listView);
        final ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String, Object>>();

        for(Student st:students){
            //textViewUsername.setText(st.getName());
            //textViewBloodGroup.setText(st.getBloodGroup());
            HashMap<String,Object> map1 = new HashMap<String,Object>();
            map1.put("Name", st.getName());
            map1.put("BloodGroup",st.getBloodGroup());
            list.add(map1);
        }
        adapter = new CustomAdapter(this,list);
        listView.setAdapter(adapter);
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(SearchResult.this,list.get(position).get("Name").toString(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    class CustomAdapter extends BaseAdapter {
        private Context context;
        private ArrayList<HashMap<String,Object>> data;

        public CustomAdapter(Context context,ArrayList<HashMap<String,Object>> data){
            this.context = context;
            this.data = data;
        }

        @Override
        public int getCount(){
            return data.size();
        }

        @Override
        public Object getItem(int position){
            return data.get(position);
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            ViewHolder holder;
            if(convertView == null){
                holder =new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
                holder.textViewUsername = (TextView)convertView.findViewById(R.id.textViewUsername);
                holder.textViewBloodGroup = (TextView)convertView.findViewById(R.id.textViewBloodGroup);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder)convertView.getTag();
            }

            holder.textViewUsername.setText(data.get(position).get("Name").toString());
            holder.textViewBloodGroup.setText(data.get(position).get("BloodGroup").toString());

            return convertView;
        }

        class ViewHolder{
            TextView textViewUsername;
            TextView textViewBloodGroup;
        }

    }
}
