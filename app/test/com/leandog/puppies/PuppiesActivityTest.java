package com.leandog.puppies;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import com.leandog.puppies.data.PuppyLoader;
import com.leandog.puppies.test.PuppiesTestRunner;

@RunWith(PuppiesTestRunner.class)
// @Config(manifest = "../../../../../puppies_app/AndroidManifest.xml")
public class PuppiesActivityTest {

	@Mock private PuppyLoader puppiesLoader;
	private ActivityController<PuppiesActivity> controller;
	private PuppiesActivity activity;

	@Before
	public void setup() {
		controller = Robolectric.buildActivity(PuppiesActivity.class);
		activity = controller.get();		
		activity.setPuppyLoader(puppiesLoader);		
	}
	
	@Test
	public void itRetrievesThePuppies() {
		controller.create();
		verify(puppiesLoader).load();
	}
	
}
