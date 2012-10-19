package com.leandog.puppies.data;

public class Puppy {

    private class Info {
        private String name;
        public String image_url;
    }
    
    private Info puppy = new Info();

    public Puppy(final String name) {
        puppy.name = name;
    }

    public Puppy() {
    }

    public String getName() {
        return puppy.name;
    }
    
    public void setImageUrl(final String imageUrl) {
        puppy.image_url = imageUrl;
    }

    public String getImageUrl() {
        return String.format("http://puppies.herokuapp.com/assets/%s", puppy.image_url);
    }

}
