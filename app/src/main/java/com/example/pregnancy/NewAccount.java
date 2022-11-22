package com.example.pregnancy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NewAccount extends AppCompatActivity {

    LinearLayout fname, lname;
    TextView login;

    EditText firstName, lastName, email, password, phone, cpassword;

    Button signUp;

    public static ArrayList<users> app_users;

    public static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://pregnancy-1a488-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        getSupportActionBar().hide();

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        cpassword = findViewById(R.id.confirmpassword);

        signUp = findViewById(R.id.signUp);

        fname = findViewById(R.id.firstNameLayout);
        lname = findViewById(R.id.LastNameLayout);

        login = findViewById(R.id.LoginFromSignup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        fname.setMinimumWidth((MainActivity.width / 2 - 10));
        lname.setMinimumWidth(MainActivity.width / 2);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("users").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String TFname = firstName.getText().toString().trim();
                        String TLname = lastName.getText().toString().trim();
                        String TPassword = password.getText().toString().trim();
                        String TEmail = email.getText().toString().trim();
                        String TPhone = phone.getText().toString().trim();
                        String TCPassword = cpassword.getText().toString().trim();

                        String[] VNames = {"first_name", "last_name", "password", "email"};
                        String[] VValues = {TFname, TLname, TPassword, TEmail};

                        if (TFname.isEmpty() || TLname.isEmpty() || TPassword.isEmpty() || TEmail.isEmpty() ||
                                TPhone.isEmpty() || TCPassword.isEmpty()) {
                            Toast.makeText(NewAccount.this, "Cannot submit black fields", Toast.LENGTH_SHORT).show();
                        } else {
                            if (TPassword.equals(TCPassword)) {
                                if(snapshot.hasChild(TPhone)){
                                    Toast.makeText(NewAccount.this, "Already have an account", Toast.LENGTH_SHORT).show();
                                }else{
                                    TEmail = TEmail.substring(0, (TEmail.length() - 5));
                                    for (int i = 0; i < VNames.length; i++) {

                                        databaseReference.child("users").child(TEmail).child(VNames[i]).setValue(VValues[i]);
                                    }

                                    Toast.makeText(NewAccount.this, "Account created successfully!", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(NewAccount.this, "Password Mismatch", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}