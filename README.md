## Class/Function: PrinterHelper

##### "First, make sure you have imported the `sunmiPrinterLibrary.jar`  lib into your project, then use the `PrinterHelper` class to interact with the lib."

**Purpose:** 
The `PrinterHelper` class provides various methods to interact with Sunmi printers. It 
handles printer connection, sending print data, checking printer status, and performing 
printer-specific actions like cutting paper and printing different types of content.

## Init Service

1-Including the Class: This likely means adding the necessary dependency to your project's build.gradle file. Refer to the library's documentation for the correct dependency information.

2-Instantiating the Class: The provided code snippet PrinterHelper printerHelper = PrinterHelper() creates a new instance of the PrinterHelper class. In Kotlin, you would typically use:

```
val printerHelper = PrinterHelper()
```
3-Initializing the Printing Service: The `initSunmiPrinterService(this)` method likely initializes the connection to the Sunmi printer. The this argument probably refers to the current Activity or Context.

```
printerHelper.initSunmiPrinterService(this)
```

#### Additional Notes:

Error Handling: It's crucial to add error handling to your code. The initSunmiPrinterService method might throw exceptions if the printer is not connected or there are other issues.

Permissions: Ensure you have the necessary permissions in your AndroidManifest.xml to interact with the printer.
Background Tasks: If the printing process is long-running, consider using a background thread or WorkManager to avoid blocking the main thread.

## Methods:

#### Method 1:

    fun initSunmiPrinterService(context: Context?)

*Purpose: Initialize the Sunmi printer service and bind it to the provided context.

*Parameters:

    context: Context?: The context to which the printer service should be bound.

    Return: None

*Exceptions:

    InnerPrinterException: Conditions under which this exception is raised.

#### Method 2:

    fun deInitSunmiPrinterService(context: Context?)

*Purpose: Unbind the Sunmi printer service from the provided context.

*Parameters:

    context: Context?: The context from which the printer service should be unbound.

    Return: None

*Exceptions:

    InnerPrinterException: Conditions under which this exception is raised.

#### Method 3:

    private fun checkSunmiPrinterService(service: SunmiPrinterService)

*Purpose: Check the Sunmi printer service to determine if a printer is available.

*Parameters:

    service: SunmiPrinterService: The printer service to be checked.

    Return: None

*Exceptions:

    InnerPrinterException: Conditions under which this exception is raised.

#### Method 4:

    private fun handleRemoteException(e: RemoteException)

*Purpose: Handle RemoteException when interacting with the Sunmi printer service.

*Parameters:

    e: RemoteException: The exception to be handled.

    Return: None

*Exceptions:

    None

#### Method 5:

    fun sendRawData(data: ByteArray?)

*Purpose: Send raw data to the printer for printing.

*Parameters:

    data: ByteArray?: The raw data to be sent to the printer.

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 6:

    fun cutpaper()

*Purpose: Cut the paper using the printer's cutter.

*Parameters:

    None
    
    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 7:

    fun initPrinter()

*Purpose: Initialize the printer.

*Parameters: 

    None
    
    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 8:

    fun print3Line()

*Purpose: Print three lines using the printer.

*Parameters: 

    None
    
    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 9:

    fun getPrinterSerialNo(): String?

*Purpose: Get the serial number of the printer.

*Parameters: 
    
    None
    
    Return: The serial number of the printer as a String.

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 10:

    fun getDeviceModel(): String?

*Purpose: Get the model of the printer.

*Parameters: 

    None
    
    Return: The model of the printer as a String.

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 11:

    fun getPrinterVersion(): String?

*Purpose: Get the version of the printer.

*Parameters:     
    
    None
    
    Return: The version of the printer as a String.

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 12:

    fun getPrinterPaper(): String?

*Purpose: Get the type of paper used in the printer.

*Parameters: 

    None
    
    Return: The type of paper as a String.

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 13:

    fun getPrinterStatus(): String

*Purpose: Get the current status of the printer.

*Parameters:
    
    None
    
    Return: The status of the printer as a String.

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 14:

    fun getPrinterHead(callbcak: InnerResultCallback?)

*Purpose: Get the printer head information.

*Parameters:

    callback: InnerResultCallback?: The callback to receive the result.
    
    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 15:

    fun getPrinterDistance(callback: InnerResultCallback?)

*Purpose: Get the printed distance of the printer.

*Parameters:

    callback: InnerResultCallback?: The callback to receive the result.

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 16:

    fun setAlign(align: Int)

*Purpose: Set the alignment for the printer.

*Parameters:

    align: Int: The alignment to be set.
    
    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 17:

    fun feedPaper()

*Purpose: Feed paper using the printer.

*Parameters:

    None
    
    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 18:

    fun printText(content: String?, size: Float, isBold: Boolean, isUnderLine: Boolean, typeface: String?)

*Purpose: Print text with specified style and size.

*Parameters:

    content: String?: The text content to be printed.
    size: Float: The size of the text.
    isBold: Boolean: Whether the text should be bold.
    isUnderLine: Boolean: Whether the text should be underlined.
    typeface: String?: The typeface to be used.

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 19:

    fun printBarCode(data: String?, symbology: Int, height: Int, width: Int, textposition: Int)

*Purpose: Print a barcode with specified parameters.

