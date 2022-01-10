package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

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
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new MessageFragment()).commit();
                        Toast.makeText(getApplicationContext(), "Message panel is open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menuArchivedMessage:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new ArchivedMessageFragment()).commit();
                        Toast.makeText(getApplicationContext(), "Archived Message panel is open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
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
}