package com.example.dailodemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class game extends AppCompatActivity implements View.OnClickListener {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    String player1, player2;
    String msg = "x";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        Register(this);

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_layout);
        dialog.setCancelable(false);
        dialog.show();


        Button reset = dialog.findViewById(R.id.resetbt);
        Button submit = dialog.findViewById(R.id.submitbt);

        EditText ed_player1 = dialog.findViewById(R.id.e1);
        EditText ed_player2 = dialog.findViewById(R.id.e2);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_player1.setText("");
                ed_player2.setText("");

                ed_player1.requestFocus();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1 = ed_player1.getText().toString();
                player2 = ed_player2.getText().toString();

                if (player1.length() == 0 || player2.length() == 0) {
                    Toast.makeText(game.this, "player name are compulsary", Toast.LENGTH_SHORT).show();
                } else {
                    dialog.dismiss();
                }

            }
        });
    }

    public void stop(View view) {
        Register(null);
    }

    public void reset(View view) {
        restart();
    }

    void restart() {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        Register(this);

        msg = "x";
    }

    void Register(View.OnClickListener temp) {
        b1.setOnClickListener(temp);
        b2.setOnClickListener(temp);
        b3.setOnClickListener(temp);
        b4.setOnClickListener(temp);
        b5.setOnClickListener(temp);
        b6.setOnClickListener(temp);
        b7.setOnClickListener(temp);
        b8.setOnClickListener(temp);
        b9.setOnClickListener(temp);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        b.setText(msg);
        if (msg.equalsIgnoreCase("x")) {
            msg = "O";
        } else
            msg = "x";

        b.setOnClickListener(null);
        boolean status = check();
        if (status == true) {
            String player = "";
            if (msg.equalsIgnoreCase("x")) {
                player = player2;
            } else {
                player = player1;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("india ka taka tak");
            builder.setMessage(player + "you're won congratulations \n do you want to restart(yes/no) \n do you want to close(close) ");
            builder.setIcon(R.drawable.ic_launcher_foreground);
            builder.setPositiveButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Register(null);
                }
            });
            builder.setNegativeButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    restart();
                }
            });
            builder.setNeutralButton("close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setCancelable(false);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }


    boolean check() {
        String a = b1.getText().toString();
        String b = b2.getText().toString();
        String c = b3.getText().toString();
        String d = b4.getText().toString();
        String e = b5.getText().toString();
        String f = b6.getText().toString();
        String g = b7.getText().toString();
        String h = b8.getText().toString();
        String i = b9.getText().toString();

        if (a.length() > 0 && a.equals(b) && a.equals(c)) {
            return true;
        } else if (d.length() > 0 && d.equals(e) && d.equals(f)) {
            return true;
        } else if (g.length() > 0 && g.equals(h) && g.equals(i)) {
            return true;
        } else if (a.length() > 0 && a.equals(d) && a.equals(g)) {
            return true;
        } else if (b.length() > 0 && b.equals(e) && b.equals(h)) {
            return true;
        } else if (c.length() > 0 && e.equals(c) && a.equals(i)) {
            return true;
        } else if (a.length() > 0 && a.equals(e) && a.equals(i)) {
            return true;
        } else if (c.length() > 0 && e.equals(c) && e.equals(g)) {
            return true;
        } else {
            return false;
        }
    }
}

/*
        int id = v.getId();
        if (id == R.id.b1) {
            b1.setText("x");
            Toast.makeText(this, "a", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.b2) {
            b2.setText("0");
            Toast.makeText(this, "b", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.b3) {
            b3.setText("x");
            Toast.makeText(this, "c", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.b4) {
            b4.setText("0");
            Toast.makeText(this, "d", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.b5) {
            b5.setText("x");
            Toast.makeText(this, "e", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.b6) {
            Toast.makeText(this, "f", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.b7) {
            Toast.makeText(this, "g", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.b8) {
            Toast.makeText(this, "h", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.b9) {
            Toast.makeText(this, "i", Toast.LENGTH_SHORT).show();
        }


    }
}
?
 */

