package main.com.amanda.androidfirstapp;

import org.brickred.socialauth.Profile;
import org.brickred.socialauth.android.SocialAuthAdapter;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import main.com.amanda.androidfirstapp.R;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GetProfileActivity extends RoboActivity {
	@InjectView(R.id.profileId) TextView textView;
	Profile profileMap;
	
	private static LinkedInFactory factory;
	
	@Override
	protected void onCreate(Bundle bundle) {
		
		super.onCreate(bundle);
		Intent intent = getIntent();
		
//		TextView profileView = new TextView(this);
//		profileView.setText(R.string.profile_results);
		
		setContentView(R.layout.get_profile_activity_main);
		
		ILinkedInProfile profile = LinkedInFactory.getConnector().getProfile(this);
		
		profile.getProfile(textView);
		
		//setContentView(profileView);
	}

}
