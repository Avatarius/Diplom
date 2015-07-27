package com.avatarius.rgs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class PersonActivity extends Activity {

    EditText fioEditText, birthdayEditText, addressEditText, phoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_layout);
        fioEditText = (EditText) findViewById(R.id.fioEditText);
        birthdayEditText = (EditText) findViewById(R.id.birthdayEditText);
        addressEditText = (EditText) findViewById(R.id.addressEditText);
        phoneEditText = (EditText) findViewById(R.id.phoneEditText);



    }

    public void onClickNext(View view) {

        if (checkIfEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Поля пусты");
            builder.setMessage("Заполните поля");
            builder.setPositiveButton("OK", null);
            builder.show();
        } else {
            Intent intent = new Intent(this, EventActivity.class);
            intent.putExtra("fio", fioEditText.getText().toString());
            intent.putExtra("birthday", birthdayEditText.getText().toString());
            intent.putExtra("address", addressEditText.getText().toString());
            intent.putExtra("phone", phoneEditText.getText().toString());
            startActivity(intent);
        }


    }

    private boolean checkIfEmpty() {
        if (fioEditText.getText().toString().length() == 0 ||
                birthdayEditText.getText().toString().length() == 0 ||
                addressEditText.getText().toString().length() == 0 ||
                phoneEditText.getText().toString().length() == 0) {
            return true;

        }

        return false;

    }
}
