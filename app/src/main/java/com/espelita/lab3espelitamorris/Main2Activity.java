package com.espelita.lab3espelitamorris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    //CheckBox[] checkBoxes = new CheckBox[8];
    String data = "";;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("SUBJECTS TAKEN");
        FileInputStream reader = null;
        try{
            reader = openFileInput("data1.txt");
            int token;
            while((token = reader.read()) != -1){
                data = data + ((char)token);
            }
            reader.close();
            try{
                String[] list = data.split("_");
                ((CheckBox) (findViewById(R.id.checkBox))).setText(list[0]);
                ((CheckBox) (findViewById(R.id.checkBox2))).setText(list[1]);
                ((CheckBox) (findViewById(R.id.checkBox3))).setText(list[2]);
                ((CheckBox) (findViewById(R.id.checkBox4))).setText(list[3]);
                ((CheckBox) (findViewById(R.id.checkBox5))).setText(list[4]);
                ((CheckBox) (findViewById(R.id.checkBox6))).setText(list[5]);
                ((CheckBox) (findViewById(R.id.checkBox7))).setText(list[6]);
                ((CheckBox) (findViewById(R.id.checkBox8))).setText(list[7]);
                ((CheckBox) (findViewById(R.id.checkBox8))).getText();
            } catch (Exception e){
                Log.d("error", "subject not found...");
            }
        } catch (FileNotFoundException e){
            Log.d("error", "file not found...");
        } catch (IOException e) {
            Log.d("error", "IO error...");
        }
    }
}
