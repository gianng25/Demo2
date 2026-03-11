package com.example.demo2;

import static android.graphics.Color.RED;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class DateTimeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et,ed;
    private ListView lView;
    private Button bt;
    private TextView tv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_date_time);
        et=findViewById(R.id.eTime);
        ed=findViewById(R.id.eDate);
        et.setOnClickListener(this);
        ed.setOnClickListener(this);
        lView=findViewById(R.id.listview);
        tv=findViewById(R.id.tv);
        registerForContextMenu(tv);
        String[] ar={"Android","Java","Python"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.item);
        lView.setAdapter(adapter);
        bt=findViewById(R.id.bt);
        registerForContextMenu(bt);
    }
    public void onClick(View view){
        if(view==et){
            Calendar c= Calendar.getInstance();
            int hh=c.get(Calendar.HOUR_OF_DAY);
            int mm=c.get(Calendar.MINUTE);
            TimePickerDialog timedialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int h, int m) {
                    et.setText(h+":"+m);
                }
            },hh,mm,true);
            timedialog.show();
        }
        if(view==ed){
            Calendar c=Calendar.getInstance();
            int y=c.get(Calendar.YEAR);
            int m=c.get(Calendar.MONTH);
            int d=c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int yy, int mm, int dd) {
                    ed.setText(dd+"/"+(mm+1)+"/"+yy);

                }
            },y,m,d);
            dialog.show();
        }
        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item=parent.getItemAtPosition(position).toString();
                et.setText(item);
            }
        });
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId()==R.id.memail){
//            lView.setVisibility(View.VISIBLE);
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.bt_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mRed) {
            tv.setTextColor(Color.RED);
        }
        if(item.getItemId()==R.id.mBlue) {
            tv.setTextColor(Color.BLUE);
        }
        if(item.getItemId()==R.id.mGreen) {
            tv.setTextColor(Color.GREEN);
        }
        return super.onContextItemSelected(item);
    }
}