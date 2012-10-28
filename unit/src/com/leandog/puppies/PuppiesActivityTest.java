package com.leandog.puppies;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.leandog.puppies.data.PuppiesLoader;
import com.leandog.puppies.test.PuppiesTestRunner;

@RunWith(PuppiesTestRunner.class)
public class PuppiesActivityTest {
    
    @Mock PuppiesLoader puppiesLoader;
    
    @Test
    public void itRetrievesThePuppies() {
        PuppiesActivity activity = new PuppiesActivity(puppiesLoader);
        activity.onCreate(null);
        verify(puppiesLoader).load();
    }

}
