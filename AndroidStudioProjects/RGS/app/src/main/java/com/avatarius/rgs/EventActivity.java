package com.avatarius.rgs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Second User on 04.06.2015.
 */
public class EventActivity extends Activity {
    EditText dateEditText, timeEditText, locationEditText, detailsEditText;
    String fio, birthday, address, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_layout);
        dateEditText = (EditText) findViewById(R.id.dataEditText);
        timeEditText = (EditText) findViewById(R.id.timeEditText);
        locationEditText = (EditText) findViewById(R.id.locationEditText);
        detailsEditText = (EditText) findViewById(R.id.detailsEditText);
        fio = getIntent().getStringExtra("fio");
        birthday = getIntent().getStringExtra("birthday");
        address = getIntent().getStringExtra("address");
        phone = getIntent().getStringExtra("phone");
    }

    public void onClickNext(View view) {
        if (checkIfEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Поля пусты");
            builder.setMessage("Заполните поля");
            builder.setPositiveButton("OK", null);
            builder.show();
        } else {
            Intent intent = new Intent(this, FinalActivity.class);
            intent.putExtra("fio", fio);
            intent.putExtra("birthday", birthday);
            intent.putExtra("address", address);
            intent.putExtra("phone", phone);
            intent.putExtra("date", dateEditText.getText().toString());
            intent.putExtra("time", timeEditText.getText().toString());
            intent.putExtra("location", locationEditText.getText().toString());
            intent.putExtra("details", detailsEditText.getText().toString());
            startActivity(intent);
        }
    }


    private boolean checkIfEmpty() {
        if (dateEditText.getText().toString().length() == 0 ||
                timeEditText.getText().toString().length() == 0 ||
                locationEditText.getText().toString().length() == 0 ||
                detailsEditText.getText().toString().length() == 0) {
            return true;
        }

        return false;
    }
}
