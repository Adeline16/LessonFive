package pro.mitapp.lessonfive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        transaction.replace(R.id.fragment_container, HomeFragment.newInstance("value 1", "value 2")).commit();
                        item.setChecked(true);
                        break;
                    case R.id.navigation_list:
                        transaction.replace(R.id.fragment_container, ListFragment.newInstance("value 1", "value 2")).commit();
                        item.setChecked(true);
                        break;
                    case R.id.navigation_profile:
                        transaction.replace(R.id.fragment_container, ProfileFragment.newInstance("value 1", "value 2")).commit();
                        item.setChecked(true);
                        break;
                }
                return false;
            }
        });
    }
}