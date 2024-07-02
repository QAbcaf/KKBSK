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

WebUI.openBrowser('https://expo.idofocus.co.id:19443/spk/login/index')

WebUI.setText(findTestObject('Object Repository/Web EMAS expo object/id-object',['id':'username']),userId)

WebUI.setText(findTestObject('Object Repository/Web EMAS expo object/id-object',['id':'password']),password)

WebUI.click(findTestObject('Object Repository/Web EMAS expo object/id-object',['id':'login']))

WebUI.click(findTestObject('Object Repository/Web EMAS expo object/id-object',['id':'show-hide-sidebar-toggle']))

WebUI.click(findTestObject('Object Repository/Web EMAS expo object/text-object',["text":"SPK Offline"]))

WebUI.click(findTestObject('Object Repository/Web EMAS expo object/href-object',["link":"https://expo.idofocus.co.id:19443/spk/Offline/Approval"]))

WebUI.setText(findTestObject('Object Repository/Web EMAS expo object/name-object',["name":"nospkdealer"]),no_spk_dealer)

WebUI.click(findTestObject('Object Repository/Web EMAS expo object/id-object',['id':'btnSearch']))

WebUI.click(findTestObject("Object Repository/Web EMAS expo object/xpath-object",["xpath":"//*[text()='"+ no_spk_dealer +"']/following-sibling::td/form/button"]))

String[] labels = [
'Nama Sesuai KTP*',
'NIK*',
'Tanggal Lahir*',
'Nomor SPK Dealer*',
'Tanggal SPK*',
'Merk*',
'Nama Dealer*',
'Model*',
'Jumlah Unit*',
'OTR/Unit*',
'Diskon/Unit*',
'Harga Nett/Unit*',
'Tanda Jadi Total*',
'No Appr Code*',
'Tanggal Tanda Jadi*',
'Nama Sales Dealer',
'No. Telepon Sales Dealer']

String okOrNotOk = '1'
for(label in labels) {
	WebUI.click(findTestObject("Object Repository/Web EMAS expo object/xpath-object",["xpath":"//*[text()='${label}']//following-sibling::div//input[${okOrNotOk}]"]))
}

WebUI.click(findTestObject('Object Repository/Web EMAS expo object/id-object',['id':'app']))

WebUI.click(findTestObject('Object Repository/Web EMAS expo object/text-object',["text":"SPK Offline"]))

WebUI.click(findTestObject('Object Repository/Web EMAS expo object/href-object',["link":"https://expo.idofocus.co.id:19443/spk/Offline/Inquiry"]))

WebUI.setText(findTestObject('Object Repository/Web EMAS expo object/name-object',["name","srcNoSPK"]),no_spk_dealer)

WebUI.setText(findTestObject('Object Repository/Web EMAS expo object/name-object',["name","srcNamaSPK"]),nama_lengkap_konsumen)

WebUI.click(findTestObject('Object Repository/Web EMAS expo object/id-object',['id':'btnSearch']))

WebUI.click(findTestObject('Object Repository/Web EMAS expo object/text-object',["text":"Report"]))

WebUI.click(findTestObject('Object Repository/Web EMAS expo object/href-object',["link":"https://expo.idofocus.co.id:19443/spk/Offline/Reports/SPK"]))

WebUI.setText(findTestObject('Object Repository/Web EMAS expo object/class-object',['class':'select2-search__field']),kcu_kanwil)

WebUI.setText(findTestObject('Object Repository/Web EMAS expo object/id-object',['id':'periode_from']),dari_tanggal)

WebUI.setText(findTestObject('Object Repository/Web EMAS expo object/id-object',['id':'periode_to']),sampai_tanggal)

WebUI.click(findTestObject('Object Repository/Web EMAS expo object/value-object',['value':'Export to Excel']))







