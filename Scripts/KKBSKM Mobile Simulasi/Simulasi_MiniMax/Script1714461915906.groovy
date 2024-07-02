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

// Data Entry

// Jenis Program
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/jenisProgram']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$Program')]"]), 0)

// Jenis Pembiayaan
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/jenisPembiayaan']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$JenisPembiayaan')]"]), 0)

// Tipe Konsumen
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/tipeKonsumen']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$TipeKonsumen')]"]), 0)

// NPWP
switch(NPWP) {
	case "Ya":
	case "Yes":
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/npwpY']"]), 0)
		break;
	default:
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/npwpN']"]), 0)
		break;
}

// Cluster
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/cluster']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$Cluster')]"]), 0)

// Tujuan Penggunaan
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/tujuanPenggunaan']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$TujuanPenggunaan')]"]), 0)

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
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/uangMukaPercent']"]), 0)
String DP = DP
for (int i = 0; i < DP.length(); i++) {
	char digit = DP.charAt(i)
	int keyCode = Character.getNumericValue(digit) + 7
	driver.pressKeyCode(keyCode)
}

// Jenis Kendaraan
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/jenisKendaraan']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$JenisKendaraan')]"]), 0)

// Wilayah
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/wilayah']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$Wilayah')]"]), 0)

// Asuransi
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/asuransi']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$Asuransi')]"]), 0)

// Perluasan Asuransi
def mapPerluasanAsuransi = [
    'RSCC': 'checkRSCC',
    'TJH 10 JT': 'checkTJH10',
    'TJH 25 JT': 'checkTJH25',
    'RSMB': 'checkRSMB',
    'TJH 50 JT': 'checkTJH50'
]

String PerluasanAsuransi = PerluasanAsuransi

PerluasanAsuransi.tokenize('+').each { item ->
    def resourceId = mapPerluasanAsuransi[item.trim()]
    if (resourceId) {
        def checkbox = findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/$resourceId']"])
        if (!Mobile.verifyElementChecked(checkbox, 0)) {
            Mobile.tap(checkbox, 0)
        }
    }
}

// Screenshot
Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathKredit)) + '/' + No + '/' + 'Input Harga Kendaraan') + '.png', FailureHandling.STOP_ON_FAILURE)

// Kalkulasi
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/kalkulasi']"]), 0)

// Hasil Simulasi
Mobile.delay(1)
Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathKredit)) + '/' + No + '/' + 'ADDM') + '.png', FailureHandling.STOP_ON_FAILURE)
// --> Download
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/btDownload']"]), 0)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/buttonSimulasiDetail']"]), 0)
Mobile.delay(2)
Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathKredit)) + '/' + No + '/' + 'Simulasi Detail') + '.png', FailureHandling.STOP_ON_FAILURE)
Mobile.pressBack();
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//android.widget.HorizontalScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]"]), 0)
Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathKredit)) + '/' + No + '/' + 'ADDB') + '.png', FailureHandling.STOP_ON_FAILURE)
