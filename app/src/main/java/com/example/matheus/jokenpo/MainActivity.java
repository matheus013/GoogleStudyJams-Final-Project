package com.example.matheus.jokenpo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private int player;
    private int pointsPlayer = 0, pointsComp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void gameStone(View view) {
        TextView points_player = (TextView) findViewById(R.id.pointsYou);
        TextView points_comp = (TextView) findViewById(R.id.pointsComp);
        Random random = new Random();
        int comp = random.nextInt(3);
        player = 0;
        if (player != comp) {
            if (win(player, comp))
                points_player.setText(String.valueOf(++pointsPlayer));
            else
                points_comp.setText(String.valueOf(++pointsComp));
        }
    }

    public void gameScissor(View view) {
        TextView points_player = (TextView) findViewById(R.id.pointsYou);
        TextView points_comp = (TextView) findViewById(R.id.pointsComp);
        Random random = new Random();
        int comp = random.nextInt(3);
        player = 2;
        if (player != comp) {
            if (win(player, comp))
                points_player.setText(String.valueOf(++pointsPlayer));
            else
                points_comp.setText(String.valueOf(++pointsComp));
        }
    }

    public void gamePaper(View view) {
        TextView points_player = (TextView) findViewById(R.id.pointsYou);
        TextView points_comp = (TextView) findViewById(R.id.pointsComp);
        Random random = new Random();
        int comp = random.nextInt(3);
        player = 1;
        if (player != comp) {
            if (win(player, comp))
                points_player.setText(String.valueOf(++pointsPlayer));
            else
                points_comp.setText(String.valueOf(++pointsComp));
        }
    }

    private String get(int op) {
        switch (op) {
            case 0:
                return "Pedra";
            case 1:
                return "Papel";
            case 2:
                return "Tesoura";
        }
        return "";
    }

    private boolean win(int player, int comp) {

        TextView turn_player = (TextView) findViewById(R.id.player);
        TextView turn_comp = (TextView) findViewById(R.id.comp);
        turn_comp.setText(get(comp));
        turn_player.setText(get(player));

        System.out.println(player + " x " + comp);

        if (player == 0 && comp == 2) return true;
        if (player == 1 && comp == 0) return true;
        if (player == 2 && comp == 1) return true;

        return false;
    }
}
