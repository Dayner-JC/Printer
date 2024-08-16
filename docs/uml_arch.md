## Architecture UML Diagram

```
plantuml
@startuml
title Printer Integration Architecture

class Application {
- Context context
  -PrinterHelper printerHelper
  }

class PrinterHelper {
- SunmiPrinterService sunmiPrinterService
  + initSunmiPrinterService(Context)
  + deInitSunmiPrinterService(Context)
  + sendRawData(ByteArray)
  + cutpaper()
  +initPrinter()
  + print3Line()
  + getPrinterSerialNo(): String
  + getDeviceModel(): String
  + getPrinterVersion(): String
  + getPrinterPaper(): String
  + getPrinterStatus(): String
  + getPrinterHead(InnerResultCallback)
  + getPrinterDistance(InnerResultCallback)
  + setAlign(Int)
  + feedPaper()
  + printText(String, Float, Boolean, Boolean, String)
  + printBarCode(String, Int, Int, Int, Int)
  + printQr(String,Int, Int)
  + printTable(Array<String>, IntArray, IntArray)
  + printBitmap(Bitmap, Int)
  + isBlackLabelMode(): Boolean
  + isLabelMode(): Boolean
  + openCashBox()
  + controlLcd(Int)
  + sendTextToLcd()
  + sendTextsToLcd()
  + sendPicToLcd(Bitmap)
  + showPrinterStatus(Context)
  + printOneLabel()
  + printMultiLabel(Int)
  - printLabelContent()
  }

Application --> PrinterHelper : uses
PrinterHelper --> SunmiPrinterLibrary : interacts with
@enduml
```

#### Description

The UML diagram illustrates the high-level architecture of a system integrating Sunmi printers using the PrinterHelper class.

`Application:`

    Represents the main Android application that utilizes the PrinterHelper class. It holds a reference to the PrinterHelper instance and provides the necessary context.

`PrinterHelper:` 

    Encapsulates the logic for interacting with Sunmi printers. It establishes a connection to the SunmiPrinterService and provides methods for various printing operations.

The Application class uses the PrinterHelper to perform printing tasks. The PrinterHelper, in turn, interacts with the SunmiPrinterService to send print commands and manage the printer status.

This architecture promotes modularity and separation of concerns, making the code easier to maintain and extend.