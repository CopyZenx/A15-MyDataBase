package com.musayilmaz.mydatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase myDataBase = this.openOrCreateDatabase("Musician", MODE_PRIVATE, null);

            myDataBase.execSQL("CREATE TABLE IF NOT EXISTS musicians (name VARCHAR, age  INT(2))");

            //myDataBase.execSQL("INSERT INTO musicians (name, age) VALUES ('James', 50)");

            //myDataBase.execSQL("INSERT INTO musicians (name, age) VALUES ('LARS', 55)" );

            //myDataBase.execSQL("INSERT INTO musicians (name, age) VALUES ('Kirk', 60)");

            //myDataBase.execSQL("INSERT INTO musicians (name, age) VALUES ('Rob', 65)");

            //myDataBase.execSQL("DELETE FROM musicians WHERE name LIKE 'J%'");

            //myDataBase.execSQL("UPDATE musicians SET age = 56 WHERE name = 'LARS'");


            Cursor cursor = myDataBase.rawQuery("SELECT * FROM musicians WHERE age>59 AND name LIKE '%i%'", null);

            int nameIx =  cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");

            cursor.moveToFirst();

            while (cursor != null) {

                System.out.println("Name:" + cursor.getString(nameIx));
                System.out.println("Age:" + cursor.getString((ageIx)));
                cursor.moveToNext();

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
