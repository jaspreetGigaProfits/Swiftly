package com.example.capstone_the_developers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginTabFragment extends Fragment {

    EditText email, pass;
    TextView forgetPass;
    Button login;

    String emailVerify,passwordVerify,phn;

    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;
    Boolean loginSuc=false;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    SharedPreferences sharedpreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        login=view.findViewById(R.id.login);
        email=view.findViewById(R.id.emailln);
        pass=view.findViewById(R.id.passln);
        databaseReference=db.getReference("Data");
        sharedpreferences = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for (DataSnapshot snapshot1:snapshot.getChildren()){
                                emailVerify=snapshot1.child("email").getValue(String.class);
                            passwordVerify=snapshot1.child("password").getValue(String.class);
                            phn=snapshot1.child("mobile").getValue(String.class);

                            if (emailVerify.equals(email.getText().toString()) && passwordVerify.equals(pass.getText().toString())){
                                Intent intent = new Intent(getActivity(), MeowNavigationActivity.class);
                                startActivity(intent);
                                loginSuc=true;

                               SharedPreferences.Editor editor = sharedpreferences.edit();

                                editor.putString(Email, emailVerify);
                                editor.putString(Phone, phn);

                                editor.apply();

                            }
                        }
                        if (!loginSuc){
                            showCustomDialog();

                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });
    }

    public void showCustomDialog() {
        Dialog dialog = new Dialog(getActivity());

        dialog.setContentView(R.layout.alert_dialog);

        TextView txtDialog = dialog.findViewById(R.id.text_dialog);
        txtDialog.setText("Invalid Login Details");

        Button submitButton = dialog.findViewById(R.id.btn_dialog);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

}
