package com.example.huy.suppertkb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DAO {
    Context mContext;
    SQLiteDatabase mDB;

    public DAO(Context context) {
        this.mContext = context;
        DbConnect dbConnect=new DbConnect(mContext);
        mDB=dbConnect.getWritableDatabase();
    }

    public void insert(Item item)
    {
        String sql = ("INSERT INTO     Item(thu,monHoc,phongHoc,tietHoc) VALUES \n" +
                "('"+item.thu+"','"+item.mon+"','"+item.phong+"','"+item.tiet+"')");
        mDB.execSQL(sql);
    }

    public ArrayList<Item> read(){
        String sql="select * from Item";
        Cursor cursor=mDB.rawQuery(sql,null);
        ArrayList<Item> lst=new ArrayList<>();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String thu=cursor.getString(1);
            String monHoc=cursor.getString(2);
            String phongHoc=cursor.getString(3);
            String tietHoc=cursor.getString(4);
            Item item=new Item(id,thu,monHoc,phongHoc,tietHoc);
            lst.add(item);
        }
        return lst;
    }

    public void delete(int id){
        String query="delete from Item where id="+id;
        mDB.execSQL(query);
    }
}
