package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.findFor;
import static com.leandog.puppies.view.ViewHelper.hide;

import java.util.List;

import android.app.ActionBar;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.leandog.puppies.R.id;
import com.leandog.puppies.R.layout;
import com.leandog.puppies.data.PuppiesLoader;
import com.leandog.puppies.data.Puppy;
import com.leandog.puppies.view.PuppyImageLoader;

public class PuppiesActivity extends Activity {

    private final PuppiesLoader puppiesLoader;
    private final PuppyImageLoader puppyImageLoader;

    public PuppiesActivity() {
        this(new PuppiesLoader(), new PuppyImageLoader());
    }

    public PuppiesActivity(PuppiesLoader puppiesLoader,PuppyImageLoader puppyImageLoader) {
        this.puppiesLoader = puppiesLoader;
        this.puppyImageLoader = puppyImageLoader;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_puppies);

        initializeActionBar();

        ListView thePuppies = findFor(this, id.the_puppies_list);
        thePuppies.setOnItemClickListener(new OnDisplayThePuppyTale(thePuppies));
        new AsyncPuppiesLoader(thePuppies).execute();
    }

    private void initializeActionBar() {
        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getActionBar().setCustomView(layout.happy_banner);
    }

    private final class OnDisplayThePuppyTale implements OnItemClickListener {
    	
        private final ListView thePuppies;

        private OnDisplayThePuppyTale(ListView thePuppies) {
            this.thePuppies = thePuppies;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final Intent theDetails = new Intent(PuppiesActivity.this, PuppyTaleActivity.class);
            theDetails.putExtra("thePuppy", thePuppyAt(position).toJson());
            startActivity(theDetails);
        }

        private Puppy thePuppyAt(int position) {
            return (Puppy) thePuppies.getItemAtPosition(position);
        }
    }

    private final class AsyncPuppiesLoader extends AsyncTask<Void, Void, List<Puppy>> {
        private final ListView thePuppies;

        private AsyncPuppiesLoader(ListView thePuppies) {
            this.thePuppies = thePuppies;
        }

        @Override
        protected List<Puppy> doInBackground(Void... params) {
            return puppiesLoader.load();
        }

        protected void onPostExecute(List<Puppy> puppies) {
            thePuppies.setAdapter(new PuppyAdapter(puppyImageLoader, PuppiesActivity.this, puppies));
            hide(PuppiesActivity.this, id.loading);
        }
    }

}
