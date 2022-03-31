package com.example.question;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signupactivity extends AppCompatActivity {
    EditText etname, etemail, etpass;
    private FirebaseAuth auth;
    private static final String TAG = "signupactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        auth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupactivity);
//        etname=findViewById(R.id.editName);
        etemail = findViewById(R.id.editEmail);
        etpass = findViewById(R.id.editPass);

        Button btn_new = findViewById(R.id.buttonAcount);
//        final String name=etname.getText().toString().trim();
//        final String email=etemail.getText().toString().trim();
//        final String pass=etpass.getText().toString().trim();

        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SignUp();

            }
        });

    }

    private void createNewAcount(String email, String pass) {

        if (email == null) {
            etemail.setError("Please Enter Email");
            etemail.requestFocus();
            return;
        }
        if (pass == null) {
            etpass.setError("Please Enter Password");
            etpass.requestFocus();
            return;
        }

    }

    private void updateUI(FirebaseUser currentUser) {
    }

    public void SignUp() {
        Context context = getApplicationContext();
        auth.createUserWithEmailAndPassword(etemail.getText().toString(), etpass.getText().toString())
                .addOnCompleteListener(this, new
                        OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = auth.getCurrentUser();
                                    startActivity(new Intent(signupactivity.this, MainActivity.class));
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("createUserWithEmail:failed",
                                            task.getException());
//                                    updateUI(null);
                                }
//                                Toast.makeText(context,
//                                        "SignUp failed.",
//                                        Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }
                        });
    }

}



