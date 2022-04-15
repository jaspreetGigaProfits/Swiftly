package com.example.capstone_the_developers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ChatbotFragment extends Fragment {

        EditText txtMsg;
        FloatingActionButton btnSend;
        ListView listView;

    ArrayList<String> arrayList;
    ArrayList<String> arrayListbot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chatbot, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtMsg=view.findViewById(R.id.txt_msg);
        btnSend=view.findViewById(R.id.btnSend);
        listView =view.findViewById(R.id.list_of_messages);
        arrayList = new ArrayList<String>();
        arrayListbot = new ArrayList<String>();






        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(txtMsg.getText().toString());
                CustomListView customListView=new CustomListView(getActivity(), arrayList);
                //listView.setAdapter(customListView);
                if (txtMsg.getText().toString().equalsIgnoreCase("hi") || txtMsg.getText().toString().equalsIgnoreCase("hello") ||txtMsg.getText().toString().equalsIgnoreCase("hey")){
                    arrayListbot.add("Hello Dear");
                    CustomListViewBot customListViewbot=new CustomListViewBot(getActivity(), arrayListbot);
                    listView.setAdapter(customListViewbot);
                }
                if (txtMsg.getText().toString().equalsIgnoreCase("Headache")){
                    arrayListbot.add("Have a Tea/Coffee");
                    CustomListViewBot customListViewbot=new CustomListViewBot(getActivity(), arrayListbot);
                    listView.setAdapter(customListViewbot);
                }
                if (txtMsg.getText().toString().equalsIgnoreCase("Late Night Work")){
                    arrayListbot.add("Have a strong Coffee");
                    CustomListViewBot customListViewbot=new CustomListViewBot(getActivity(), arrayListbot);
                    listView.setAdapter(customListViewbot);
                }
                if (txtMsg.getText().toString().equalsIgnoreCase("Sad")){
                    arrayListbot.add("Talk to your Favorite Person ");
                    CustomListViewBot customListViewbot=new CustomListViewBot(getActivity(), arrayListbot);
                    listView.setAdapter(customListViewbot);
                }
                if (txtMsg.getText().toString().equalsIgnoreCase("happy")){
                    arrayListbot.add("Time to Celebrate:) ");
                    CustomListViewBot customListViewbot=new CustomListViewBot(getActivity(), arrayListbot);
                    listView.setAdapter(customListViewbot);
                }
                if (txtMsg.getText().toString().equalsIgnoreCase("angry")){
                    arrayListbot.add("Go for a walk.");
                    CustomListViewBot customListViewbot=new CustomListViewBot(getActivity(), arrayListbot);
                    listView.setAdapter(customListViewbot);
                }

                txtMsg.setText("");


            }
        });

    }
}