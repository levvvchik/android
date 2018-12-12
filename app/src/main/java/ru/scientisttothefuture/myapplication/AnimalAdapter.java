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
    private OnItemClickListener itemClickListener;

    List<Animal> animals;

    public AnimalAdapter(List<Animal> animals, OnItemClickListener itemClickListener) {
        this.animals = animals;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        holder.bind(animals.get(position), itemClickListener);
    }
    public void update(List<Animal> animals){
        this.animals.clear();
        this.animals.addAll(animals);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(Animal item);
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

        public void bind(Animal animal, final OnItemClickListener itemClickListener) {

            itemView.setOnClickListener(v -> itemClickListener.onItemClick(animal));

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
