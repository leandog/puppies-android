package com.leandog.puppies.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class PuppiesLoader {

    public List<Puppy> load() {
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://puppies.herokuapp.com/puppies.json").openStream()));
            
            final StringBuilder content = new StringBuilder();
            String line;
            
            while(null != (line = reader.readLine())) {
                content.append(line);
            }
            
            return Arrays.asList(new Gson().fromJson(content.toString(), Puppy[].class));
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        
        return new ArrayList<Puppy>();
    }

}
