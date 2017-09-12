package com.example.datepikertimepiker;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
//import android.support.annotation.RequiresPermission;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends Activity implements OnClickListener {
	EditText et_dt_picker,et_tm_picker;
	//@RequiresApi(api = Build.VERSION_CODES.N)

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewsById();
	}
	public void onClick(View v) {
        if(v == et_dt_picker) {
            showDatePicker();
        }
        if(v == et_tm_picker) {
            showTimePicker();
        }
    }
	private void findViewsById() {
        et_dt_picker = (EditText) findViewById(R.id.btn_dt_picker);
        et_tm_picker = (EditText) findViewById(R.id.btn_tm_picker);
        et_dt_picker.setInputType(InputType.TYPE_NULL);
        et_tm_picker.setInputType(InputType.TYPE_NULL);
        et_dt_picker.requestFocus();
        et_dt_picker.setOnClickListener(this);
        et_tm_picker.setOnClickListener(this);
		// TODO Auto-generated method stub
		
	}

	private void showTimePicker() {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
			@Override
			public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                et_tm_picker.setText( selectedHour + ":" + selectedMinute);
				// TODO Auto-generated method stub
				
			}
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
		// TODO Auto-generated method stub
		
	}
	private void showDatePicker() {
        Calendar mcurrentDate=Calendar.getInstance();
        final int mYear=mcurrentDate.get(Calendar.YEAR);
        final int mMonth=mcurrentDate.get(Calendar.MONTH);
        final int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePicker=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                // TODO Auto-generated method stub
                selectedmonth=selectedmonth+1;
                et_dt_picker.setText(selectedday+"/"+selectedmonth+"/"+selectedyear);
            }
        },mYear, mMonth, mDay);
        mDatePicker.setTitle("Select date");
        mDatePicker.show();
	}
}
