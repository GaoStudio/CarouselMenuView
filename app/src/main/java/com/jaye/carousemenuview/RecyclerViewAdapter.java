package com.jaye.carousemenuview;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * 作者： gaowei on 2017/2/9 11:45
 * 邮箱： gaoweivf@aliyun.com
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter{
    private List<String> datas;
    private int[] colors = new int[]{Color.BLACK,Color.BLUE,Color.CYAN,Color.GREEN,Color.RED,Color.YELLOW,Color.GRAY};
    public RecyclerViewAdapter(List<String> datas){
        this.datas = datas;
    }
    public void add(int position,String value){
        datas.add(position,value);
        notifyItemInserted(position);
    }
    public void remove(int position){
        datas.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_demo,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.setData(datas.get(position),position);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tvName);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.cardview);
        }
        private void setData(String s,int poistion){
            textView.setText(s);
            linearLayout.setBackgroundColor(colors[poistion%colors.length]);
        }
    }
}
