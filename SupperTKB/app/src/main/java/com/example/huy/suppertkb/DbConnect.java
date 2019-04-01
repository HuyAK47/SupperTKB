package com.example.huy.suppertkb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DbConnect extends SQLiteOpenHelper {

    private final static String DATABASE_NAME="LLL.sqlite";
    private final static int DATABASE_VERSION=1;
    private final String TableItem = "CREATE TABLE Item (\n" +
            "    id    INTEGER       PRIMARY KEY AUTOINCREMENT,\n" +
            "    thu    VARCHAR (150),\n" +
            "    monHoc   VARCHAR (150),\n" +
            "    phongHoc   VARCHAR (150),\n" +
            "    tietHoc VARCHAR (150) \n" +
            ");\n";

    public DbConnect(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TableItem);
        db.execSQL("insert into Item(thu,monHoc,phongHoc,tietHoc) \n" +
                "values ('thứ 3-5','LTHDH','H5 512','1-6');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
