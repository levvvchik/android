package ru.scientisttothefuture.myapplication;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AnimalAdapter adapter;
    private AnimalGenerator generator = new AnimalGenerator();
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initList();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            final Intent intent = AddAnimal.getStartIntent(this);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        updateList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
    private void updateList() {
        List<Animal> animals = AppDatabase.getInstance(this).animalDao().getAll();
        adapter.update(animals);
    }

    private void initList(){

        RecyclerView rvAnimals = findViewById(R.id.rvAnimal);
        rvAnimals.setHasFixedSize(true);
        rvAnimals.setLayoutManager(new LinearLayoutManager(this));
        List<Animal> animals = AppDatabase.getInstance(this).animalDao().getAll();
        adapter = new AnimalAdapter(animals,item -> {
            final Intent intent = AnimalActivity_details.getStartIntent(this, item.getId());
            startActivity(intent);

        });
        rvAnimals.setAdapter(adapter);
    }
}
