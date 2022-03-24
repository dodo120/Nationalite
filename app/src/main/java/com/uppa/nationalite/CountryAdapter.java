package com.uppa.nationalite;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.uppa.nationalite.databinding.NationalityItemBinding;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {

    private final List<CountryItem> liste;

    CountryAdapter(List<CountryItem> liste) {
        this.liste = liste;
    }

    @Override
    public int getItemCount()
    {
        return liste.size();
    }

    @Override
    public CountryViewHolder  onCreateViewHolder(ViewGroup parent, int viewType)
    {
        NationalityItemBinding binding =  NationalityItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent, false);
        return new CountryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position)
    {
        CountryItem country = liste.get(position);
        holder.setCountry(country);
        holder.setOnItemClickListener(this.listener);
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener l) {  this.listener = l;
    }

}
