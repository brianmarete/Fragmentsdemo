package com.brianmarete.fragmentsdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class NumberListAdapter extends RecyclerView.Adapter<NumberListAdapter.NumberListViewHolder>{

    int[] numbers;

    public NumberListAdapter(int[] numbers) {
        this.numbers = numbers;
    }

    @NonNull
    @Override
    public NumberListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new NumberListViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull NumberListViewHolder holder, int position) {
        holder.number.setText(String.valueOf(numbers[position]));
    }

    @Override
    public int getItemCount() {
        return numbers.length;
    }

    class NumberListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView number;
        Context context;

        public NumberListViewHolder(@NonNull View itemView, Context context) {
            super(itemView);

            number = itemView.findViewById(R.id.tv_number);
            this.context = context;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            NumberFragment numberFragment = NumberFragment.newInstance(numbers[getAdapterPosition()]);

            AppCompatActivity activity = (AppCompatActivity) itemView.getContext();

            FragmentTransaction ft = activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.numberFragment, numberFragment)
                    .addToBackStack(null);

            ft.commit();

        }
    }
}
