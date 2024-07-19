package com.example.printer;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.widget.Button;

public class Canvas extends AppCompatActivity {
    private CustomDrawingView drawingView;
    private PrinterHelper printerHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas);
        SystemBarsUtils.styleSystemBars(this, android.R.color.black);

        drawingView = findViewById(R.id.drawingView);
        Button btnPrintCanvas = findViewById(R.id.btnPrintCanvas);
        Button btnBack = findViewById(R.id.btnBack);

        printerHelper = new PrinterHelper();
        printerHelper.initSunmiPrinterService(this);

        btnPrintCanvas.setOnClickListener(v -> {
            Bitmap bitmap = drawingView.getBitmap();
            printerHelper.printBitmap(bitmap, 0);
        });

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(this, PrinterManager.class);
            startActivity(intent);
            finish();
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        printerHelper.deInitSunmiPrinterService(this);
    }
}