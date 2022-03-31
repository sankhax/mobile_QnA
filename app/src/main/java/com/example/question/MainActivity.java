package com.example.question;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {
    EditText etemail, etpass;
    private FirebaseAuth auth;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        auth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView createnewac = findViewById(R.id.createnewac);
        etemail = findViewById(R.id.etemail);
        etpass = findViewById(R.id.mypass);

        Button btnlogin = findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Login();
            }
        });
        createnewac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, signupactivity.class));
            }
        });
    }

    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = auth.getCurrentUser();
        updateUI(currentUser);
    }

//    private void logIn() {
//        String email = etemail.getText().toString().trim();
//        String pass = etpass.getText().toString();
//        if (TextUtils.isEmpty(email)) {
//            etemail.setError("Please Enter Email");
//            etemail.requestFocus();
//            return;
//        }
//        if (TextUtils.isEmpty(pass)) {
//            etpass.setError("Please Enter Password");
//            etpass.requestFocus();
//            return;
//        }
//
//    }

    private void updateUI(FirebaseUser currentUser) {
    }

    public void Login() {
        Context context = getApplicationContext();
        auth.signInWithEmailAndPassword(etemail.getText().toString(), etpass.getText().toString()).addOnCompleteListener(
                this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = auth.getCurrentUser();
                            Toast.makeText(context,
                                    "Authentication success.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(user);
                            startActivity(new Intent(MainActivity.this, ListQ.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("signInWithEmail:failure",
                                    task.getException());

                            Toast.makeText(context,
                                    "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }
}
