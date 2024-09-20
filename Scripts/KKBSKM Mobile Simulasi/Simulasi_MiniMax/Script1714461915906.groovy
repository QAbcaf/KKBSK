import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidKeyCode

import org.openqa.selenium.Keys as Keys

String baseDir = System.getProperty('user.dir')

String packageName = 'bcaf.crm.kkb.saleskit'

// Start Application
Mobile.startExistingApplication(packageName)
AndroidDriver<?> driver = MobileDriverFactory.getDriver()

String id = 'bcaf.crm.kkb.saleskit:id'
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[3]"]), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.delay(5)

// Data Entry

// Jenis Pembiayaan
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.view.View[2]/android.view.View[2]"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.widget.CheckedTextView[2]"]), 0)

// Tipe Konsumen
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.view.View[3]/android.view.View[2]"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$TipeKonsumen')]"]), 0)

// NPWP
switch(NPWP) {
	case "Ya":
	case "Yes":
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.RadioButton' and (@text = 'Ya')]"]), 0)
		break;
	default:
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.RadioButton' and (@text = 'Tidak')]"]), 0)
		break;
}

// Cluster
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.view.View[7]/android.view.View[2]"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$Cluster')]"]), 0)

// Tujuan Penggunaan
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.view.View[8]/android.view.View[2]"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$TujuanPenggunaan')]"]), 0)

// Screenshot
Mobile.delay(1)
Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathMiniMax)) + '/' + No + '/' + 'Input Data') + '.png', FailureHandling.STOP_ON_FAILURE)

// Lanjut
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.view.View[9]"]), 0)

// Harga Kendaraan
Mobile.delay(5)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.view.View[2]/android.widget.EditText[1]"]), 0)
String HargaKendaraan = HargaKendaraan
for (int i = 0; i < HargaKendaraan.length(); i++) {
	char digit = HargaKendaraan.charAt(i)
	int keyCode = Character.getNumericValue(digit) + 7
	driver.pressKeyCode(keyCode)
}

// DP
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.view.View[4]/android.widget.EditText[1]"]), 0)
String DP = DP
for (int i = 0; i < DP.length(); i++) {
	char digit = DP.charAt(i)
	int keyCode = Character.getNumericValue(digit) + 7
	driver.pressKeyCode(keyCode)
}
Mobile.hideKeyboard();

// Ballon Payment
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.view.View[2]/android.view.View[1]/android.view.View[1]/android.widget.EditText[1]"]), 0)
String BP = BallonPayment
for (int i = 0; i < BP.length(); i++) {
	char digit = BP.charAt(i)
	int keyCode = Character.getNumericValue(digit) + 7
	driver.pressKeyCode(keyCode)
}
Mobile.hideKeyboard();

// Jenis Kendaraan
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.view.View[6]/android.view.View[2]"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$JenisKendaraan')]"]), 0)

// Wilayah
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.view.View[7]/android.view.View[2]"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$Wilayah')]"]), 0)

// Asuransi
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.view.View[8]/android.view.View[2]"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$Asuransi')]"]), 0)

// Perluasan Asuransi
Mobile.delay(1)
def mapPerluasanAsuransi = [
    'RSCC': "//android.view.View[10]/android.widget.CheckBox[1]",
    'RSMB': "//android.view.View[11]/android.widget.CheckBox[1]",
    'TJH 10 JT': "//android.view.View[12]/android.widget.RadioButton[1]",
    'TJH 50 JT': "//android.view.View[13]/android.widget.RadioButton[1]",
    'TJH 25 JT': "//android.view.View[14]/android.widget.RadioButton[1]"
]

String perluasanAsuransi = PerluasanAsuransi
perluasanAsuransi.tokenize('+').each { item ->
    def xpath = mapPerluasanAsuransi[item.trim()]
    if (xpath) {
        def element = findTestObject('Object Repository/xpath', ['xpath' : xpath])
        Mobile.tap(element, 0)
    }
}


// Screenshot
Mobile.delay(1)
Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathMiniMax)) + '/' + No + '/' + 'Input Harga Kendaraan') + '.png', FailureHandling.STOP_ON_FAILURE)

// Kalkulasi
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.view.View[15]"]), 0)

// Hasil Simulasi
Mobile.delay(3)
// -- ADDM
Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathMiniMax)) + '/' + No + '/' + 'ADDM') + '.png', FailureHandling.STOP_ON_FAILURE)
def xpathElementADDM = "//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]"
def findTestObjectElement1 = findTestObject('Object Repository/xpath', ['xpath' : xpathElementADDM])
if (Mobile.verifyElementExist(findTestObjectElement1, 0, FailureHandling.CONTINUE_ON_FAILURE)) {
	Mobile.tap(findTestObjectElement1, 0)
	Mobile.delay(20)
	Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathMiniMax)) + '/' + No + '/' + 'Simulasi Detail ADDB') + '.png', FailureHandling.STOP_ON_FAILURE)
	Mobile.delay(2)
	Mobile.pressBack()
	Mobile.pressBack()
	Mobile.pressBack()
	Mobile.delay(2)
} else {                                                                
	
}

// -- ADDB
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.widget.TabWidget[1]/android.view.View[2]"]), 0)
Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathMiniMax)) + '/' + No + '/' + 'ADDB') + '.png', FailureHandling.STOP_ON_FAILURE)
def xpathElementADDB = "//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]"
def findTestObjectElement2 = findTestObject('Object Repository/xpath', ['xpath' : xpathElementADDB])
if (Mobile.verifyElementExist(findTestObjectElement2, 0, FailureHandling.CONTINUE_ON_FAILURE)) {
	Mobile.tap(findTestObjectElement2, 0)
	Mobile.delay(20)
	Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathMiniMax)) + '/' + No + '/' + 'Simulasi Detail ADDB') + '.png', FailureHandling.STOP_ON_FAILURE)
	Mobile.delay(2)
	Mobile.pressBack()
	Mobile.pressBack()
	Mobile.pressBack()
	Mobile.delay(2)
} else {
	
}