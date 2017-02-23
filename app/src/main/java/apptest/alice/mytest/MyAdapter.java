package apptest.alice.mytest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by aom on 22/2/2560.
 */

public class MyAdapter extends BaseAdapter {

    //Explicit
    private Context context;
    private int[] ints;
    private String[] titleStrings, detailStrings;

    public MyAdapter(Context context, int[] ints, String[] titleStrings, String[] detailStrings) {
        this.context = context;
        this.ints = ints;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;



    }   //class MyAdapter

    @Override
    public int getCount() { //นับจำนวนข้อมูลที่รับมาว่ามีกี่ข้อมุล จากนั้นส่งต่อไป method getView()
        return ints.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {    //นำข้อมูลที่ได้จาก mrthod getCount() มาแสดงผลบนหน้าแอป

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        //Initial view ผูก view กับตัวแปร
        ImageView imageView = (ImageView) view1.findViewById(R.id.imageView);
        TextView titleTextView = (TextView) view1.findViewById(R.id.txtShowTitle);
        TextView detailTextView = (TextView) view1.findViewById(R.id.txtShowDetail);

        //Show view นำข้อมูลแสดงผลบนแอป
        imageView.setImageResource(ints[i]);
        titleTextView.setText(titleStrings[i]);
        detailTextView.setText(detailStrings[i]);

        return view1;
    }
}   //Main Class
