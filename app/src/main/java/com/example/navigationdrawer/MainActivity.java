package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView=findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuMessage:
                        openFragment(new MessageFragment(),"Messgae panel is open");
                        break;

                    case R.id.menuArchivedMessage:
                        openFragment(new ArchivedMessageFragment(),"Archived Messgae panel is open");
                        break;

                    case R.id.menuNotification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new NotificationFragment()).commit();
                        Toast.makeText(getApplicationContext(), "Notification panel is open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menuProfile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new ProfileFragment()).commit();
                        Toast.makeText(getApplicationContext(), "Profile panel is open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menuChangePass:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new ChangePassFragment()).commit();
                        Toast.makeText(getApplicationContext(), "Change Password panel is open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menulogout:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new LogoutFragment()).commit();
                        Toast.makeText(getApplicationContext(), "Logout panel is open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }
                return true;
            }
        });

    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
    private void openFragment(Fragment fragment, String msg){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment).commit();
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}