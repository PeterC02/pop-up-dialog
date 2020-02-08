package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyDialog.MyDialogListner{

    private Button openDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openDialogButton = findViewById(R.id.open_dialogue);

        openDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    public void openDialog() {
        MyDialog myDialog = new MyDialog();
        myDialog.show(getSupportFragmentManager(), "my dialog");
    }

    @Override
    public void retrieveText(String textBox1, String textBox2){
        System.out.println(textBox1 + textBox2);

    }

}
