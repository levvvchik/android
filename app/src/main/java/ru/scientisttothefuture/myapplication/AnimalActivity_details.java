package ru.scientisttothefuture.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AnimalActivity_details extends AppCompatActivity {

    private static final String EXTRA_ANIMAL_ID = "ru.scientisttothefuture.myapplication.extras.EXTRA_ANIMAL_ID";



    public static Intent getStartIntent(Context context, long animalId) {
        return new Intent(context, AnimalActivity_details.class).putExtra(EXTRA_ANIMAL_ID, animalId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);
        initUi();
    }

    private void initUi() {
        ImageView ivAvatar = findViewById(R.id.ivAvatar);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvLocation = findViewById(R.id.tvLocation);

        final long personId = getIntent().getLongExtra(EXTRA_ANIMAL_ID, 0);
        final Animal animal = AppDatabase.getInstance(this).animalDao().getById(personId);
        Picasso.get().load(animal.getPath())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fit()
                .centerCrop()
                .into(ivAvatar);
        tvName.setText(animal.getName());
        tvLocation.setText(animal.getLocation());


    }

}
