package com.example.printer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class Canvas extends AppCompatActivity {
    private static final int REQUEST_CODE_PICK_IMAGE = 100;
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
        Button btnBitmap = findViewById(R.id.btnBitmap);

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

        btnBitmap.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        printerHelper.deInitSunmiPrinterService(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                printerHelper.printBitmap(bitmap, 0);
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Failed to load image", Toast.LENGTH_SHORT).show();
            }
        }
    }
}