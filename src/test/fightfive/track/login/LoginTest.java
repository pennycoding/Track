package test.fightfive.track.login;

import com.fightfive.track.App;
import com.fightfive.track.login.Login;
import com.fightfive.track.login.User;

import android.test.AndroidTestCase;

public class LoginTest extends AndroidTestCase {

	public void testGetToken() {
		User user = new User();
		user.setUsername("07130701");
		user.setPassword("130701");
		Login.getToken(user);

		assertEquals("0dbd67e6c0f9a6ca0aec127d6c344d05", App.token);
	}
}
