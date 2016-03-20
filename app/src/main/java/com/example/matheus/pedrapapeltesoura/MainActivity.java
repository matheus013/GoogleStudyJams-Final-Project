package com.example.matheus.pedrapapeltesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int pointsPlayer = 0, pointsComp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gameStone(View view) {
        game(0);
    }

    public void gameScissor(View view) {
        game(2);
    }

    public void gamePaper(View view) {
        game(1);
    }

    private void game(int player) {
        TextView points_player = (TextView) findViewById(R.id.pointsYou);
        TextView points_comp = (TextView) findViewById(R.id.pointsComp);
        Random random = new Random();
        int comp = random.nextInt(3);
        if (player != comp) {
            if (win(player, comp))
                points_player.setText(String.valueOf(++pointsPlayer));
            else
                points_comp.setText(String.valueOf(++pointsComp));
        }
    }

    private int get(int op) {
        switch (op) {
            case 0:
                return R.drawable.pedra;
            case 1:
                return R.drawable.papel;
            case 2:
                return R.drawable.tesoura;
        }
        return -1;
    }

    private boolean win(int player, int comp) {

        ImageView turn_player = (ImageView) findViewById(R.id.player);
        ImageView turn_comp = (ImageView) findViewById(R.id.comp);
        turn_comp.setImageDrawable(getDrawable(get(comp)));
        turn_player.setImageDrawable(getDrawable(get(player)));


        return (player == 0 && comp == 2) || (player == 1 && comp == 0) || (player == 2 && comp == 1);

    }
}
