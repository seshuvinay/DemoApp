package demo.vinay.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by VINAY on 27-01-2016.
 */
public class SlideShowActivity extends AppCompatActivity {
    ViewPager pager;
    private LayoutInflater mLayoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slideshow);
        pager = (ViewPager) findViewById(R.id.viewpager);
        mLayoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        pager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                View mainView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

                ImageView view = (ImageView) mainView.findViewById(R.id.pager_image);
                switch (position) {
                    case 0:
                        view.setImageDrawable(getResources().getDrawable(R.drawable.slide1));
                        break;
                    case 1:
                        view.setImageDrawable(getResources().getDrawable(R.drawable.slide2));

                        break;
                    case 2:
                        view.setImageDrawable(getResources().getDrawable(R.drawable.slide3));

                        break;
                    case 3:
                        view.setImageDrawable(getResources().getDrawable(R.drawable.slide4));
                        view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(SlideShowActivity.this, HomeActivity.class));

                            }
                        });
                        break;
                }
                container.addView(mainView);

                return mainView;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == ((LinearLayout) object);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((LinearLayout) object);
            }
        });

    }
}
