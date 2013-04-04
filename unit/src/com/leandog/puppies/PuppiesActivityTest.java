package com.leandog.puppies;

import static com.leandog.puppies.test.Util.Matchers.*;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.leandog.puppies.R.id;
import com.leandog.puppies.data.PuppiesLoader;
import com.leandog.puppies.data.Puppy;
import com.leandog.puppies.test.PuppiesTestRunner;
import com.leandog.puppies.view.PuppyImageLoader;
import com.leandog.puppies.view.ViewHelper;

@RunWith(PuppiesTestRunner.class)
public class PuppiesActivityTest {
    
    private PuppiesActivity activity;
    
    @Mock PuppiesLoader puppiesLoader;
    @Mock PuppyImageLoader puppyImageLoader;

    @Before
    public void setUp() {
        activity = new PuppiesActivity(puppiesLoader, puppyImageLoader);
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
    
    @Test
    public void itDisplaysTheirGender() {
        setupActivityToFind(new Puppy("", "", "Female"));
        assertThat(textOf(thePuppyAt(0), id.gender), is("Female"));
    }
    
    @Test
    public void itDisplaysTheSummary() {
        setupActivityToFind(new Puppy() {{ setDescription("Expected description"); }});
        assertThat(textOf(thePuppyAt(0), id.summary), is("Expected description"));
    }
    
    @Test
    public void itDisplaysTheirBeautifulFace() {
        setupActivityToFind(new Puppy() {{ setImageUrl("sparky.png"); }});
        
        final ImageView theHeadshot = findFor(activity, id.headshot);
        verify(puppyImageLoader).bind(theHeadshot, "http://puppies.herokuapp.com/assets/sparky.png");
    }
    
    @Test
    public void itCanDisplayMoreDetails() {
        final Puppy sparky = new Puppy("Sparky");
        setupActivityToFind(sparky);
        
        clickOn(0);
        
        assertThat(activity, started(PuppyTaleActivity.class, "thePuppy", sparky.toJson()));
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

    private void clickOn(int whichPuppy) {
        thePuppies().getOnItemClickListener().onItemClick(null, null, whichPuppy, 0);
    }

}
