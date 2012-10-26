package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.findFor;
import static com.leandog.puppies.view.ViewHelper.textOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.leandog.puppies.R.id;
import com.leandog.puppies.data.PuppiesLoader;
import com.leandog.puppies.data.Puppy;
import com.leandog.puppies.test.PuppiesTestRunner;

@RunWith(PuppiesTestRunner.class)
public class PuppiesActivityTest {
    private PuppiesActivity activity;
    
    @Mock
    private PuppiesLoader puppiesLoader;
    
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
    public void itKnowsWhenTheyHaveLoaded() {
        createActivity();
        
        final ProgressBar theProgress = findFor(activity, id.loading);
        assertThat(theProgress.getVisibility(), is(View.GONE));
    }
    
    @Test
    public void itListsThePuppies() {
        thePuppiesAre(new Puppy(), new Puppy());
        createActivity();
        
        assertThat(thePuppies().getChildCount(), is(2));
    }
    
    @Test
    public void itDisplaysTheName() {
        thePuppiesAre(new Puppy("Sparky"));
        createActivity();
        
        final View thePuppy = thePuppies().getChildAt(0);
        assertThat(textOf(thePuppy, id.name), is("Sparky"));
    }

    private void thePuppiesAre(final Puppy...puppies) {
        when(puppiesLoader.load())
            .thenReturn(Arrays.asList(puppies));
    }

    private void createActivity() {
        activity.onCreate(null);
    }

    private ListView thePuppies() {
        final ListView thePuppies = findFor(activity, id.the_puppies_list);
        return thePuppies;
    }

}
