package bu.jirayut.student.butraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by student on 11/14/2015.
 */
public class MyAdapter extends BaseAdapter{

    // Explicit
    private Context objContext;
    private String[] titleStrings;
    private int[] iconInts;

    public MyAdapter(Context objContext, String[] titleStrings, int[] iconInts) {
        this.objContext = objContext;
        this.titleStrings = titleStrings;
        this.iconInts = iconInts;
    }   //Constructor

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View objView1 = objLayoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        //Setup Title
        TextView titleTextView = (TextView) objView1.findViewById(R.id.textView2);
        titleTextView.setText(titleStrings[i]);

        //Setup Icon
        ImageView IconImageView = (ImageView) objView1.findViewById(R.id.imageView);
        IconImageView.setImageResource(iconInts[i]);

        return objView1;
    }
}   // main Class
