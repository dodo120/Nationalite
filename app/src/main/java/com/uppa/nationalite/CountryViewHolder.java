package com.uppa.nationalite;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.uppa.nationalite.databinding.NationalityItemBinding;

public class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final NationalityItemBinding ui;
    private CountryAdapter.OnItemClickListener listener;
    private ImageView ivPlanete;


    public CountryViewHolder(NationalityItemBinding ui) {
        super(ui.getRoot());
        this.ui = ui;
        itemView.setOnClickListener(this);
    }
    public void setCountry(CountryItem country) {
        ui.tvPays.setText(country.getCountryId());
        double arrondie = Math.round(country.getProbability()*100.0)/100.0;
        double pourcent = arrondie*100;
        ui.tvProba.setText(String.valueOf(pourcent)+"%");
    }

    public void setOnItemClickListener(CountryAdapter.OnItemClickListener l) {
        this.listener = l;
    }

    @Override public void onClick(View v) {
        if (listener != null)
            listener.onItemClick(getAdapterPosition());
    }

}
