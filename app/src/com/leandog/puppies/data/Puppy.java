package com.leandog.puppies.data;

public class Puppy {

    private class Info {
        String name;
        public String breed;
        public String gender;
        public String image_url;
    }
    
    private Info puppy = new Info();

    public Puppy() {
        this("");
    }

    public Puppy(String name) {
        puppy.name = name;
    }

    public Puppy(String name, String breed) {
        this(name);
        puppy.breed = breed;
    }

    public Puppy(String name, String breed, String gender) {
        this(name, breed);
        puppy.gender = gender;
    }

    public String getName() {
        return puppy.name;
    }

    public String getBreed() {
        return puppy.breed;
    }

    public String getGender() {
        return puppy.gender;
    }
    
    public void setImageUrl(final String imageUrl) {
        puppy.image_url = imageUrl;
    }

    public String getImageUrl() {
        return String.format("http://10.0.1.4:3000/assets/%s", puppy.image_url);
    }

}
