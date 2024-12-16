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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidKeyCode
import com.kms.katalon.core.annotation.Keyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType


import jxl.*
import jxl.write.*
import jxl.read.biff.BiffException

import excel.WriteExcel

import org.openqa.selenium.Keys as Keys

String baseDir = System.getProperty('user.dir')

String packageName = 'bcaf.crm.kkb.saleskit'

// Start Application
Mobile.startExistingApplication(packageName)
AndroidDriver<?> driver = MobileDriverFactory.getDriver()

String id = 'bcaf.crm.kkb.saleskit:id'
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[1]"]), 0, FailureHandling.STOP_ON_FAILURE)

// Data Entry

// Jenis Program
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/jenisProgram']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$Program')]"]), 0)
Mobile.delay(1)

// Jenis Pembiayaan
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/jenisPembiayaan']"]), 0)
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$JenisPembiayaan')]"]), 0)
Mobile.delay(2)

// Tipe Konsumen
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/tipeKonsumen']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$TipeKonsumen')]"]), 0)

// NPWP
Mobile.delay(3)
switch(NPWP) {
	case "Ya":
	case "Yes":
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.RadioButton' and (@text = 'Ya' or . = 'Ya') and @resource-id = 'bcaf.crm.kkb.saleskit:id/npwpY']"]), 0)
		break;
	default:
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.RadioButton' and (@text = 'Tidak' or . = 'Tidak') and @resource-id = 'bcaf.crm.kkb.saleskit:id/npwpN']"]), 0)
		break;
}

Mobile.delay(2)

// Cluster
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/cluster']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$Cluster')]"]), 0)
Mobile.delay(2)

// Tujuan Penggunaan
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/tujuanPenggunaan']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$TujuanPenggunaan')]"]), 0)
Mobile.delay(2)

// Screenshot
Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathKredit)) + '/' + No + '/' + 'Input Data') + '.png', FailureHandling.STOP_ON_FAILURE)

// Lanjut
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/nextSimKredit']"]), 0)

// Harga Kendaraan
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/hargaKendaraan']"]), 0)
String HargaKendaraan = HargaKendaraan
for (int i = 0; i < HargaKendaraan.length(); i++) {
	char digit = HargaKendaraan.charAt(i)
	int keyCode = Character.getNumericValue(digit) + 7
	driver.pressKeyCode(keyCode)
}

// DP
Mobile.delay(2)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/uangMukaPercent']"]), 0)
String DP = DP
for (int i = 0; i < DP.length(); i++) {
	char digit = DP.charAt(i)
	int keyCode = Character.getNumericValue(digit) + 7
	driver.pressKeyCode(keyCode)
}

// Jenis Kendaraan
Mobile.delay(2)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/jenisKendaraan']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$JenisKendaraan')]"]), 0)

// Tahun Kendaraan
Mobile.delay(5)
switch(JenisPembiayaan) {
    case 'Mobil Bekas':
    case 'Refinancing':
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.EditText' and @resource-id = 'bcaf.crm.kkb.saleskit:id/tahunKendaraan' and (@text = '' or . = '')]"]), 0)
	 	Mobile.delay(2)
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
		if(Tahun == '2020') {
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
		}
		if(Tahun == '2012') {
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
		}
		if(Tahun == '2017') {
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
		}
		if(Tahun == '2011') {
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
		}
		if(Tahun == '2023') {
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
		}
		if(Tahun == '2014') {
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_UP)
		}
        Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/button1']"]), 0)
        break
    case 'Mobil Baru':
        break
}

// Wilayah
Mobile.delay(2)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/wilayah']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$Wilayah')]"]), 0)

// Asuransi
Mobile.delay(2)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/asuransi']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$Asuransi')]"]), 0)

// Perluasan Asuransi
Mobile.delay(7)

//// Manfaat Tambahan
//// CPR
//switch(CPR) {
//	case '1 TAHUN + 2 TAHUN':
//	case '1 tahun + 2 tahun':
//	case '1 Tahun + 2 Tahun':
//		break;
//	case '1 TAHUN':
//	case '1 tahun':
//	case '1 Tahun':
//		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'CPR 2 Tahun' or . = 'CPR 2 Tahun') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
//		break;
//	case '2 TAHUN':
//	case '2 tahun':
//	case '2 Tahun':
//		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'CPR 1 Tahun' or . = 'CPR 1 Tahun') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
//		break;
//	default:
//	break;
//}

// Uncheck All
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'CFP' or . = 'CFP') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'TLP' or . = 'TLP') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'PA' or . = 'PA') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
 
Mobile.delay(3)
Mobile.scrollToText("Perluasan Asuransi")
switch(ManfaatTambahan) {
	case 'CFP':
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'CFP' or . = 'CFP') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
	break
	case 'TLP':
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'TLP' or . = 'TLP') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
	break
	case 'PA':
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'PA' or . = 'PA') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
	break
	case 'CFP + TLP':
	case 'TLP + CFP':
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'CFP' or . = 'CFP') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'TLP' or . = 'TLP') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
	break
	case 'TLP + PA':
	case 'PA + TLP':
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'TLP' or . = 'TLP') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'PA' or . = 'PA') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
	break
	case 'CFP + PA':
	case 'PA + CFP':
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'CFP' or . = 'CFP') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'PA' or . = 'PA') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
	break
	case 'CFP + TLP + PA':
	case 'CFP + PA + TLP':
	case 'TLP + CFP + PA':
	case 'TLP + PA + CFP':
	case 'PA + CFP + TLP':
	case 'PA + TLP + CFP':
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'CFP' or . = 'CFP') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'TLP' or . = 'TLP') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckBox' and (@text = 'PA' or . = 'PA') and @resource-id = 'bcaf.crm.kkb.saleskit:id/cbItem']"]), 0)
	break
}

