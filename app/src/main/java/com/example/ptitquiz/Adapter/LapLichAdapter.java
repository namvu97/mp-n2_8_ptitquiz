package com.example.ptitquiz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ptitquiz.Model.LapLich;
import com.example.ptitquiz.R;

import java.util.List;

public class LapLichAdapter extends BaseAdapter {

    private Context myContext;
    int myLayout;
    List<LapLich> arrayLapLich;

    public LapLichAdapter(Context myContext, int myLayout, List<LapLich> arrayLapLich) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.arrayLapLich = arrayLapLich;
    }

    @Override
    public int getCount() {
        return arrayLapLich.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txtGio,txtNoidung;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(myLayout,null);
            holder.txtGio = (TextView) convertView.findViewById(R.id.textViewGio);
            holder.txtNoidung = (TextView) convertView.findViewById(R.id.textViewNoidung);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        LapLich lapLich = arrayLapLich.get(position);
        holder.txtGio.setText(lapLich.getGio());
        holder.txtNoidung.setText(lapLich.getNoidung());
        return convertView;
    }
}
