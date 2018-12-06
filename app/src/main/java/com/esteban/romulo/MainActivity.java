package com.esteban.romulo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    db myDb;
    EditText editName, editAge, editGender;
    Button btnSave, btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new db(this);

        editName = (EditText)findViewById(R.id.editText);
        editAge = (EditText)findViewById(R.id.editText2);
        editGender = (EditText)findViewById(R.id.editText3);
        btnSearch = (Button)findViewById(R.id.button);
        btnSave = (Button)findViewById(R.id.button2);
        SaveData();
    }

    public void SaveData(){
        btnSave.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        boolean isInserted =  myDb.insertData(editName.getText().toString(),
                                editAge.getText().toString(),
                                editGender.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(MainActivity.this,"Sucessful",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Unsuccessful",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