// Screenshot
Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathKredit)) + '/' + No + '/' + 'Input Harga Kendaraan') + '.png', FailureHandling.STOP_ON_FAILURE)

// Kalkulasi
Mobile.scrollToText("Kalkulasi")
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/kalkulasi']"]), 0)

// Hasil Simulasi
// ADDM
Mobile.delay(10)
Mobile.waitForElementPresent(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.Button' and (@text = 'Download' or . = 'Download') and @resource-id = 'bcaf.crm.kkb.saleskit:id/btDownload']"]), 2, FailureHandling.CONTINUE_ON_FAILURE)
if (Mobile.verifyElementExist(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.Button' and (@text = 'Download' or . = 'Download') and @resource-id = 'bcaf.crm.kkb.saleskit:id/btDownload']"]), 2,  FailureHandling.CONTINUE_ON_FAILURE)) {
    Mobile.takeScreenshot(((baseDir + GlobalVariable.screenshotPathKredit) + '/' + No + '/' + 'ADDM') + '.png', FailureHandling.CONTINUE_ON_FAILURE)
	
	// Get Tenor Value
	def DP_Angsuran = [ 
	    ["MukaDP1", "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"],
	    ["MukaDP2", "//android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"],
	    ["MukaDP3", "//android.widget.FrameLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"],
	    ["MukaDP4", "//android.widget.FrameLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"],
	    ["MukaDP5", "//android.widget.FrameLayout[5]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"],
	    ["MukaDP6", "//android.widget.FrameLayout[6]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"],
	    ["MukaAngsuran1", "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]"],
	    ["MukaAngsuran2", "//android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]"],
	    ["MukaAngsuran3", "//android.widget.FrameLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]"],
	    ["MukaAngsuran4", "//android.widget.FrameLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]"],
	    ["MukaAngsuran5", "//android.widget.FrameLayout[5]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]"],
	    ["MukaAngsuran6", "//android.widget.FrameLayout[6]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]"]
	]
	
	WriteExcel excelKeyword = new WriteExcel()
	
	DP_Angsuran.each { columnValue ->
	    def columnHeader = columnValue[0]
	    def xpath = columnValue[1]
	    
	    String cellValue = findTextValue(xpath)
	    excelKeyword.writeToExcel(columnHeader, cellValue, No)
	}
	
    Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/btDownload']"]), 0)
    Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/buttonSimulasiDetail']"]), 0)
    Mobile.delay(5)
    Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathKredit)) + '/' + No + '/' + 'Simulasi Detail ADDM') + '.png', FailureHandling.CONTINUE_ON_FAILURE)
	Mobile.delay(10)
    Mobile.pressBack();
}

// ADDB
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.widget.HorizontalScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]"]), 0)
Mobile.delay(3)
Mobile.waitForElementPresent(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/btDownload']"]), 2, FailureHandling.CONTINUE_ON_FAILURE)
if (Mobile.verifyElementExist(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/btDownload']"]), 2, FailureHandling.CONTINUE_ON_FAILURE)) {
    Mobile.takeScreenshot(((baseDir + GlobalVariable.screenshotPathKredit) + '/' + No + '/' + 'ADDB') + '.png', FailureHandling.STOP_ON_FAILURE)
	
	// Get Tenor Value
	def DP_Angsuran2 = [ 
	    ["BelakangDP1", "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"],
	    ["BelakangDP2", "//android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"],
	    ["BelakangDP3", "//android.widget.FrameLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"],
	    ["BelakangDP4", "//android.widget.FrameLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"],
	    ["BelakangDP5", "//android.widget.FrameLayout[5]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"],
	    ["BelakangDP6", "//android.widget.FrameLayout[6]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"],
	    ["BelakangAngsuran1", "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]"],
	    ["BelakangAngsuran2", "//android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]"],
	    ["BelakangAngsuran3", "//android.widget.FrameLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]"],
	    ["BelakangAngsuran4", "//android.widget.FrameLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]"],
	    ["BelakangAngsuran5", "//android.widget.FrameLayout[5]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]"],
	    ["BelakangAngsuran6", "//android.widget.FrameLayout[6]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]"]
	]
	
	WriteExcel excelKeyword = new WriteExcel()
	
	DP_Angsuran2.each { columnValue ->
		def columnHeader = columnValue[0]
		def xpath = columnValue[1]
		
		String cellValue = findTextValue(xpath)
		excelKeyword.writeToExcel(columnHeader, cellValue, No)
	}
	
    Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/btDownload']"]), 0)
    Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/buttonSimulasiDetail']"]), 0)
    Mobile.delay(5)
    Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathKredit)) + '/' + No + '/' + 'Simulasi Detail ADDB') + '.png', FailureHandling.STOP_ON_FAILURE)
	Mobile.delay(10)
    Mobile.pressBack();
}

// Back
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/back']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/back']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/back']"]), 0)

@Keyword
def findTextValue(String xpath) {
	Mobile.getText(findTestObject('Object Repository/xpath', ['xpath' : xpath]), 0)
}