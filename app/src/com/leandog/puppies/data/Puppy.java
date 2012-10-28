package com.leandog.puppies.data;

public class Puppy {
    
    private Info puppy = new Info();

    public Puppy() {
        this("");
    }

    public Puppy(final String name) {
        puppy.name = name;
    }

    public Puppy(final String name, final String breed) {
        this(name);
        puppy.breed = breed;
    }

    public Puppy(final String name, final String breed, final String gender) {
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
        return String.format("http://puppies.herokuapp.com/assets/%s", puppy.image_url);
    }

    private class Info {
        public String name;
        public String breed;
        public String gender;
        public String image_url;
    }
}
