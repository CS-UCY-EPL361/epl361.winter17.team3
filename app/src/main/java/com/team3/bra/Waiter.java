package com.team3.bra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Waiter extends Activity {
    ArrayAdapter<String> adapter;
    ArrayList<String> listOrders =new ArrayList<String>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.waiter_layout);

            listOrders.add("<New Order>");
            for(int i=0;i<19;i++){
                listOrders.add("Table "+i+"\t"+i+":00");
            }
            adapter=new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    listOrders);

            ListView lv=(ListView) findViewById(R.id.listOrders);
            lv.setAdapter(adapter);


            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {
                    if(position==0){
                        addItems();
                    }else {
                        Intent intent = new Intent(Waiter.this, Order.class);
                        startActivity(intent);
                    }
                }
            });
    }
    public void backClicked(View v){
        finish();
    }

    public void addItems() {
        adapter.add("new order");
        adapter.notifyDataSetChanged();
    }
}
