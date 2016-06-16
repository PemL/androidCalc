package com.example.apps;

import android.app.Application;

public class Model extends Application {
	Calculator calc;
	public void onCreate() {
		super.onCreate();
		calc = new Calculator();
		
	}
	
	public Calculator getObserver(){
		return calc;
	}
	
	
}
