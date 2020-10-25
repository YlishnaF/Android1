package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SocnetAdapter extends RecyclerView.Adapter<SocnetAdapter.ViewHolder> {
    private SocSource dataSource;

    public SocnetAdapter(SocSource dataSource) {
        this.dataSource = dataSource;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Soc soc = dataSource.getSoc(position);
        holder.setData(soc.getTime(),soc.getTemperature(),soc.getPicture());

    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView time;
        private TextView temperature;
        private ImageView picture;


        public ViewHolder(@NonNull View view){
            super(view);
            time = view.findViewById(R.id.timetv);
            temperature = view.findViewById(R.id.temperaturetv);
            picture = view.findViewById(R.id.pictureiv);
        }

        public void setData(String time, String temperature, int picture){
            getTime().setText(time);
            getTemperature().setText(temperature);
            getPicture().setImageResource(picture);
        }

        public TextView getTime() {
            return time;
        }

        public TextView getTemperature() {
            return temperature;
        }

        public ImageView getPicture() {
            return picture;
        }
    }
}
