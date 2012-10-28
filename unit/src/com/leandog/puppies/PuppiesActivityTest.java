package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.findFor;
import static com.leandog.puppies.view.ViewHelper.textOf;
import static com.xtremelabs.robolectric.Robolectric.shadowOf;
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
import com.leandog.puppies.view.ViewHelper;

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
    
    @Test
    public void itListsThePuppies() {
        setupActivityToFind(new Puppy(), new Puppy());
        assertThat(thePuppies().getChildCount(), is(2));
    }
    
    @Test
    public void itDisplaysTheirName() {
        setupActivityToFind(new Puppy("Sparky"));
        assertThat(textOf(thePuppyAt(0), id.name), is("Sparky"));
    }
    
    @Test
    public void itDisplaysTheirBreed() {
        setupActivityToFind(new Puppy("", "Terrier"));
        assertThat(textOf(thePuppyAt(0), id.breed), is("Terrier"));
    }

    private void createActivity() {
        shadowOf(activity).create();
    }

    private void setupActivityToFind(final Puppy...puppies) {
        when(puppiesLoader.load())
            .thenReturn(Arrays.asList(puppies));
        createActivity();
    }

    private ListView thePuppies() {
        return ViewHelper.<ListView>findFor(activity, id.the_puppies_list);
    }

    private View thePuppyAt(int index) {
        return thePuppies().getChildAt(index);
    }

}
