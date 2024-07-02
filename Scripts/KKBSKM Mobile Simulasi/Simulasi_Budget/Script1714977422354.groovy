import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.NumberFormat

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

String baseDir = System.getProperty('user.dir');

String packageName = 'bcaf.crm.kkb.saleskit';

// start app
Mobile.startExistingApplication(packageName);
AndroidDriver<?> driver = MobileDriverFactory.getDriver();

String id = 'bcaf.crm.kkb.saleskit:id'

def TESTDATA = findTestData("Data Files/simulasi-budget");

def test_no = 1;

//def No = TESTDATA.getValue('No', test_no);
def Program = TESTDATA.getValue('Program', test_no);
def JenisPembiayaan = TESTDATA.getValue('JenisPembiayaan', test_no);
def JenisBudget = TESTDATA.getValue('JenisBudget', test_no);
def TipeKonsumen = TESTDATA.getValue('TipeKonsumen', test_no);
def NPWP = TESTDATA.getValue('NPWP', test_no);
def Cluster = TESTDATA.getValue('Cluster', test_no);
def TujuanPenggunaan = TESTDATA.getValue('TujuanPenggunaan', test_no);
def HargaKendaraan = TESTDATA.getValue('HargaKendaraan', test_no);
def JenisKendaraan = TESTDATA.getValue('JenisKendaraan', test_no);
def wilayah = TESTDATA.getValue('Wilayah', test_no);
def Asuransi = TESTDATA.getValue('Asuransi', test_no);
//def PerluasanAsuransi = TESTDATA.getValue('PerluasanAsuransi', test_no);
def RSCC = TESTDATA.getValue('RSCC', test_no);
def RSMB = TESTDATA.getValue('RSMB', test_no);
def TJH = TESTDATA.getValue('TJH', test_no);



def uncheckAllCheckboxes() {
	['checkRSCC_budget', 'checkRSMB_budget', 'checkTJH10_budget', 'checkTJH25_budget', 'checkTJH50_budget'].each { resourceId ->
		String id = 'bcaf.crm.kkb.saleskit:id'
		def checkbox = findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/$resourceId']"])
		
		try {
			Mobile.verifyElementChecked(checkbox, 0)
			Mobile.tap(checkbox, 0, FailureHandling.OPTIONAL)
		} catch (com.kms.katalon.core.exception.StepFailedException e) {

		}
	}
}

String Wilayah = wilayah;
if(Wilayah == '1') {
	Wilayah = 'Sumatra dan Sekitarnya';
} else if(Wilayah == '2') {
	Wilayah = 'Jakarta, Jawa Barat dan Banten';
} else {
	Wilayah = 'Lain-lainnya';
}

