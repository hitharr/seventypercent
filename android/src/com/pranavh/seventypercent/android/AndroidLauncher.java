/**
 * The AndroidLauncher class launches the game
 * @author Ashley Handoko, Pranav Harathi, Brandon Perry
 * Period: 3
 * Date: 5-26-15
 */


package com.pranavh.seventypercent.android;

//import statements
import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.pranavh.seventypercent.MyGdxGame;

public class AndroidLauncher extends AndroidApplication {
	
	/* Method called to activiate MyGdxGame
	*/

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new MyGdxGame(), config);
	}
}
