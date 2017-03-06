package apptest.alice.mytest;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AboutMe extends AppCompatActivity {

    //Explicit
    MediaPlayer mediaPlayer;
    int soundID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        //Toast onClick
        final ImageView clickImageView = (ImageView) findViewById(R.id.imvMyPic);
        clickImageView.setOnClickListener(new View.OnClickListener() {   //ในวงเล็บพิมพ์ OnClik... กด enter จะ override method onClick มาให้
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Hello! My name is Alice",Toast.LENGTH_SHORT).show();

                //Show sound01 when click image
                soundID = R.raw.sound01;
                playSound(soundID);
            }
        });

        //Toast onLongClick
        ImageView longClickImageView1 = (ImageView) findViewById(R.id.imvMyPic);
        longClickImageView1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(getApplicationContext(),"Thanks guys!\nHope you like the MyFirstApp!",Toast.LENGTH_LONG).show();

                //Show sound02 when longClick image
                soundID = R.raw.sound02;
                playSound(soundID);

                //ค่าจะเป็น True เมื่อใช้งาน onLongClick และเป็น False เมื่อไม่ใช้งาน
                // ดังนั้น การกำหนดค่าที่จะ Return ใน onLongClick นั้นมีผลกับ onClick ด้วย โดยที่เมื่อเป็น False จะทำงานซ้อนกันทั้ง onClick และ onLongClick แต่ถ้าเมื่อเป็น True จะทำให้ onClick ทำงานไม่ซ้อนกันนั่นเอง
                return true;
            }
        });

        //Facebook onClick
        TextView facebookTextView = (TextView) findViewById(R.id.txtFacebook);
        facebookTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                facebookIntent.setData(Uri.parse("https://www.facebook.com/Aj.Aom"));
                startActivity(facebookIntent);
            }
        });

        //Phone onClick
        TextView phoneTextView = (TextView) findViewById(R.id.txtPhone);
        phoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:022445000"));
                startActivity(phoneIntent);
            }
        });

    }   //Main method

    private void playSound(int id) {
        if (mediaPlayer != null) {  //ตรวจสอบว่ามี obj. mediaPlayer เล่นอยู่หรือไม่
            mediaPlayer.stop();     //ถ้ามี ให้หยุดเสียงที่เล่น
            mediaPlayer.release();  //คืน resource ที่ mediaPlayer เดิมให้กับระบบ
        }

        mediaPlayer = MediaPlayer.create(getApplicationContext(), id);  //สร้าง obj. ที่ต้องการเล่นเสียง
        mediaPlayer.start();    //เริ่มเล่นเสียง
    }

    public void clickBack(View view) {
        finish();
    }

}   //Main Class
