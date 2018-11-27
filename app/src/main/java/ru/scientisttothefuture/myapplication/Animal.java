package ru.scientisttothefuture.myapplication;

import java.util.Objects;

public class Animal {
    private long id;
    private String name;//имя животного
    private String location;//место
    private String path;//картинка

    public Animal(String name, String location, String path) {
        this(0,name, location, path);
    }
    public Animal(long id, String name, String location, String path) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.path = path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id &&
                Objects.equals(name, animal.name) &&
                Objects.equals(location, animal.location) &&
                Objects.equals(path, animal.path);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, location, path);
    }
}
