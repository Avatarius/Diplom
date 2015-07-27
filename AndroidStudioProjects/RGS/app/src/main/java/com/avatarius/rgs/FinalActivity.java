package com.avatarius.rgs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Second User on 04.06.2015.
 */
public class FinalActivity extends Activity {
    TextView resultTextView;
    String fio, birthday, address, phone;
    String date, time, location, details;
    String result = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_layout);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        fio = getIntent().getStringExtra("fio");
        birthday = getIntent().getStringExtra("birthday");
        address = getIntent().getStringExtra("address");
        phone = getIntent().getStringExtra("phone");
        date = getIntent().getStringExtra("date");
        time  = getIntent().getStringExtra("time");
        location = getIntent().getStringExtra("location");
        details = getIntent().getStringExtra("details");
        result = getResultString();
        resultTextView.setText(result);

    }

    public void onClickSend(View view) {

        SimpleDateFormat format = new SimpleDateFormat("dd:MM:yyyy    HH:mm:ss");
        Date date = new Date();
        String currentDate = format.format(date);
        String[] emailAddress = {"avatarius93@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
        emailIntent.putExtra(Intent.EXTRA_TEXT, result);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Заявление на получение выплаты " + currentDate);
        emailIntent.setType("plain/text");
        startActivity(emailIntent);
        Toast.makeText(this, "Запрос отправлен", Toast.LENGTH_LONG).show();
    }

    public String getResultString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Ф.И.О: ");
        builder.append(fio + "\n");
        builder.append("Дата рождения: ");
        builder.append(birthday + "\n");
        builder.append("Адрес фактического проживания: ");
        builder.append(address + "\n");
        builder.append("Контактный телефон: ");
        builder.append(phone + "\n");
        builder.append("Дата происшествия: ");
        builder.append(date + "\n");
        builder.append("Время происшествия: ");
        builder.append(time + "\n");
        builder.append("Место происшествия: ");
        builder.append(location + "\n");
        builder.append("Детали происшествия: ");
        builder.append(details + "\n");
        return builder.toString();
    }
}
