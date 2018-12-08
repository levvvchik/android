package ru.scientisttothefuture.myapplication;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface AnimalDao {
    @Query("SELECT * FROM animals")
    List<Animal> getAll();

    @Query("SELECT * FROM animals WHERE id = :id")
    Animal getById(long id);

    @Insert
    long insertAnimal(Animal animal);
}