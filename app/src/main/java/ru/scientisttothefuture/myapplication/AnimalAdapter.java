package ru.scientisttothefuture.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalAdapter extends RecyclerView.Adapter {

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {

        ImageView ivNameAnimalAvatar;
        TextView tvName;
        TextView tvLocation;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            ivNameAnimalAvatar = itemView.findViewById(R.id.ivAnimalAvatar);
            tvName = itemView.findViewById(R.id.tvName);
            tvLocation = itemView.findViewById(R.id.tvLocation);
        }
        public void  bind(Animal animal){
            tvName.setText(animal.getName());
            tvLocation(animal.getLocation());

        }
    }
}