for(int x=1; x<=6; x++) {
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "(//*[@resource-id='$id/card_menu'])[2]"]), 0, FailureHandling.STOP_ON_FAILURE);
	String budgetcols = 'MukaDP' + x;
	def Budget = TESTDATA.getValue(budgetcols, test_no);
	// Jenis Program
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/jenisProgram']"]), 0);
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$Program')]"]), 0);
	
	Mobile.delay(1);
	// Jenis Pembiayaan
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/jenisPembiayaan']"]), 0);
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$JenisPembiayaan')]"]), 0);
	
	Mobile.delay(1);
	// Tipe Budget
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/SPBudget']"]), 0);
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$JenisBudget')]"]), 0);
	
	Mobile.delay(1);
	// Budget
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/nomBudget']"]), 0);
	String budget = Budget
	for (int i = 0; i < budget.length(); i++) {
		char digit = budget.charAt(i);
		int keyCode = Character.getNumericValue(digit) + 7;
		driver.pressKeyCode(keyCode);
	}
	Mobile.hideKeyboard();
	
	Mobile.delay(1);
	// Tipe Konsumen
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/tipeKonsumen']"]), 0);
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$TipeKonsumen')]"]), 0);
	
	// NPWP
	switch(NPWP) {
		case "Ya":
			Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/npwpY']"]), 0);
			break;
		default:
			Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/npwpN']"]), 0);
			break;
	}
	
	Mobile.delay(1);
	// Cluster
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/cluster']"]), 0);
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$Cluster')]"]), 0);
	
	Mobile.delay(1);
	// Tujuan Penggunaan
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/tujuanPenggunaan']"]), 0);
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$TujuanPenggunaan')]"]), 0);
	
	// Screenshot
	Mobile.takeScreenshot((((baseDir + GlobalVariable.sspathP17)) + '/' + test_no + '/' + x + 'data_entry') + '.png', FailureHandling.STOP_ON_FAILURE)
	
	Mobile.delay(1);
	// Lanjut
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/next']"]), 0)
	
	Mobile.delay(1);
	// Harga Kendaraan
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/edthargaKendaraan']"]), 0);
	 String harga_kendaraan = HargaKendaraan;
	 for (int i = 0; i < harga_kendaraan.length(); i++) {
		 char digit = harga_kendaraan.charAt(i);
		 int keyCode = Character.getNumericValue(digit) + 7;
		 driver.pressKeyCode(keyCode);
	 }
	 Mobile.hideKeyboard();
	
	 Mobile.delay(1);
	// Jenis Kendaraan
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/SPjenisKendaraan']"]), 0)
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$JenisKendaraan')]"]), 0)
	
	Mobile.delay(1);
	// Wilayah
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/SPwilayah']"]), 0)
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$Wilayah')]"]), 0)
	
	Mobile.delay(1);
	// Asuransi
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/SPasuransi']"]), 0)
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.CheckedTextView' and (@text = '$Asuransi')]"]), 0)
	
	// Perluasan Asuransi
	def mapPerluasanAsuransi = [
		'RSCC': 'checkRSCC_budget',
		'TJH 10 JT': 'checkTJH10_budget',
		'TJH 25 JT': 'checkTJH25_budget',
		'RSMB': 'checkRSMB_budget',
		'TJH 50 JT': 'checkTJH50_buget'
	]
	
	
	
	// Uncheck all checkboxes before proceeding
	uncheckAllCheckboxes()
	
	switch(RSCC) {
		case '1':
			Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/checkRSCC_budget']"]), 0)
			break;
		default:
			break;
	}
	
	switch(RSMB) {
		case '1':
			Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/checkRSMB_budget']"]), 0)
			break;
		default:
			break;
	}
	
	switch(TJH) {
		case '10':
			Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/checkTJH10_budget']"]), 0)
			break;
		case '25':
			Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/checkTJH25_budget']"]), 0)
			break;
		case '50':
			Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/checkTJH50']"]), 0)
			break;
		default:
			break;
	}
	

	// Screenshot
	Mobile.takeScreenshot((((baseDir + GlobalVariable.sspathP17)) + '/' + test_no + '/' + x + 'harga_kendaraan') + '.png', FailureHandling.STOP_ON_FAILURE);
	
	Mobile.delay(1);
	// Kalkulasi
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/kalkulasi_budget']"]), 0);
	
	// Hasil Simulasi
	Mobile.takeScreenshot((((baseDir + GlobalVariable.sspathP17)) + '/' + test_no + '/' + x + 'ADDM') + '.png', FailureHandling.STOP_ON_FAILURE);
	
	int budg = Integer.parseInt(Budget)
	String budget_nom = NumberFormat.getNumberInstance().format(budg);
	String budget_rp = 'Rp. ' + budget_nom
	Mobile.verifyElementText(findTestObject('Object Repository/xpath', ['xpath' : "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"]), budget_rp)
	
	// Download
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/btDownload']"]), 0);
	
	// Simulasi Detail
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/buttonSimulasiDetail']"]), 0);
	
	// PDF Simulasi
	Mobile.delay(5);
	Mobile.takeScreenshot((((baseDir + GlobalVariable.sspathP17)) + '/' +  test_no + '/' + x + 'simulasi_detail') + '.png', FailureHandling.STOP_ON_FAILURE);
	
	Mobile.delay(2);
	Mobile.pressBack();
	Mobile.delay(1);
	Mobile.pressBack();
	Mobile.delay(1);
	Mobile.pressBack();
	Mobile.delay(1);
	Mobile.pressBack();
	Mobile.delay(1);
}



//// ADDB
//Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class = 'android.widget.TextView' and (@text = 'ADDB')]"]), 0);
//Mobile.takeScreenshot((((baseDir + GlobalVariable.sspathP17)) + '/' + No + '/' + 'ADDB') + '.png', FailureHandling.STOP_ON_FAILURE);