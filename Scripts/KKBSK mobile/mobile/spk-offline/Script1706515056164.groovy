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

//Mobile.startExistingApplication('bcaf.crm.kkb.saleskit')

Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/menu-utama-opsi-atas',['title':'SPK Offline']),0)

try {
Mobile.verifyElementExist(findTestObject('Object Repository/Mobile KKBSK Object/tutup'), 5)
Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/tutup'), 0)
}catch(e) {
}
Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/registrasi-spk-dealer'),0)

Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/Add New SPK'),0)

try {
	Mobile.verifyElementExist(findTestObject('Object Repository/Mobile KKBSK Object/tutup'), 5)
	Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/tutup'), 0)
	}catch(e) {
	}

Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/event-dropdown'),0)

Mobile.setText(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/cari-event'),nama_event,0)

Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/option-dinamis',['nama_event':nama_event]),0)

Mobile.swipe(540, 1104, 540, 666)

String[] foto = ['ktp','spk','tanda_jadi','fap','others'];
int i =1;
for(tipeFoto in foto) {
	Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/foto-dinamis',['tipe':tipeFoto]),0)
	Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/galeri'),0)
	Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/pictures'),0)
	Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/foto-galeri-dinamis (2)',['index':i]),0)
	Mobile.swipe(540, 1104, 540, 666)
	Mobile.swipe(540, 1104, 540, 666)
	Mobile.swipe(540, 1104, 540, 666)
	Mobile.swipe(540, 1104, 540, 666)
	Mobile.swipe(540, 1104, 540, 666)
	Mobile.swipe(540, 1104, 540, 666)
	i++;
}

//TODO tambah test step buat lanjut ke hal berikut
Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/button-lanjut',['textButton':'Lanjut']),0)

Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/field_data_marketer_dinamis',['field':'kcu_kcp']),0)

Mobile.setText(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/cari-event'),kcu_kcp,0)

Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/option-dinamis',['nama_event':kcu_kcp]),0)

Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/field_data_marketer_dinamis',['field':'nip_marketer']),0)

Mobile.setText(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/cari-event'),nip_marketer,0)

Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/nama_marketer',['nama_marketer':nip_marketer]),0)

Mobile.swipe(540, 1104, 540, 666)
Mobile.swipe(540, 1104, 540, 666)

Mobile.setText(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/setTextFieldDinamis',['field':'nama_lengkap']),nama_lengkap_konsumen,0)

Mobile.setText(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/setTextFieldDinamis',['field':'nik_konsumen']),nik_konsumen,0)

//format DD-MM-YYYY
Mobile.setText(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/setTextFieldDinamis',['field':'tgl_lahir']),dob,0)

//bool harus berbentuk yes|no
Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/radio-button-nasabah-prioritas',['index':bool_nasabah_prioritas]),0)

Mobile.swipe(540, 1104, 540, 666)
Mobile.swipe(540, 1104, 540, 666)

Mobile.setText(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/setTextFieldDinamis',['field':'nomor_telepon']),nomor_telephone,0)

Mobile.setText(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/setTextFieldDinamis',['field':'email']),email,0)

Mobile.swipe(540, 1104, 540, 666)
Mobile.swipe(540, 1104, 540, 666)

Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/button-lanjut',['textButton':'Lanjut']),0)

String[] fields = ['no_spk_dealer','tanggal_spk',	'merk', 'nama_dealer','model',
	'jumlah_unit','delivery_order','otr','diskon','tanda_jadi','approval_code','tanggal_tanda_jadi',
	'nama_sales', 'no_telp_sales']
String[] fieldsValue = [no_spk_dealer,tanggal_spk,	merk, nama_dealer,model,
	jumlah_unit,delivery_order,otr,diskon,tanda_jadi,approval_code,tanggal_tanda_jadi,
	nama_sales, no_telp_sales]
for (def j=0;j<fields.length;j++) {
	if(j in [2,3,4,6]) {
		Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/field_data_marketer_dinamis',['field':fields[j]]),0)
		
		Mobile.setText(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/cari-event'),fieldsValue[j],0)
		
		Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/option-dinamis',['nama_event':fieldsValue[j]]),0)
		
	}else {
		Mobile.setText(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/setTextFieldDinamis',['field':fields[j]]),fieldsValue[j],0)
	}
	Mobile.swipe(540, 1104, 540, 666)
}
Mobile.swipe(540, 1104, 540, 666)
Mobile.swipe(540, 1104, 540, 666)
Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/button-lanjut',['textButton':'Submit']),0)
Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/button_konfirmasi'),0)
Mobile.tap(findTestObject('Object Repository/Mobile KKBSK Object/SPK offline/registrasi spk dealer/button-lanjut',['textButton':'Tutup']),0)
