/**
 * The TitleActivity Class creates the title screen of the app
 * @author Ashley Handoko, Pranav Harathi, Brandon Perry
 * Period: 3
 * Date: 5-26-15
 */

package com.pranavh.seventypercent.android;

//import statements
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.*;
import android.graphics.*;
import android.view.*;
import android.content.Intent;


public class TitleActivity extends Activity {

    private static final String TAG = "statusMessages";

    /*Adds the font typeface*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        TextView txt = (TextView) findViewById(R.id.custom_font);
        Typeface font = Typeface.createFromAsset(getAssets(), "KlinicSlabBold.otf");
        txt.setTypeface(font);
        // prints out onCreate when event with TAG is fired
        Log.i(TAG, "onCreate");
    }

   /* Overrides and call the onStart superclass*/
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    /*Overrides and calls the onResume superclass*/
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

  /*  Overrides and call the onPause superclass*/
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    /*   Overrides and call the onStop superclass*/
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    /*   Overrides and call the onRestart superclass*/
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

     /*   Overrides and call the onDestroy superclass*/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

     /*   Overrides and call the onSaveInstanceState superclass
     *    @param outState bundle to call super
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

     /*   Overrides and call the onRestoreInstanceState superclass
     *    @param savedInstanceState Bundle to call super class  
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }

    /*Override onCreateOptionsMenu class, inflates the menu and adds items to the action bar if it is present.
    * @param menu Meny to inflate
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        getMenuInflater().inflate(R.menu.menu_title, menu);
        return true;
    }

    /*Override onOptionsItemSelected class, handles action bar clicks
    * @param item MenuItem to retrieve id
    */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /*Starts the activity
    * @param view View to be used
    */
    public void startGame(View view) {
        Intent intent = new Intent(this, AndroidLauncher.class);
        startActivity(intent);
    }
}
