package main.com.amanda.androidfirstapp;

import org.brickred.socialauth.Profile;
import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthError;
import org.brickred.socialauth.android.SocialAuthListener;
import org.brickred.socialauth.android.SocialAuthAdapter.Provider;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SocialAuthLinkedInProfile implements ILinkedInProfile{
	SocialAuthAdapter adapter;
	Profile profileMap;
	Activity myActivity;
	TextView myView;
	
	
	SocialAuthLinkedInProfile(Activity activity) {
		myActivity = activity;
		myView = (TextView) myActivity.findViewById(R.id.profileId);
	}

	@Override
	public void getProfile(View view) {
		
		doAuthAndGetProfile(view);
		
	}
	
	public void doAuthAndGetProfile(View view) {
		adapter = new SocialAuthAdapter(new ProfileResponseListener());
		adapter.addProvider(Provider.LINKEDIN, R.drawable.linkedin);
		adapter.authorize(myActivity, Provider.LINKEDIN);
	}
	
	
	private class ProfileResponseListener implements DialogListener {

		@Override
		public void onBack() {
			Log.d("AndroidFirstApp", "Dialog Closed by pressing Back Key");
			
		}

		@Override
		public void onCancel() {
			Log.d("AndroidFirstApp", "Cancelled");
			
		}

		@Override
		public void onComplete(Bundle responseValues) {
			// Get the provider
			//String providerName = responseValues.getString(SocialAuthAdapter.PROVIDER);
			
			adapter.getUserProfileAsync(new ProfileDataListener());

		}

		@Override
		public void onError(SocialAuthError error) {
			Log.d("SocialAuthError", "Error");
			error.printStackTrace();
			
		}
		
	}
	
	// To receive the profile response after authentication
		private final class ProfileDataListener implements SocialAuthListener<Profile> {

			@Override
			public void onExecute(String provider, Profile profile) {

				Log.d("Custom-UI", "Receiving Data");
				
				myView.setText(profile.getFirstName() + " " + profile.getLastName());
				myView.setText(profile.getLocation());

			}

			@Override
			public void onError(SocialAuthError e) {

			}
		}

}
