import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.OPTIONAL
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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://virtualmall.idofocus.co.id:25443/home')

WebUI.click(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/Page_KKB BCA Virtual Mall - Kredit Mobil Untuk Mobil Impian Anda dengan Mudah/a_Partner Kami dan Pengajuan'))

WebUI.click(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/Page_Partner Dealer Mobil Baru - KKB BCA Virtual Mall/brand-category-dinamis',["car":carBrand]))

WebUI.click(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/Page_Partner Dealer Mobil Baru - KKB BCA Virtual Mall/brand-category-dinamis',["car":carCategory]))

int carNameElement = WebUI.getElementLeftPosition(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/Page_Partner Dealer Mobil Baru - KKB BCA Virtual Mall/car-name',["carName":carName]))

WebUI.scrollToElement(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/Page_Partner Dealer Mobil Baru - KKB BCA Virtual Mall/car-name',["carName":carName]), 0)
WebUI.executeJavaScript("window.scrollBy(0,-100)", null)
WebUI.click(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/Page_Partner Dealer Mobil Baru - KKB BCA Virtual Mall/car-name',["carName":carName]))

WebUI.click(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/Page_Partner Dealer Mobil Baru - KKB BCA Virtual Mall/dealer/span_Dealer Terdekat Pilihan Anda'))

WebUI.setText(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/Page_Partner Dealer Mobil Baru - KKB BCA Virtual Mall/searchBar',['class':'select2-search__field','placeholder':'Cari Dealer']),dealerName)

WebUI.click(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/Page_Partner Dealer Mobil Baru - KKB BCA Virtual Mall/select-option',["dealerName":dealerName]))

//index ini menunjukan action button yang bakal di redirect ke situs page index
//1 : AJUKAN KREDIT, 2: SIMULASI

WebUI.click(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/Page_Partner Dealer Mobil Baru - KKB BCA Virtual Mall/button-dinamis',["index":"1"]))

'SIMULASI KREDIT'

WebUI.scrollToElement(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/Page_Partner Dealer Mobil Baru - KKB BCA Virtual Mall/text-object',["text":"Kredit"]),5,OPTIONAL)

// list yang berkolerasi diwajibkan mempunyai length yang sama
String tipeSimulasi = "credit"
String[] textFields = ["hargaDiskon","uangMuka","kodepromo","kodereferral"]
String[] textValues =[harga_kendaraan,uang_muka,kode_promo,kode_referral];


/*data yang dimasukan harus sesuai
 * tipe_konsumen : perorangan atau badan usaha
 * asuransi: rscc+rsmb+budgetTjh25Jt (boleh kosong)
 * nasabah_prioritas : a(Ya) atau b(Tidak) 
 * kode_referral : ref1(Ya) atau ref2(Tidak)
 * */
String[] radioButton = [tipe_konsumen, asuransi, nasabah_prioritas, kode_referral]

for(def j = 0; j<4;j++) {
	switch(j) {
	case 0:
		WebUI.click(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/simulasi-field/radioButtonDanCheckBox-simulasi',["id":'perorangan']))
		break;
	case 1:
		String[] tipeAsuransi = radioButton[j].toString().split('\\+')
		for( x in tipeAsuransi) {
			WebUI.click(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/simulasi-field/radioButtonDanCheckBox-simulasi',["id":x]),OPTIONAL)
		}
		break;
	default:
		WebUI.click(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/simulasi-field/radioButtonDanCheckBox-simulasi',["id":radioButton[j]]))
		break;
	}
	WebUI.setText(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/simulasi-field/simulasi-field-dinamis',["tipeSimulasi":tipeSimulasi,"name":textFields[j]]), textValues[j],OPTIONAL)
}
WebUI.click(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/simulasi-field/simulasikan'))

WebUI.click(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/simulasi-field/tenor-button-dinamis',["tenor":tenor]),0)

String[] fieldSummary = ['cst_name','cst_phone','cst_email','dealer_sales','dealer_phone'];
String[] fieldValues = [cst_name, cst_phone, cst_email, dealer_sales, dealer_phone]

for(def j =0;j<5;j++) {
	WebUI.setText(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/simulasi-field/fieldKontak',["fieldName":fieldSummary[j]]),fieldValues[j].toString())
}
WebUI.click(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/simulasi-field/fieldKontak',["fieldName":"agree"]))
//formAction variable hanya berisi "Submit" atau "Kembali"
WebUI.click(findTestObject('Object Repository/virtual-mall/partner kami dan pengajuan/Page_Partner Dealer Mobil Baru - KKB BCA Virtual Mall/text-object',["text":formAction]))
