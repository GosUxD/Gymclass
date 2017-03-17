package classgym.example.com.gymclass.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nineoldandroids.view.ViewHelper;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import classgym.example.com.gymclass.R;
import classgym.example.com.gymclass.view.fragment.ProductTourFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class ProductTourActivity extends AppCompatActivity {

    static final int NUM_PAGES = 3;

    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    private boolean isOpaque = true;
    private Button mLoginButton;
    private SlidingUpPanelLayout mSlidingPane;
    private TextView mSignInText;
    private TextView mSignInText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_tutorial);

        mSlidingPane = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        mSignInText = (TextView) findViewById(R.id.intro_sign_up_button);
        mSignInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegisterActivity();
            }
        });
        mSignInText2 = (TextView) findViewById(R.id.slide_up_panel_sign_up);
        mSignInText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegisterActivity();
            }
        });

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setPageTransformer(true, new CrossfadePageTransformer());
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position == NUM_PAGES - 2 && positionOffset > 0) {
                    if (isOpaque) {
                        pager.setBackgroundColor(Color.TRANSPARENT);
                        isOpaque = false;
                    }
                } else {
                    if (!isOpaque) {
                        pager.setBackgroundColor(getResources().getColor(R.color.primary_material_light));
                        isOpaque = true;
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(pager, true);

        mLoginButton = (Button) findViewById(R.id.intro_login_button);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlidingPane.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
            }
        });


    }



    private void startRegisterActivity() {
        Intent intent = new Intent(ProductTourActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pager != null) {
            pager.clearOnPageChangeListeners();
        }
    }


    private void endTutorial() {

//        SharedPrefHelper.getInstance(ProductTourActivity.this).putShouldShowIntro(false);
//        Intent loginIntent = new Intent(ProductTourActivity.this, LoginActivity.class);
//        startActivity(loginIntent);
//        overridePendingTransition(R.anim.right_in, R.anim.left_out);
//        finish();
    }

    @Override
    public void onBackPressed() {
        if (pager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            pager.setCurrentItem(pager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ProductTourFragment tp = null;
            switch (position) {
                case 0:
                    tp = ProductTourFragment.newInstance(R.layout.welcome_fragment5);
                    break;
                case 1:
                    tp = ProductTourFragment.newInstance(R.layout.welcome_fragment1);
                    break;
                case 2:
                    tp = ProductTourFragment.newInstance(R.layout.welcome_fragment2);
                    break;
                case 3:
                    tp = ProductTourFragment.newInstance(R.layout.welcome_fragment4);
                    break;
                case 4:
                    tp = ProductTourFragment.newInstance(R.layout.welcome_fragment3);
                    break;


            }

            return tp;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public class CrossfadePageTransformer implements ViewPager.PageTransformer {

        @Override
        public void transformPage(View page, float position) {
            int pageWidth = page.getWidth();

            View backgroundView = page.findViewById(R.id.welcome_fragment);
            View text_head = page.findViewById(R.id.heading);
            View text_content = page.findViewById(R.id.content);
            View object1 = page.findViewById(R.id.a000);
            View object2 = page.findViewById(R.id.a001);
            View object3 = page.findViewById(R.id.a002);
            View object4 = page.findViewById(R.id.a003);
            View object5 = page.findViewById(R.id.a004);
            View object6 = page.findViewById(R.id.a005);
            View object7 = page.findViewById(R.id.a006);
            View object8 = page.findViewById(R.id.a008);
            View object10 = page.findViewById(R.id.a011);
            View object11 = page.findViewById(R.id.a007);
            View object20 = page.findViewById(R.id.a20);
            View object21 = page.findViewById(R.id.a21);


            if (0 <= position && position < 1) {
                ViewHelper.setTranslationX(page, pageWidth * -position);
            }
            if (-1 < position && position < 0) {
                ViewHelper.setTranslationX(page, pageWidth * -position);
            }

            if (position <= -1.0f || position >= 1.0f) {
            } else if (position == 0.0f) {
            } else {
                if (backgroundView != null) {
                    ViewHelper.setAlpha(backgroundView, 1.0f - Math.abs(position));

                }

                if (text_head != null) {
                    ViewHelper.setTranslationX(text_head, pageWidth * position);
                    ViewHelper.setAlpha(text_head, 1.0f - Math.abs(position));
                }

                if (text_content != null) {
                    ViewHelper.setTranslationX(text_content, pageWidth * position);
                    ViewHelper.setAlpha(text_content, 1.0f - Math.abs(position));
                }

                if (object20 != null) {
                    ViewHelper.setTranslationX(object20, pageWidth * position);
                }

                if (object21 != null) {
                    ViewHelper.setTranslationX(object21, pageWidth * position);
                }

                if (object1 != null) {
                    ViewHelper.setTranslationX(object1, pageWidth * position);
                }

                // parallax effect
                if (object2 != null) {
                    ViewHelper.setTranslationX(object2, pageWidth * position);
                }

                if (object4 != null) {
                    ViewHelper.setTranslationX(object4, pageWidth / 2 * position);
                }
                if (object5 != null) {
                    ViewHelper.setTranslationX(object5, pageWidth / 2 * position);
                }
                if (object6 != null) {
                    ViewHelper.setTranslationX(object6, pageWidth / 2 * position);
                }
                if (object7 != null) {
                    ViewHelper.setTranslationX(object7, pageWidth / 2 * position);
                }

                if (object8 != null) {
                    ViewHelper.setTranslationX(object8, (float) (pageWidth / 1.5 * position));
                }

                /*if (object9 != null) {
                    ViewHelper.setTranslationX(object9, (float) (pageWidth / 2 * position));
                }*/

                if (object10 != null) {
                    ViewHelper.setTranslationX(object10, pageWidth / 2 * position);
                }

                if (object11 != null) {
                    ViewHelper.setTranslationX(object11, (float) (pageWidth / 1.2 * position));
                }

                /*if (object12 != null) {
                    ViewHelper.setTranslationX(object12, (float) (pageWidth / 1.3 * position));
                }*/

                /*if (object13 != null) {
                    ViewHelper.setTranslationX(object13, (float) (pageWidth / 1.8 * position));
                }*/

                if (object3 != null) {
                    ViewHelper.setTranslationX(object3, (float) (pageWidth / 1.2 * position));
                }
            }
        }
    }
}