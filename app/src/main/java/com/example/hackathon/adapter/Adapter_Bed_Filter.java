package com.example.hackathon.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon.R;
import com.example.hackathon.model.Obj_Bed_Filter;
import com.example.hackathon.model.Obj_success;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Adapter_Bed_Filter extends RecyclerView.Adapter<Adapter_Bed_Filter.ViewHolder> {

    private Context mctx;
    private List<Obj_Bed_Filter> obj_bed_filters;
    String S_Status_up;
    String SDte;
    RelativeLayout ongoing_a_lay_s;
    RelativeLayout tour_det_recy;

    public Adapter_Bed_Filter(List<Obj_Bed_Filter> obj_bed_filters, Context mctx) {
        this.mctx = mctx;
        this.obj_bed_filters = obj_bed_filters;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mctx);
        View view = inflater.inflate(R.layout.noti_list, null, true);

        ongoing_a_lay_s = view.findViewById(R.id.ongoing_a_lay_s);
        tour_det_recy = view.findViewById(R.id.tour_det_recy);

        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Obj_Bed_Filter product = obj_bed_filters.get(position);

        holder.bed_fltr_hosp_name.setText(product.getS_bed_fltr_hosp_name());

        holder.bed_fltr_hosp_severity.setText(product.getS_bed_fltr_FacilityType());

//        holder.bed_fltr_hosp_type.setText(product.getS_bed_fltr_FacilityType());
        holder.bed_fltr_normal.setText(product.getS_bed_fltr_O2_Bed());
//        holder.bed_fltr_normal.setText(product.getS_bed_fltr_FacilityType());

//        holder.trnmnt_gm_s_cmp.setText(product.getTour_mode_cmp());
//        holder.trnmnt_ststus_s_cmp.setText(product.getStatus_cmp());
//        holder.trnmnt_id_s_cmp.setText(product.getTour_id_cmp());
//        holder.trnmnt_partici_s_cmp.setText(product.getTour_perti_cmp());

//
/*

//        10:30 PM, 03/05/2020
        SDte = product.getReg_ends_cmp();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;//You will get date object relative to server/client timezone wherever it is parsed
        try {
//            date = dateFormat.parse("2017-04-26T20:55:00.000Z");
            date = dateFormat.parse(SDte);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String f1 ="yyyy-MM-dd";
        String f2 ="hh:mm aa, dd/MM/yyyy";
        DateFormat formatter = new SimpleDateFormat(f2); //If you need time just put specific format for time like 'HH:mm:ss'
        String dateStr = formatter.format(date);
        holder.trnmnt_reg_ends_s_cmp.setText(dateStr);

*/

//
        holder.bed_fltr_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mctx, "Notified", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return obj_bed_filters.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView bed_fltr_hosp_name;
        TextView bed_fltr_hosp_severity;
        TextView bed_fltr_hosp_type;
        TextView bed_fltr_dist_name;
        TextView bed_fltr_normal;

        RelativeLayout bed_fltr_notify;



        public ViewHolder(View itemView) {
            super(itemView);

            bed_fltr_hosp_name = (TextView) itemView.findViewById(R.id.bed_fltr_hosp_name);
            bed_fltr_hosp_severity = (TextView) itemView.findViewById(R.id.bed_fltr_hosp_severity);
            bed_fltr_hosp_type = (TextView) itemView.findViewById(R.id.bed_fltr_hosp_type);
            bed_fltr_dist_name = (TextView) itemView.findViewById(R.id.bed_fltr_dist_name);
            bed_fltr_normal = (TextView) itemView.findViewById(R.id.bed_fltr_normal);
            bed_fltr_notify = (RelativeLayout) itemView.findViewById(R.id.bed_fltr_notify);



        }

    }

}