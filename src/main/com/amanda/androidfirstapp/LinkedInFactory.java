package main.com.amanda.androidfirstapp;

import main.com.amanda.androidfirstapp.ILinkedIn;

public class LinkedInFactory {
	public static ILinkedIn getConnector() {
		return new SocialAuthLinkedIn();
	}

}
