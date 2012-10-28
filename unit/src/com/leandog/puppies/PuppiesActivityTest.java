package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.findFor;
import static com.xtremelabs.robolectric.Robolectric.shadowOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import android.view.View;
import android.widget.ProgressBar;

import com.leandog.puppies.R.id;
import com.leandog.puppies.data.PuppiesLoader;
import com.leandog.puppies.test.PuppiesTestRunner;

@RunWith(PuppiesTestRunner.class)
public class PuppiesActivityTest {
    
    private PuppiesActivity activity;
    
    @Mock PuppiesLoader puppiesLoader;

    @Before
    public void setUp() {
        activity = new PuppiesActivity(puppiesLoader);
    }
    
    @Test
    public void itRetrievesThePuppies() {
        createActivity();
        verify(puppiesLoader).load();
    }
    
    @Test
    public void itKnowsWhenTheyHaveBeenLoaded() {
        createActivity();
        
        final ProgressBar theProgress = findFor(activity, id.loading);
        assertThat(theProgress.getVisibility(), is(View.GONE));
    }

    private void createActivity() {
        shadowOf(activity).create();
    }

}
