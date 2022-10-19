package com.example.aula01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Button btn=(Button)findViewById(R.id.btnclick);
    TextView txtapp=(TextView) findViewById(R.id.txtapp);
    TextView txtapp2=(TextView) findViewById(R.id.txtapp2);
    EditText edttxt=(EditText) findViewById(R.id.edttxt);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           txtapp.setText(edttxt.getText());
        }
    });
    }
}