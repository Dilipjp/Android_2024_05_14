package com.example.android_2024_05_14;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    EditText editText;
    Button button;
    ArrayList<String> myarrayList;
    String[] teachers = {"PPP", "AAAA", "RR"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myarrayList = new ArrayList<>();
        ArrayAdapter<String> myadpter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, myarrayList);
        autoCompleteTextView = findViewById(R.id.atv);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(myadpter);

        editText = findViewById(R.id.edit_text_id);
        button = findViewById(R.id.add_btn_id);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String result = (String) adapterView.getItemAtPosition(i);
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teacher = editText.getText().toString();
                if(teacher.length() ==0){
                    Toast.makeText(MainActivity.this, "Pleace input teacher name", Toast.LENGTH_SHORT).show();

                }else {
                    myarrayList.add(teacher);
                    myadpter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, teacher + " added", Toast.LENGTH_SHORT).show();
                    editText.setText("");
                }

            }
        });


    }
}