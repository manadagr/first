package test.com.amanda.androidfirstapp;

import main.com.amanda.androidfirstapp.ILinkedIn;
import main.com.amanda.androidfirstapp.ILinkedInProfile;
import main.com.amanda.androidfirstapp.LinkedInFactory;

import org.junit.Test;

import junit.framework.TestCase;

public class TestGetProfileCallsGetProfile extends TestCase {
	
	@Test
	public void testFactoryReturnsConnectorInterface() {
		assertTrue( LinkedInFactory.getConnector() instanceof ILinkedIn);
	}
	
	@Test
	public void testConnectorGetProfileReturnsIProfile() {
		assertTrue("Not an instance of ILinkedInProfile", LinkedInFactory.getConnector().getProfile(null) instanceof ILinkedInProfile);
	}
	
}
