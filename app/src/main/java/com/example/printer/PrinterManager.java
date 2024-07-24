package com.example.printer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PrinterManager extends AppCompatActivity {
    private PrinterHelper printerHelper;
    private EditText textToPrint,textQR,textBarCode;
    private TextView printerStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.printer_manager);

        SystemBarsUtils.styleSystemBars(this, android.R.color.black);

        textToPrint = findViewById(R.id.text);
        textQR = findViewById(R.id.textQRCode);
        textBarCode = findViewById(R.id.textBarCode);
        Button btnPrintText = findViewById(R.id.btnPrintText);
        Button btnPrintBarcode = findViewById(R.id.btnPrintBarcode);
        Button btnPrintQR = findViewById(R.id.btnPrintQR);
        Button btnCutPaper = findViewById(R.id.btnCutPaper);
        Button btnShowStatus = findViewById(R.id.btnShowStatus);
        Button btnDrawCanvas = findViewById(R.id.btnCanvas);
        printerStatus = findViewById(R.id.printerStatus);

        printerHelper = new PrinterHelper();
        printerHelper.initSunmiPrinterService(this);

        btnPrintText.setOnClickListener(v -> printText());
        btnPrintBarcode.setOnClickListener(v -> printBarcode());
        btnPrintQR.setOnClickListener(v -> printQR());
        btnCutPaper.setOnClickListener(v -> cutPaper());
        btnShowStatus.setOnClickListener(v -> showPrinterStatus());
        btnDrawCanvas.setOnClickListener(v -> startCanvas());
    }

    private void printText() {
        String text = textToPrint.getText().toString();
        printerHelper.printText(text, 24f, false, false, null);
        printerHelper.feedPaper();
    }

    private void printBarcode() {
        String barcodeData = textBarCode.getText().toString();
        printerHelper.printBarCode(barcodeData, 8, 90, 2, 2);
        printerHelper.feedPaper();
    }

    private void printQR() {
        String qrData = textQR.getText().toString();
        printerHelper.printQr(qrData, 8, 0);
        printerHelper.feedPaper();
    }

    private void cutPaper() {
        printerHelper.cutpaper();
    }

    private void showPrinterStatus() {
        String status = printerHelper.getPrinterStatus();
        printerStatus.setText(status);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        printerHelper.deInitSunmiPrinterService(this);
    }

    protected void startCanvas(){
        Intent intent = new Intent(this, Canvas.class);
        startActivity(intent);
        finish();
    }

}
