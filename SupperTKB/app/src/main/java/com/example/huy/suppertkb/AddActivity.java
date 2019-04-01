package com.example.huy.suppertkb;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {
    ArrayList<Item> mList;
    AdapterActivity mAdapter;
    ListView lstItem;
    DAO dao;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);

        //lstItem = (ListView) findViewById(R.id.idListView);
        dao = new DAO(this);
        mList = dao.read();
        mAdapter = new AdapterActivity(this, R.layout.item_layout, mList);

        Button btnThem = (Button) findViewById(R.id.btnThem);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                them();
            }
        });

        Button btnBack = (Button) findViewById(R.id.btnThoat);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent=new Intent();
                intent.setClass(AddActivity.this,MainActivity.class);
                startActivity(intent);*/
                finish();
            }
        });
    }


    public void them() {
        try {
            EditText thu = (EditText) findViewById(R.id.etThu);
            EditText monHoc = (EditText) findViewById(R.id.etMonHoc);
            EditText phongHoc = (EditText) findViewById(R.id.etPhongHoc);
            EditText tietHoc = (EditText) findViewById(R.id.etTietHoc);

            String sThu = thu.getText().toString();
            String sMonHoc = monHoc.getText().toString();
            String sPhongHoc = phongHoc.getText().toString();
            String sTietHoc = tietHoc.getText().toString();

            if (!sThu.isEmpty() && !sMonHoc.isEmpty() && !sPhongHoc.isEmpty() && !sTietHoc.isEmpty()) {
                DAO dao = new DAO(this);
                mList = new ArrayList<>();
                Item item = new Item(sThu, sMonHoc, sPhongHoc, sTietHoc);
                dao.insert(item);
                mList.add(item);
                Toast.makeText(AddActivity.this, "Đã thêm!!!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Thiếu thông tin", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception ex) {

            new Exception(ex.getMessage());
        }
    }
}
