package com.fahad.zongpackages;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adrapter extends RecyclerView.Adapter<adrapter.ViewHolder>  {


    List<product> data;
    Context con;
    public adrapter(Context context, List<product> data)
    {
        this.data = data;
        this.con = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.customm,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        final String ACTIVATION = data.get(position).getACTIVATION();
        String VOLUME = data.get(position).getVOLUME();
        final String DEACTIVATION = data.get(position).getDEACTIVATION();
        String DURATION = data.get(position).getDURATION();
        String INFO = data.get(position).getINFO();
        String PRICE = data.get(position).getPRICE();
        final String REMAINING = data.get(position).getREMAINING();
        String TITLE = data.get(position).getTITLE();


        try {
            holder.TITLE.setText(TITLE);
            holder.DURATION.setText(Html.fromHtml("<b> Duration: </b> " +DURATION.replace("\\n", System.getProperty("line.separator")).replace(">", "Then Replay")));
            holder.VOLUME.setText(Html.fromHtml("<b> Volume: </b> " +VOLUME.replace("\\n", System.getProperty("line.separator")).replace(">", "Then Replay")));
            holder.ACTIVATION.setText(Html.fromHtml("<b> Activaton: </b> " +ACTIVATION.replace("\\n", System.getProperty("line.separator")).replace(">", "Then Replay")));
            holder.DEACTIVATION.setText(Html.fromHtml("<b> Deactivation: </b> " +DEACTIVATION.replace("\\n", System.getProperty("line.separator")).replace(">", "Then Replay")));
            holder.REMAINING.setText(Html.fromHtml("<b> Remaining: </b> " +REMAINING.replace("\\n", System.getProperty("line.separator")).replace(">", "Then Replay")));
            holder.INFO.setText(Html.fromHtml("<b> Info: </b> " +INFO.replace("\\n", System.getProperty("line.separator")).replace(">", "Then Replay")));
            holder.PRICE.setText(Html.fromHtml("<b> Price: </b> " +PRICE.replace("\\n", System.getProperty("line.separator")).replace(">", "Then Replay")));

        }catch (Exception e)
        {
            holder.TITLE.setText(TITLE);
            holder.DURATION.setText(Html.fromHtml("<b> Duration: </b> " +DURATION));
            holder.VOLUME.setText(Html.fromHtml("<b> Volume: </b> " +VOLUME));
            holder.ACTIVATION.setText(Html.fromHtml("<b> Activaton: </b> " +ACTIVATION));
            holder.DEACTIVATION.setText(Html.fromHtml("<b> Deactivation: </b> " +DEACTIVATION));
            holder.REMAINING.setText(Html.fromHtml("<b> Remaining: </b> " +REMAINING));
            holder.INFO.setText(Html.fromHtml("<b> Info: </b> " +INFO));
            holder.PRICE.setText(Html.fromHtml("<b> Price: </b> " +PRICE));

        }


        holder.Activatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((ACTIVATION.charAt(0) == '*' && ACTIVATION.charAt(ACTIVATION.length() - 1) == '#') && !ACTIVATION.contains(">")&& !ACTIVATION.contains("press")&& !ACTIVATION.contains("Or"))
                {

                    Intent out = new Intent();
                    out.setAction(Intent.ACTION_DIAL);
                    out.setData(Uri.parse("tel:" + Uri.encode(ACTIVATION)));
                    con.startActivity(out);
                }
                else
                {
                    Toast.makeText(con, "Please Dial Manually", Toast.LENGTH_SHORT).show();
                }
            }

        });

        holder.Deactivatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((DEACTIVATION.charAt(0) == '*' && DEACTIVATION.charAt(DEACTIVATION.length() - 1) == '#') && !DEACTIVATION.contains(">")&& !DEACTIVATION.contains("press"))
                {

                    Intent out = new Intent();
                    out.setAction(Intent.ACTION_DIAL);
                    out.setData(Uri.parse("tel:" + Uri.encode(DEACTIVATION)));
                    con.startActivity(out);
                }
                else
                {
                    Toast.makeText(con, "Please Dial Manually", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.Remainingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((REMAINING.charAt(0) == '*' && REMAINING.charAt(REMAINING.length() - 1) == '#') && !REMAINING.contains(">")&& !REMAINING.contains("press"))
                {

                    Intent out = new Intent();
                    out.setAction(Intent.ACTION_DIAL);
                    out.setData(Uri.parse("tel:" + Uri.encode(REMAINING)));
                    con.startActivity(out);
                }
                else
                {
                    Toast.makeText(con, "Please Dial Manually", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView ACTIVATION;
        TextView DEACTIVATION;
        TextView VOLUME;
        TextView DURATION;
        TextView INFO;
        TextView PRICE;
        TextView REMAINING;
        TextView TITLE;
        Button Activatebtn;
        Button Deactivatebtn;
        Button Remainingbtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ACTIVATION = itemView.findViewById(R.id.activation);
            DEACTIVATION = itemView.findViewById(R.id.deactivation);
            VOLUME = itemView.findViewById(R.id.volume);
            DURATION = itemView.findViewById(R.id.duration);
            INFO = itemView.findViewById(R.id.info);
            PRICE = itemView.findViewById(R.id.price);
            REMAINING = itemView.findViewById(R.id.remaining);
            TITLE = itemView.findViewById(R.id.title);
            Activatebtn = itemView.findViewById(R.id.acti);
            Deactivatebtn = itemView.findViewById(R.id.deacti);
            Remainingbtn = itemView.findViewById(R.id.remain);

        }
    }


}