*Parameters:

    data: String?: The data to be encoded in the barcode.
    symbology: Int: The barcode symbology.
    height: Int: The height of the barcode.
    width: Int: The width of the barcode.
    textposition: Int: The position of the text.

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 20:

    fun printQr(data: String?, modulesize: Int, errorlevel: Int)

*Purpose: Print a QR code with specified parameters.

*Parameters:

    data: String?: The data to be encoded in the QR code.
    modulesize: Int: The module size of the QR code.
    errorlevel: Int: The error level of the QR code.

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 21:

    fun printTable(txts: Array<String?>?, width: IntArray?, align: IntArray?)

*Purpose: Print a table with specified text, width, and alignment.

*Parameters:

    txts: Array<String?>?: The text to be printed in each cell.
    width: IntArray?: The width of each column.
    align: IntArray?: The alignment of each column.

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 22:

    fun printBitmap(bitmap: Bitmap?, orientation: Int)

*Purpose: Print a bitmap image with specified orientation.

*Parameters:

    bitmap: Bitmap?: The bitmap to be printed.
    orientation: Int: The orientation of the bitmap.

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 23:

    fun isBlackLabelMode(): Boolean

*Purpose: Check if the printer is in black label mode.

*Parameters: 

    None
    
    Return: Boolean indicating if the printer is in black label mode.

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 24:

    fun isLabelMode(): Boolean

*Purpose: Check if the printer is in label mode.

*Parameters: 

    None

    Return: Boolean indicating if the printer is in label mode.

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 25:

    fun openCashBox()

*Purpose: Open the cash box connected to the printer.

*Parameters:

    None

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 26:

    fun controlLcd(flag: Int)

*Purpose: Control the LCD of the printer with specified flag.

*Parameters:

    flag: Int: The control flag for the LCD.

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 27:

    fun sendTextToLcd()

*Purpose: Send text to the LCD of the printer.

*Parameters:

    None

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 28:

    fun sendTextsToLcd()

*Purpose: Send multiple texts to the LCD of the printer.

*Parameters:

    None

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 29:

    fun sendPicToLcd(pic: Bitmap?)

*Purpose: Send a picture to the LCD of the printer.

*Parameters:

    pic: Bitmap?: The picture to be sent to the LCD.

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 30:

    fun showPrinterStatus(context: Context?)

*Purpose: Show the status of the printer as a toast message.

*Parameters:

    context: Context?: The context in which the toast message should be shown.

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 31:

    fun printOneLabel()

*Purpose: Print a single label.

*Parameters:

    None

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 32:

    fun printMultiLabel(num: Int)

*Purpose: Print multiple labels.

*Parameters:

    num: Int: The number of labels to be printed.

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

#### Method 33:

    @Throws(RemoteException::class)
    private fun printLabelContent()

*Purpose: Print the content of a label.

*Parameters: 

    None

    Return: None

*Exceptions:

    RemoteException: Conditions under which this exception is raised.

## Example Usage
```
class CanvasActivity : AppCompatActivity() {

    private lateinit var drawingView: CustomDrawingView
    private lateinit var printerHelper:PrinterHelper
    private val imagesToPrint = mutableListOf<Bitmap>()

    companion object {
        private const val REQUEST_CODE_PICK_IMAGE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.canvas)
        SystemBarsUtils.styleSystemBars(this, android.R.color.black)

        drawingView = findViewById(R.id.drawingView)
        val btnPrintCanvas = findViewById<Button>(R.id.btnPrintCanvas)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnBitmap = findViewById<Button>(R.id.btnBitmap)

        printerHelper = PrinterHelper()
        printerHelper.initSunmiPrinterService(this)

        btnPrintCanvas.setOnClickListener {
            val bitmap = drawingView.getBitmap()
            printerHelper.printBitmap(bitmap, 0)
        }

        btnBack.setOnClickListener {
            startActivity(Intent(this, PrinterManager::class.java))
            finish()
        }

        btnBitmap.setOnClickListener {
            imagesToPrint.clear()
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == RESULT_OK) {
            data?.let {
                if(it.clipData != null) {
                    val clipData = it.clipData!!
                    for (i in 0 until clipData.itemCount) {
                        val item = clipData.getItemAt(i)
                        val selectedImageUri = item.uri
                        addImageToQueue(selectedImageUri)
                    }
                } else if (it.data != null) {
                    val selectedImageUri = it.data!!
                    addImageToQueue(selectedImageUri)
                }
                printImageQueue()
            }
        }
    }

    private fun addImageToQueue(selectedImageUri: Uri) {
        try {
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedImageUri)
            imagesToPrint.add(bitmap)
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Failed to load image", Toast.LENGTH_SHORT).show()
        }
    }

    private fun printImageQueue() {
        imagesToPrint.forEach { bitmap ->
            printerHelper.printBitmap(bitmap, 0)
        }
        imagesToPrint.clear()
        Toast.makeText(this, "Print queue completed", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        printerHelper.deInitSunmiPrinterService(this)
    }
}
```
### Exception Handling:
- Methods handling `RemoteException` catch the exception and pass it to the `handleRemoteException` method for processing.
- `InnerPrinterException` is caught and logged.

### Notes:
- The class contains several `TODO` comments indicating areas where further processing or handling is required, particularly in the event of service disconnection or exception handling.
- This class should be used with a valid context and proper error handling in a production environment to ensure smooth printer operations.
