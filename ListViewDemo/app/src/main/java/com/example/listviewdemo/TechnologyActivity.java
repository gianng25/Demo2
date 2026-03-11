package com.example.listviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listviewdemo.model.Technology;
import com.example.listviewdemo.model.TechnologyAdapter;

public class TechnologyActivity extends AppCompatActivity {
    private ListView listView;
    TechnologyAdapter adapter;
    private Technology[] list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_technology);
        listView=findViewById(R.id.lview);
        initData();
        adapter=new TechnologyAdapter(this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                for (int i=0;i<listView.getAdapter().getCount();i++){
                    listView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                }
                listView.getChildAt(position).setBackgroundColor(Color.YELLOW);
                Technology t=adapter.getItem(position);
                Toast.makeText(getApplicationContext(),t.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        Integer[] imgs={R.drawable.img,R.drawable.img_1,R.drawable.img_2};
        String[] names={"Facebook","YouTube","Map"};
        String[] subs={"SUB Facebook","SUB YouTube","SUB Map"};
        String[] descs={"Facebook describe","YouTube describe","Map describe"};
        list=new Technology[imgs.length];
        for(int i=0;i<list.length;i++){
            list[i]=new Technology(imgs[i],names[i],subs[i],descs[i]);
        }
    }
}