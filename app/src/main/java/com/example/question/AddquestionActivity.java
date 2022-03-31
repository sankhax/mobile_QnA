package com.example.question;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddquestionActivity extends AppCompatActivity {

    private EditText quest;
    private Button btnAdd;
    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.addquestion);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        btnAdd = (Button) findViewById(R.id.btnAdd);
        quest = (EditText) findViewById(R.id.inputAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qData data = new qData("1", "test");
                ref.setValue("test");
                startActivity(new Intent( AddquestionActivity.this, ListQ.class));
                Toast.makeText(AddquestionActivity.this, "data added", Toast.LENGTH_SHORT).show();
            }
        });


    }



}