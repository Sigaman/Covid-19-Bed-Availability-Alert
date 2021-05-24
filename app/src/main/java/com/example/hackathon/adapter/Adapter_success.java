package com.example.hackathon.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.hackathon.R;
import com.example.hackathon.model.Obj_success;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Adapter_success extends RecyclerView.Adapter<Adapter_success.ViewHolder> {

    private Context mctx;
    private List<Obj_success> obj_successes;
    String S_Status_up;
    String SDte;
    RelativeLayout ongoing_a_lay_s;
    RelativeLayout tour_det_recy;

    public Adapter_success(List<Obj_success> obj_successes, Context mctx) {
        this.mctx = mctx;
        this.obj_successes = obj_successes;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mctx);
        View view = inflater.inflate(R.layout.card_noti_success, null, true);

        ongoing_a_lay_s = view.findViewById(R.id.ongoing_a_lay_s);
        tour_det_recy = view.findViewById(R.id.tour_det_recy);

        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Obj_success product = obj_successes.get(position);

       



//     




    }

    @Override
    public int getItemCount() {
        return obj_successes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView trnmnt_name_s_cmp;
        TextView trnmnt_reg_ends_s_cmp;
        T

        public ViewHolder(View itemView) {
            super(itemView);

          
            trnmnt_ststus_s_cmp = (TextView) itemView.findViewById(R.id.trnmnt_ststus_s_cmp);
            trnmnt_id_s_cmp = (TextView) itemView.findViewById(R.id.trnmnt_id_s_cmp);
            trnmnt_partici_s_cmp = (TextView) itemView.findViewById(R.id.trnmnt_partici_s_cmp);

        }

    }

}