package com.example.printer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PrinterText extends AppCompatActivity {

    private SunmiPrinterHelper sunmiPrinterHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_printer);

        Button btnPrintText = findViewById(R.id.btnPrintText);
        EditText text = findViewById(R.id.text);

        sunmiPrinterHelper = new SunmiPrinterHelper();
        sunmiPrinterHelper.initSunmiPrinterService(this);

        btnPrintText.setOnClickListener(v -> PrintText(text));
    }

    public void PrintText(EditText editText) {
        String textToPrint = editText.getText().toString();
        sunmiPrinterHelper.printText(textToPrint, 24f, false, false, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sunmiPrinterHelper.deInitSunmiPrinterService(this);
    }
}