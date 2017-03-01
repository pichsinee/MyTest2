package apptest.alice.mytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private ListView listView;
    private int[] ints = new int[]{R.drawable.traffic_01, R.drawable.traffic_02,
            R.drawable.traffic_03, R.drawable.traffic_04, R.drawable.traffic_05,
            R.drawable.traffic_06, R.drawable.traffic_07, R.drawable.traffic_08,
            R.drawable.traffic_09, R.drawable.traffic_10, R.drawable.traffic_11,
            R.drawable.traffic_12, R.drawable.traffic_13, R.drawable.traffic_14,
            R.drawable.traffic_15, R.drawable.traffic_16, R.drawable.traffic_17,
            R.drawable.traffic_18, R.drawable.traffic_19, R.drawable.traffic_20};

    private String[] titleStrings, detailStrings, shortDetailStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial Listview
        listView = (ListView) findViewById(R.id.lstView);

        //Get value เอาค่าจาก XML ที่ไฟล์ my_content.xmlมาแสดงผล
        titleStrings = getResources().getStringArray(R.array.title);
        detailStrings = getResources().getStringArray(R.array.detail);

        //SubString detailStrings
        shortDetailStrings = new String[detailStrings.length];
        for (int i=0; i < detailStrings.length; i++) {
            shortDetailStrings[i] = detailStrings[i].substring(0, 30) + "...";
        }   //for

            //Create ListView
            MyAdapter myAdapter = new MyAdapter(MainActivity.this, ints, titleStrings, shortDetailStrings);
            listView.setAdapter(myAdapter);

            //Active when click ListView
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent intent = new Intent(MainActivity.this, Detail.class);
                    intent.putExtra("Title", titleStrings[i]);
                    intent.putExtra("Detail", detailStrings[i]);
                    intent.putExtra("Image", ints[i]);
                    startActivity(intent);
                }
            });

    }   // Main method

    public void clickAboutMe(View view) {

        Intent intent = new Intent(MainActivity.this, AboutMe.class);
        startActivity(intent);
    }   //method clickAboutMe

    public void clickMoreInfo(View view) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.dlt.go.th/th/dlt-knowledge/view.php?_did=111"));
        startActivity(intent);
    } //method clickMoreInfo

}   // Main Class
