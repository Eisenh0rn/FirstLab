package com.example.dmitry.s;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RadioActivity extends Activity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup radioGroup;
    ImageView imgView;

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        imgView = (ImageView) findViewById(R.id.imageView1);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);

        final ImageView.ScaleType[] types = ImageView.ScaleType.values();
        RadioButton button;

        for (final ImageView.ScaleType type : types)
        {
            button = new RadioButton(this);
            button.setText(type.toString());
           // button.setOnClickListener(this);

            radioGroup.addView(button);
        }

        radioGroup.setOnCheckedChangeListener(this);

        View backbutton = (Button)findViewById(R.id.backbutton);
        backbutton.setOnClickListener(
        	new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
}
//
//    @Override
//    public void onClick(View view)
//    {
//        if (view instanceof RadioButton)
//        {
//            final String typeString = ((RadioButton) view).getText().toString();
//            final ImageView.ScaleType type = ImageView.ScaleType.valueOf(typeString);
//
//            imgView.setScaleType(type);
//        }
//
//    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId)
    {
       final RadioButton button = (RadioButton) group.findViewById(checkedId);
       final String typeString = button.getText().toString();
       final ImageView.ScaleType type = ImageView.ScaleType.valueOf(typeString);

       imgView.setScaleType(type);
    }
}
