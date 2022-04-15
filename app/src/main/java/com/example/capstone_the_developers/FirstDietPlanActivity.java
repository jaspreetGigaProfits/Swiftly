package com.example.capstone_the_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FirstDietPlanActivity extends AppCompatActivity {

    EditText txtMsg;
    FloatingActionButton btnSend;
    ListView listView;

    ArrayList<String> arrayList;

    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_diet_plan);
        txtMsg=findViewById(R.id.txt_msg);
        btnSend=findViewById(R.id.btnSend);
        listView =findViewById(R.id.list_of_messages);
        arrayList = new ArrayList<String>();
        databaseReference=db.getReference("FirstDietPlanComments");
        String id=databaseReference.push().getKey();


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(txtMsg.getText().toString());
                CustomListView customListView=new CustomListView(FirstDietPlanActivity.this, arrayList);
                listView.setAdapter(customListView);
                String comm=txtMsg.getText().toString();
                FirstDPCommentData data=new FirstDPCommentData(id,comm);
                databaseReference.child(id).setValue(data);
                txtMsg.setText("");

            }
        });
    }

}