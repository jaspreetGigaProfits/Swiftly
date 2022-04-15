package com.example.capstone_the_developers;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignupTabFragment extends Fragment {

    EditText email,password,mobile,cn;
    Button signUp;

    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        email=view.findViewById(R.id.email);
        password=view.findViewById(R.id.pass);
        mobile=view.findViewById(R.id.mobileNumber);
        signUp=view.findViewById(R.id.btnSignUp);
        cn=view.findViewById(R.id.confirmPass);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }

    public void sendData(){
        String emaildb=email.getText().toString();
        String mobiledb=mobile.getText().toString();
        String pass=password.getText().toString();

        databaseReference=db.getReference("Data");
        String id=databaseReference.push().getKey();

        if(!TextUtils.isEmpty(emaildb) || !TextUtils.isEmpty(mobiledb) ||!TextUtils.isEmpty(pass)){

            SignUpData data=new SignUpData(id,mobiledb,emaildb,pass);
            databaseReference.child(id).setValue(data);

            email.setText("");
            mobile.setText("");
            password.setText("");
            cn.setText("");


        }else {
            showCustomDialog();
        }
    }
    public void showCustomDialog() {
        Dialog dialog = new Dialog(getActivity());

        dialog.setContentView(R.layout.alert_dialog);

        TextView txtDialog = dialog.findViewById(R.id.text_dialog);
        txtDialog.setText("All Fields are mandatory.");

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
