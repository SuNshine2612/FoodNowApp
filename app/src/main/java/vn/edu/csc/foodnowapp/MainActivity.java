package vn.edu.csc.foodnowapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);

        //Tab Home, Order and Profile with icon & text !
        tabLayout.addTab(tabLayout.newTab()
                                    .setIcon(R.drawable.icon_home)
                                    .setText(R.string.home)
        );
        tabLayout.addTab(tabLayout.newTab()
                                .setIcon(R.drawable.ic_order)
                                .setText(R.string.order)
        );
        tabLayout.addTab(tabLayout.newTab()
                                .setIcon(R.drawable.icon_profile)
                                .setText(R.string.profile)
        );

        //Set default content tab layout
        displayContent(0);

        //Event Click Tab
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Toast.makeText(MainActivity.this, tabLayout.getSelectedTabPosition(), Toast.LENGTH_SHORT).show();
                displayContent(tabLayout.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void displayContent(int tabPosition)
    {
        // Init fragment !
        Fragment fragment = null;

        switch (tabPosition)
        {
            case 0: // Home
                fragment = HomeFragment.newInstance();
                break;
            case 1: // Order
                fragment = new OrderFragment();
                break;
            case 2: // Profile
                fragment = new ProfileFragment();
                break;
        }

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contentFragment, fragment);
        fragmentTransaction.commit();
    }
}
