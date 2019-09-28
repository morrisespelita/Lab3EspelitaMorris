package com.espelita.lab3espelitamorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText subj1, subj2, subj3, subj4, subj5, subj6, subj7, subj8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("IT SUBJECTS");
        subj1 = findViewById(R.id.editText);
        subj2 = findViewById(R.id.editText2);
        subj3 = findViewById(R.id.editText3);
        subj4 = findViewById(R.id.editText4);
        subj5 = findViewById(R.id.editText5);
        subj6 = findViewById(R.id.editText6);
        subj7 = findViewById(R.id.editText7);
        subj8 = findViewById(R.id.editText8);
    }

    public void writeData(View v){
        String data1 = subj1.getText().toString() + "_";
        String data2 = subj2.getText().toString() + "_";
        String data3 = subj3.getText().toString() + "_";
        String data4 = subj4.getText().toString() + "_";
        String data5 = subj5.getText().toString() + "_";
        String data6 = subj6.getText().toString() + "_";
        String data7 = subj7.getText().toString() + "_";
        String data8 = subj8.getText().toString() + "_  ";
        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data1.txt",MODE_PRIVATE);
            writer.write(data1.getBytes());
            writer.write(data2.getBytes());
            writer.write(data3.getBytes());
            writer.write(data4.getBytes());
            writer.write(data5.getBytes());
            writer.write(data6.getBytes());
            writer.write(data7.getBytes());
            writer.write(data8.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("error", "file not found...");
        } catch (IOException e) {
            Log.d("error", "IO error...");
        }finally{
            try{
                writer.close();
            }catch (IOException e){
                Log.d("error", "IO error...");
            }
        }
        Toast.makeText(this, "data saved...", Toast.LENGTH_LONG).show();
    }

    public void nextPage(View v){
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }
}
