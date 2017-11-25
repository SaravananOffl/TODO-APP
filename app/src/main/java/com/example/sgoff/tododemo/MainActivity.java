package com.example.sgoff.tododemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    MyDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.task);
        textView=(TextView)findViewById(R.id.textviewclass);
        databaseHelper=new MyDatabaseHelper(this,null,null,1);

    }

    public void addButtonClick(View view)
    { Tasks tasks=new Tasks(editText.getText().toString());
        Log.i("cew",editText.getText().toString());
        databaseHelper.addTasks(tasks);
        printDB();


    }
    public void removeButton(View view){
        String tasks=editText.getText().toString();
        databaseHelper.removeTasks(tasks);
        printDB();
    }
    public void printDB(){
        String string =databaseHelper.databasetoString();
        textView.setText(string);
        Log.i("TWO",string);
    }
}
