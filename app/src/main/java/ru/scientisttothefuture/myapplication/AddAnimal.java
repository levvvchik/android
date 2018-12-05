package ru.scientisttothefuture.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddAnimal extends AppCompatActivity {

    private ImageView ivAvatar;
    private TextInputLayout tilName;
    private TextInputLayout tilLocation;
    private AnimalGenerator generator = new AnimalGenerator();
    private String avatarLink = "";

    public static Intent getStartIntent(Context context) {
        return new Intent(context, AddAnimal.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);

        ivAvatar = findViewById(R.id.ivAvatar);
        tilName = findViewById(R.id.tilName);
        tilLocation = findViewById(R.id.tilLocation);

        loadImage(generator.getAvatarLink());
        ivAvatar.setOnClickListener(view -> loadImage(generator.getAvatarLink()));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Animal animal = generator.getAnimals();
            loadImage(animal.getPath());
            tilName.getEditText().setText(animal.getName());
            tilLocation.getEditText().setText(animal.getLocation());

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_animal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionAdd) {
            String name = tilName.getEditText().getText().toString();
            String location = tilLocation.getEditText().getText().toString();
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm"); // e.g. 24.10.2018 15:46
            Animal animal = new Animal(name, avatarLink, location);
            AppDatabase.getInstance(this).personDao().insertPerson(animal);
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void loadImage(String link) {
        avatarLink = link;
        Picasso.get().load(avatarLink)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fit()
                .centerCrop()
                .into(ivAvatar);
    }
}
