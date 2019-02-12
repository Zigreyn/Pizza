package com.example.pizza;

import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void onClickDone(View view) {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator),
                getString(R.string.text_snackbar),
                Snackbar.LENGTH_SHORT);

        snackbar.setAction(R.string.undo_snackbar, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(OrderActivity.this,
                        getString(R.string.undone_toast),Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        snackbar.show();
    }
}
