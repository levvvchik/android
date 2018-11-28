package ru.scientisttothefuture.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    List<Animal> animals;

    public AnimalAdapter(List<Animal> animals) {
        this.animals = animals;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        holder.bind(animals.get(position));
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

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

        public void bind(Animal animal) {
            tvName.setText(animal.getName());
            tvLocation.setText(animal.getLocation());
            Picasso.get().load(animal.getPath())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .fit()
                    .centerCrop()
                    .into(ivNameAnimalAvatar);

        }
    }
}
