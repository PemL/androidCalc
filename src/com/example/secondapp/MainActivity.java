package com.example.secondapp;

import java.util.Observable;
import java.util.Observer;

import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.apps.Model;


public class MainActivity extends ActionBarActivity implements Observer {
private Model app;
public static String EXTRA_MESSAGE = "com.example.secondapp.MESSAGE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		app = (Model) getApplication();
		app.getObserver().addObserver(this);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void sendMessage(View view){
		String t1 = ((Button)view).getText().toString();
		EditText editText = (EditText)findViewById(R.id.result);
		editText.setText(editText.getText().toString() + t1);
	}
	
	public void calculate(View view){
		EditText editText = (EditText)findViewById(R.id.result);
		app.getObserver().calc(editText.getText().toString());
	}
	
	public void update(Observable observable, Object data){
		EditText editText = (EditText)findViewById(R.id.result);
		editText.setText(app.getObserver().getText());
	}
	
	public void clear(View view) {
		EditText editText = (EditText) findViewById(R.id.result);
		editText.getText().clear();
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}


}
