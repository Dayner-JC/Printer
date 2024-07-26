**Printer**

Properties*

    NoSunmiPrinter: Indicates that no Sunmi printer was found.
    CheckSunmiPrinter: Indicates that the Sunmi printer is being checked.
    FoundSunmiPrinter: Indicates that a Sunmi printer was found.
    LostSunmiPrinter: Indicates that the Sunmi printer was lost.
    sunmiPrinter: Current state of the Sunmi printer.
    sunmiPrinterService: Instance of the Sunmi printer service.
    innerPrinterCallback: Callback to handle connection and disconnection of the Sunmi printer service.

Methods*
initSunmiPrinterService


fun initSunmiPrinterService(context: Context?)

Initializes the Sunmi printer service.

    Parameters:
        context: Application context.

deInitSunmiPrinterService


fun deInitSunmiPrinterService(context: Context?)

Deinitializes the Sunmi printer service.

    Parameters:
        context: Application context.

sendRawData


fun sendRawData(data: ByteArray?)

Sends raw data to the printer.

    Parameters:
        data: Data in byte array format to send to the printer.

cutpaper


fun cutpaper()

Cuts the printer paper.
initPrinter


fun initPrinter()

Initializes the printer.
print3Line


fun print3Line()

Prints three blank lines.
getPrinterSerialNo


fun getPrinterSerialNo(): String?

Gets the serial number of the printer.

    Returns:
        Serial number of the printer or an empty string in case of an error.

getDeviceModel


fun getDeviceModel(): String?

Gets the device model of the printer.

    Returns:
        Device model or an empty string in case of an error.

getPrinterVersion


fun getPrinterVersion(): String?

Gets the version of the printer.

    Returns:
        Version of the printer or an empty string in case of an error.

getPrinterPaper


fun getPrinterPaper(): String?

Gets the paper size of the printer.

    Returns:
        Paper size ("58mm" or "80mm") or an empty string in case of an error.

getPrinterStatus


fun getPrinterStatus(): String

Gets the current status of the printer.

    Returns:
        Printer status as a string.

getPrinterHead


fun getPrinterHead(callbcak: InnerResultCallback?)

Gets information about the printer head.

    Parameters:
        callbcak: Callback to handle the response.

getPrinterDistance


fun getPrinterDistance(callback: InnerResultCallback?)

Gets the printed distance of the printer.

    Parameters:
        callback: Callback to handle the response.

setAlign


fun setAlign(align: Int)

Sets the alignment of the printed text.

    Parameters:
        align: Text alignment (0: left, 1: center, 2: right).

feedPaper


fun feedPaper()

Feeds the printer paper.
printText


fun printText(content: String?, size: Float, isBold: Boolean, isUnderLine: Boolean, typeface: String?)

Prints text with style options.

    Parameters:
        content: Text to print.
        size: Text size.
        isBold: Whether the text is bold.
        isUnderLine: Whether the text is underlined.
        typeface: Text typeface.

printBarCode


fun printBarCode(data: String?, symbology: Int, height: Int, width: Int, textposition: Int)

Prints a barcode.

    Parameters:
        data: Barcode data.
        symbology: Barcode symbology type.
        height: Barcode height.
        width: Barcode width.
        textposition: Text position.

printQr


fun printQr(data: String?, modulesize: Int, errorlevel: Int)

Prints a QR code.

    Parameters:
        data: QR code data.
        modulesize: QR code module size.
        errorlevel: QR code error correction level.

printTable


fun printTable(txts: Array<String?>?, width: IntArray?, align: IntArray?)

Prints a table.

    Parameters:
        txts: Array of text strings for the columns.
        width: Array of column widths.
        align: Array of column alignments.

printBitmap


fun printBitmap(bitmap: Bitmap?, orientation: Int)

Prints a bitmap image.

    Parameters:
        bitmap: Bitmap image to print.
        orientation: Image orientation (0: normal, 1: rotated).

isBlackLabelMode


fun isBlackLabelMode(): Boolean

Checks if the printer is in black label mode.

    Returns:
        true if in black label mode, false otherwise.

isLabelMode


fun isLabelMode(): Boolean

Checks if the printer is in label mode.

    Returns:
        true if in label mode, false otherwise.

openCashBox


fun openCashBox()

Opens the cash box connected to the printer.
controlLcd


fun controlLcd(flag: Int)

Controls the printer's LCD screen.

    Parameters:
        flag: Command to control the LCD screen.

sendTextToLcd


fun sendTextToLcd()

Sends text to the printer's LCD screen.
sendTextsToLcd


fun sendTextsToLcd()

Sends multiple lines of text to the printer's LCD screen.
sendPicToLcd


fun sendPicToLcd(pic: Bitmap?)

Sends an image to the printer's LCD screen.

    Parameters:
        pic: Image to send.

showPrinterStatus


fun showPrinterStatus(context: Context?)

Displays the printer status via a Toast message.

    Parameters:
        context: Application context.

printOneLabel


fun printOneLabel()

Prints a single label.
printMultiLabel


fun printMultiLabel(num: Int)

Prints multiple labels.

    Parameters:
        num: Number of labels to print.

printLabelContent


@Throws(RemoteException::class)
private fun printLabelContent()

Prints the content of a label.

Example Usage**

public class PrinterManager extends AppCompatActivity {
    private static final int REQUEST_CODE_PICK_IMAGE =100;
    private CustomDrawingView drawingView;
    private PrinterHelper printerHelper;
    private List<Bitmap> imagesToPrint = new ArrayList<>();

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
            imagesToPrint.clear();
            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true); // Permite seleccionar múltiples imágenes
            startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == RESULT_OK) {
            if (data.getClipData() != null) {
                ClipData clipData = data.getClipData();
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    ClipData.Item item = clipData.getItemAt(i);
                    Uri selectedImageUri = item.getUri();
                    addImageToQueue(selectedImageUri);
                }
            } else if (data.getData() != null) {
                Uri selectedImageUri = data.getData();
                addImageToQueue(selectedImageUri);
            }
            printImageQueue();
        }
    }

    private void addImageToQueue(Uri selectedImageUri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
            imagesToPrint.add(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to load image", Toast.LENGTH_SHORT).show();
        }
    }

    private void printImageQueue() {
        for (Bitmap bitmap : imagesToPrint) {
            printerHelper.printBitmap(bitmap, 0);
        }
        imagesToPrint.clear();
        Toast.makeText(this, "Print queue completed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        printerHelper.deInitSunmiPrinterService(this);
    }
}
