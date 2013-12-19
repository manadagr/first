package main.com.amanda.androidfirstapp;

import android.app.Activity;

public class SocialAuthLinkedIn implements ILinkedIn{

	@Override
	public ILinkedInProfile getProfile(Activity activity) {
		return new SocialAuthLinkedInProfile(activity);
	}

}
