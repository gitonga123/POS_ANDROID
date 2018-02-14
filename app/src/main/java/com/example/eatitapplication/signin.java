package com.example.eatitapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eatitapplication.Common.Common;
import com.example.eatitapplication.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import mehdi.sakout.fancybuttons.FancyButton;

public class signin extends AppCompatActivity {
    EditText editPhone,editPassword;
    FancyButton btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        editPassword = (MaterialEditText)findViewById(R.id.editPassword);
        editPhone = (MaterialEditText)findViewById(R.id.editPhone);
        btnSignIn = (FancyButton)findViewById(R.id.btnSignIn);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(signin.this);
                mDialog.setMessage("Please waiting....");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Check if User Does not exit in database
                        if(dataSnapshot.child(editPhone.getText().toString()).exists()){


                        mDialog.dismiss();
                        //Get User Information
                        User user = dataSnapshot.child(editPhone.getText().toString()).getValue(User.class);
                        if(user.getPassword().equals(editPassword.getText().toString())){
                            Intent homeIntent = new Intent(signin.this, Home.class);
                            Common.currentUser = user;
                            startActivity(homeIntent);
                            finish();

                        }else{
                            Toast.makeText(signin.this,"Sign Not Successfull!!",Toast.LENGTH_SHORT).show();
                        }
                        }else{
                            mDialog.dismiss();
                            Toast.makeText(signin.this,"Please Create an account with us!",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
