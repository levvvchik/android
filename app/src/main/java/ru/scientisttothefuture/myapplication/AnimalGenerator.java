package ru.scientisttothefuture.myapplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalGenerator {

    private static final String[] animalNames = new String[]{"cat", "dog", "hamster", "bear", "butterfly"};
    private static final String[] images = new String[]{"https://cs9.pikabu.ru/post_img/big/2017/02/16/10/1487262267154872190.jpg",
            "http://img.scoop.it/GroGTPKlZ4COVytp24pJdoXXXL4j3HpexhjNOf_P3YmryPKwJ94QGRtDb3Sbc6KY",
            "https://storage.googleapis.com/replit/images/1509526663063_78cee07358a3fd43480ae7fa5b4d76e3.png",
            "https://yt3.ggpht.com/a-/AJLlDp13bM8yFuEE7HVlYHFt7zvZPSMWbGEz4OrxOw=s900-mo-c-c0xffffffff-rj-k-no",
            "http://comic-cons.xyz/wp-content/uploads/Star-Wars-avatar-icon-Ewok.png",
            "https://cdn.dribbble.com/users/588874/screenshots/2249423/dribbble_1x.png",
            "https://avatarko.ru/img/kartinka/32/Star_Wars_pistolet_31680.jpg",
            "http://weclipart.com/gimg/31A72F8B8986D00C/obiwan_kenobi_rots_by_kaal_jhyy.jpg"};
    private static final String[] locations = new String[]{"Krasnoyarsk","Singapore","London","Moscow","Machachkala"};

    private Random random = new Random();

    public Animal getAnimals() {
        final String animalName = animalNames[random.nextInt(animalNames.length)];
        final String location = locations[random.nextInt(locations.length)];
        final String image = images[random.nextInt(images.length)];

        return new Animal(animalName, location, image);
    }

    public List<Animal> getAnimals(final int count){
        List<Animal> animals = new ArrayList<>(count);
        for(int i=0; i < count; i++) {
            animals.add(getAnimals());
        }
        return animals;
    }
}
