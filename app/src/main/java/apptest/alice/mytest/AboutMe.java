package apptest.alice.mytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AboutMe extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        //Toast onClick
        final ImageView clickImageView = (ImageView) findViewById(R.id.imvMyPic);
        clickImageView.setOnClickListener(new View.OnClickListener() {   //ในวงเล็บพิมพ์ OnClik... กด enter จะ override method onClick มาให้
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Hello!My name is Alice",Toast.LENGTH_SHORT).show();
            }
        });

        //Toast onLongClick
        ImageView longClickImageView1 = (ImageView) findViewById(R.id.imvMyPic);
        longClickImageView1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(getApplicationContext(),"Thanks guys!\nHope you like the MyFirstApp!",Toast.LENGTH_LONG).show();
                return true;
            }
        });

    }   //Main method

    public void clickBack(View view) {
        finish();
    }

}   //Main Class
