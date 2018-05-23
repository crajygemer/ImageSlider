package com.aaperteam.imageslider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomAdapter extends PagerAdapter {

    private int[] imgs = {
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.grapes,
            R.drawable.jackfruit,
            R.drawable.mango
    };

    private LayoutInflater inflater;
    private Context ctx;

    public CustomAdapter(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view ==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.swipe,container,false);
        ImageView img = (ImageView)view.findViewById(R.id.imageView);
        TextView tv = (TextView)view.findViewById(R.id.textView);
        img.setImageResource(imgs[position]);
        tv.setText("Image: "+position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.invalidate();
    }
}
