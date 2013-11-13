package com.example.dmitry.s;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener {


     List<ItemSpinner> ListSpinner;
     Spinner spScaleType;
     ImageView imgView;
     Button backbutton;

    public class ItemSpinner {
        Object tag;
        String name;

        public ItemSpinner(Object _tag, String _name)
        {
            this.tag = _tag;
            this.name = _name;
        }

        public String toString()
        {
            return this.name;
        }
    }

    private void setScaleType(){
        for (ImageView.ScaleType stValue : ImageView.ScaleType.values()) {
            ItemSpinner item = new ItemSpinner(stValue, stValue.toString());
            this.ListSpinner.add(item);
        }

        ArrayAdapter adapterSelectDetail = new ArrayAdapter(this, android.R.layout.simple_spinner_item, this.ListSpinner);
        adapterSelectDetail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spScaleType.setAdapter(adapterSelectDetail);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        this.ListSpinner = new ArrayList<ItemSpinner>();
        this.imgView = (ImageView)findViewById(R.id.imageView1);
        this.spScaleType = (Spinner)findViewById(R.id.spScaleType);
        this.backbutton = (Button)findViewById(R.id.backbutton);

        this.setScaleType();
        this.spScaleType.setOnItemSelectedListener(this);
        this.backbutton.setOnClickListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.spScaleType){
            ItemSpinner item = (ItemSpinner)this.spScaleType.getSelectedItem();
            ImageView.ScaleType st = (ImageView.ScaleType)item.tag;
            this.imgView.setScaleType(st);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.backbutton)
            finish();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub

    }
}
