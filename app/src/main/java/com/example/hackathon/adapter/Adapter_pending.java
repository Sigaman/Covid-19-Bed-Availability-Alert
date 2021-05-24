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
import com.example.hackathon.model.Obj_pending;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Adapter_pending extends RecyclerView.Adapter<Adapter_pending.ViewHolder> {

    private Context mctx;
    private List<Obj_pending> obj_pendings;
    String S_Status_up;
    String SDte;
    RelativeLayout ongoing_a_lay_s;
    RelativeLayout tour_det_recy;

    public Adapter_pending(List<Obj_pending> obj_pendings, Context mctx) {
        this.mctx = mctx;
        this.obj_pendings = obj_pendings;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mctx);
        View view = inflater.inflate(R.layout.card_noti_pending, null, true);

        ongoing_a_lay_s = view.findViewById(R.id.ongoing_a_lay_s);
        tour_det_recy = view.findViewById(R.id.tour_det_recy);

        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Obj_pending product = obj_pendings.get(position);


     

//        10:30 PM, 03/05/2020
        SDte = product.getReg_ends_on();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;//You will get date object relative to server/client timezone wherever it is parsed
      
        }
       



    }


    @Override
    public int getItemCount() {
        return obj_pendings.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView trnmnt_name_s_on;
      


        public ViewHolder(View itemView) {
            super(itemView);


        }

    }

}