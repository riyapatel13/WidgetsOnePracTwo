package com.example.a10016322.widgetsonepractwo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class WidgetActivity extends AppCompatActivity {

    Switch switch1, switch2, switch3;
    EditText verify, database;
    SeekBar fontSize;
    TextView color, ver, data, size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        switch1 = (Switch)(findViewById(R.id.switch1_id));
        switch2 = (Switch)(findViewById(R.id.switch2_id));
        switch3 = (Switch)(findViewById(R.id.switch3_id));
        verify = (EditText)(findViewById(R.id.verifyText_id));
        database = (EditText)(findViewById(R.id.dataText_id));
        fontSize = (SeekBar)(findViewById(R.id.seekBar_id));
        color = (TextView)(findViewById(R.id.colorText_id));
        ver = (TextView)(findViewById(R.id.textView_id));
        data = (TextView)(findViewById(R.id.textView2_id));
        size = (TextView)(findViewById(R.id.textView3_id));

        color.setTextColor(Color.BLACK);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if((isChecked) && switch2.isChecked() && switch3.isChecked())
                    color.setTextColor(Color.BLUE);
                else if ((isChecked)&& switch3.isChecked())
                    color.setTextColor(Color.RED);
                else if(switch3.isChecked() && switch2.isChecked()==false)
                    color.setTextColor(Color.GREEN);
                else
                    color.setTextColor(Color.BLACK);
            }
        });

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if((isChecked) && switch1.isChecked() && switch3.isChecked())
                    color.setTextColor(Color.BLUE);
                else if (switch1.isChecked() && switch3.isChecked())
                    color.setTextColor(Color.RED);
                else if(switch3.isChecked()&& isChecked==false)
                    color.setTextColor(Color.GREEN);
                else
                    color.setTextColor(Color.BLACK);
            }
        });

        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if((isChecked) && switch1.isChecked() && switch2.isChecked())
                    color.setTextColor(Color.BLUE);
                else if ((isChecked)&& switch1.isChecked())
                    color.setTextColor(Color.RED);
                else if (isChecked && switch2.isChecked()==false)
                    color.setTextColor(Color.GREEN);
                else
                    color.setTextColor(Color.BLACK);
            }
        });

        verify.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {ver.setText("Not Verified");}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                if((text.contains("@")) && (text.contains(".com")) && (text.indexOf("@")<text.indexOf(".com")))
                    ver.setText("Verified");
            }
        });

        final ArrayList<String> emails = new ArrayList<String>();
        emails.add("email1@email.com");
        emails.add("email2@email.com");
        emails.add("email3@email.com");
        emails.add("hi@email.com");

        database.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {data.setText("Not in Database");}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                for (int i=0; i< emails.size(); i++)
                {
                    if(s.toString().equals(emails.get(i)))
                        data.setText("In Database");
                }
            }
        });


        fontSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int prevProgress = 0;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress>prevProgress)
                {
                   size.setWidth(size.getWidth()+1);
                    prevProgress = progress;
                }
                else if (prevProgress>progress)
                {
                    size.setWidth(size.getWidth()-1);
                    prevProgress = progress;
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
