package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.findFor;
import static com.leandog.puppies.view.ViewHelper.hide;
import static com.leandog.puppies.view.ViewHelper.setText;

import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.leandog.puppies.R.id;
import com.leandog.puppies.R.layout;
import com.leandog.puppies.data.PuppiesLoader;
import com.leandog.puppies.data.Puppy;

public class PuppiesActivity extends Activity {

    private final PuppiesLoader puppiesLoader;

    public PuppiesActivity() {
        this(new PuppiesLoader());
    }

    public PuppiesActivity(PuppiesLoader puppiesLoader) {
        this.puppiesLoader = puppiesLoader;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_puppies);

        initializeActionBar();

        final ListView thePuppies = findFor(this, id.the_puppies_list);
        new AsyncPuppiesLoader(thePuppies).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_puppies, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeActionBar() {
        final ActionBar theActionBar = getActionBar();
        theActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        theActionBar.setCustomView(layout.happy_banner);
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

        protected void onPostExecute(java.util.List<Puppy> puppies) {
            thePuppies.setAdapter(new PuppyAdapter(PuppiesActivity.this, puppies));
            hide(PuppiesActivity.this, id.loading);
        }
    }

    private class PuppyAdapter extends ArrayAdapter<Puppy> {

        private final List<Puppy> puppies;

        public PuppyAdapter(Context context, final List<Puppy> puppies) {
            super(context, layout.puppy_item, puppies);
            this.puppies = puppies;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View theView = convertView;

            if (theView == null) {
                LayoutInflater inflater = (LayoutInflater) getApplication().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                theView = inflater.inflate(layout.puppy_item, null);
            }

            final Puppy thePuppy = puppies.get(position);
            setText(theView, id.name, thePuppy.getName());

            return theView;
        }

    }

}
