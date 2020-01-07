package com.iv.imageview;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton rbimg1, rbimg2, rbimg3;
    ImageView imgView;
    AlertDialog.Builder builder;
    Drawable imgname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbimg1 = findViewById(R.id.rbimg1);
        rbimg2 = findViewById(R.id.rbimg2);
        rbimg3 = findViewById(R.id.rbimg3);

        imgView = findViewById(R.id.imgView);

        rbimg1.setOnClickListener(this);
        rbimg2.setOnClickListener(this);
        rbimg3.setOnClickListener(this);
        builder = new AlertDialog.Builder(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rbimg1:
                imgname = ContextCompat.getDrawable(this, R.drawable.pikachu1);
                dialogmsg();
                break;

            case R.id.rbimg2:
                imgname = ContextCompat.getDrawable(this, R.drawable.piakchu2);
                dialogmsg();
                break;

            case R.id.rbimg3:
                imgname = ContextCompat.getDrawable(this, R.drawable.sombra);
                dialogmsg();
                break;

        }
        AlertDialog alert = builder.create();
        alert.setTitle("Display picture");
        alert.show();
    }

    private void dialogmsg() {
        builder.setMessage("Do you want to show the picture")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        imgView.setImageDrawable(imgname);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
    }
}


