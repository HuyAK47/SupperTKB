package com.example.huy.suppertkb;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Item> mList = new ArrayList<>();
    AdapterActivity mAdapter;
    ListView lstItem;
    DAO dao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        startList();

        lstItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                popupMenu.inflate(R.menu.context_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        Item i = (Item) lstItem.getItemAtPosition(position);
                        switch (id) {
                            case R.id.menuXoa:
                                xoa(i.id, position);
                                Toast.makeText(MainActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }

                });
                popupMenu.show();
            }
        });

        lstItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                popupMenu.inflate(R.menu.context_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        Item i = (Item) lstItem.getItemAtPosition(position);
                        switch (id) {
                            case R.id.menuXoa:
                                xoa(i.id, position);
                                Toast.makeText(MainActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
                return true;
            }
        });

        Button btnThem = (Button) findViewById(R.id.btnAdd);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), AddActivity.class);
                startActivity(intent);
            }
        });
    }

    public void startList(){
        lstItem = (ListView) findViewById(R.id.idListView);
        dao = new DAO(this);
        mList = dao.read();
        mAdapter = new AdapterActivity(this, R.layout.item_layout, mList);
        lstItem.setAdapter(mAdapter);
        registerForContextMenu(lstItem);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.idAdd:
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), AddActivity.class);
                startActivity(intent);
                break;
            case R.id.about:
                Toast.makeText(this, "Thông tin phần mềm", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    public void xoa(int id, int pos) {
        DAO dao = new DAO(this);
        dao.delete(id);
        mList.remove(pos);
        mAdapter.notifyDataSetChanged();
    }

        @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        startList();
        mAdapter.notifyDataSetChanged();
    }
}
