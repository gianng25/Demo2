package com.example.nhom4_w5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhom4_w5.adapter.CatAdapter;
import com.example.nhom4_w5.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CatAdapter.CatItemListener {
    private RecyclerView recyclerView;
    private CatAdapter adapter;

    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.reView);
        adapter=new CatAdapter(getList());
        adapter.setCatItemListener(this);
        GridLayoutManager manager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                String name="absds";
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }
    private List<Cat> getList(){
        List<Cat> list=new ArrayList<>();
        list.add(new Cat(R.drawable.cat1,"Meo con 1"));
        list.add(new Cat(R.drawable.cat2,"Meo con 2"));
        list.add(new Cat(R.drawable.cat3,"Meo con 3"));
        list.add(new Cat(R.drawable.cat4,"Meo con 4"));
        list.add(new Cat(R.drawable.cat5,"Meo con 5"));
        list.add(new Cat(R.drawable.cat6,"Meo con 6"));
        return list;
    }


    @Override
    public void onItemClick(View view, int position) {
        Cat c=getList().get(position);
        Toast.makeText(this,c.getName(),Toast.LENGTH_SHORT).show();
    }
}