package ru.scientisttothefuture.myapplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalGenerator {

    private static final String[] animalNames = new String[]{"cat", "dog", "hamster", "bear", "butterfly"};
    private static final String[] images = new String[]{"https://www.moya-planeta.ru/files/holder/75/fe/75fee17f9ea815b8129e7cafa3271952.png",
            "https://www.moya-planeta.ru/files/holder/40/5c/405c37827effd8662980ba221d5ab91c.png",
            "https://www.moya-planeta.ru/files/holder/b7/79/b779d1345477b9580c57a4b0e7cc4331.png",
            "https://www.moya-planeta.ru/files/holder/32/ac/32ac1e89a9f82d22d1d5881e484e2a6c.png",
            "https://www.moya-planeta.ru/files/holder/e6/96/e696ab2a92b6ce7cc7375c3c5d653e13.png",
            "https://www.moya-planeta.ru/files/holder/fc/ee/fcee76b86d180072bff688eeda9d6181.png",
            "https://www.moya-planeta.ru/files/holder/16/e9/16e976a236b51c03ee822047a4435618.png",
            "https://www.moya-planeta.ru/files/holder/fc/ee/fcee76b86d180072bff688eeda9d6181.png"};
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
    public String getAvatarLink(){
        return images[random.nextInt(images.length)];
    }
}
