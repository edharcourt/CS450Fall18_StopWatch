package edu.stlawu.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    // Define variable for our views
    private TextView tv_count = null;
    private Button bt_start = null;
    private Button bt_stop =null;
    private int count = 0;
    private Timer t = null;
    private Counter ctr = null;  // TimerTask

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize views
        this.tv_count = findViewById(R.id.tv_count);
        this.bt_start = findViewById(R.id.bt_start);
        this.bt_stop = findViewById(R.id.bt_stop);

        this.bt_start.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 t.scheduleAtFixedRate(ctr, 0, 1000);
             }
            });
    }

    @Override
    protected void onStart() {
        super.onStart();

        this.ctr = new Counter();
        this.t = new Timer();


    }

    class Counter extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.count++;
            MainActivity.this.tv_count.setText(
                    Integer.toString(count));
        }
    }
}
