package apptest.alice.mytest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler myHandler = new Handler();
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent goMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goMain);
                // close this activity
                finish();
            }
        }, 3000);
    }
}
