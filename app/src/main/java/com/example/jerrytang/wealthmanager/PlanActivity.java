package com.example.jerrytang.wealthmanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

public class PlanActivity extends AppCompatActivity {
    private static int[] itemIds = {R.id.item_10, R.id.item_20, R.id.item_30, R.id.item_40};
    private long wealthValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //set value
        wealthValue = getIntent().getLongExtra("wealth_value", 0L);
        //refreshItems
        refreshItems();
    }

    private void refreshItems() {
        refreshItem(4);
        refreshItem(3);
        refreshItem(2);
        refreshItem(1);
    }

    private void refreshItem(int index) {
        TextView textView = (TextView) findViewById(itemIds[index -1]);
        String content = textView.getText().toString();

        String valueOfItem = String.valueOf(wealthValue * (index * 0.1));
        content = content + valueOfItem.substring(0, (valueOfItem.lastIndexOf(".") > 0) ? valueOfItem.lastIndexOf(".") : valueOfItem.length() -1);
        textView.setText(content);
    }

}
