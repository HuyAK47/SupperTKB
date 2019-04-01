package com.example.huy.suppertkb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterActivity extends ArrayAdapter {
    Context mContext;
    int mResource;
    ArrayList<Item> mList;
    public AdapterActivity(@NonNull Context context, int resource, @NonNull ArrayList<Item> objects) {
        super(context, resource, objects); // gọi phương thức từ lớp cha

        this.mContext=context;
        this.mResource=resource;
        this.mList=objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        if(row==null){
            LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(mResource,null);
        }

        Item item=mList.get(position);
        ((TextView)row.findViewById(R.id.iThu)).setText(item.thu);
        ((TextView)row.findViewById(R.id.iMonHoc)).setText(item.mon);
        ((TextView)row.findViewById(R.id.iPhongHoc)).setText(item.phong);
        ((TextView)row.findViewById(R.id.iTietHoc)).setText(item.tiet);
        return row;
    }
}
