package controller;

import java.util.Timer;
import java.util.TimerTask;

public class Animation {
	private Timer timer;
	
	public Animation() {
		this.timer = new Timer();
		this.timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO paintComponent
			}
		}, 16);
	}
}
