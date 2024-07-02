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
import java.time.*;


'Get directory project'
String baseDir = System.getProperty('user.dir')

WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), kode_event)

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 6.1 Master Event(Edit)') + 
    '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('CMS/Page_Master Event/Page_Master Event/button-edit'))

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 6.2 Master Event(Edit) - Popup') +
	'.png', FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('CMS/Page_Master Event/input_Nama Event_name'), nama_event)

WebUI.click(findTestObject('Object Repository/CMS/Page_Master Event/button_SUBMIT'))

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 6.3 Master Event(Edit) - Popup - Unsuccess') +
	'.png', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/CMS/Page_Master Event/Page_Master Event/button_CANCEL'))

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 6.4 Master Event(Edit)') +
	'.png', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('CMS/Page_Master Event/Page_Master Event/button-edit'))

'sampai tanggal'
WebUI.click(findTestObject('Object Repository/CMS/Page_Master Event/click_Sampai Tanggal'))

String year='2050',month = 'Feb', day='10';
int yearInt = 2050
Date date = new Date();
LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
String currentYear = localDate.getYear().toString();
int yearDiff = (yearInt - localDate.getYear())/10
WebUI.click(findTestObject('CMS/Page_Master Event/input_Dari Tanggal'))

WebUI.click(findTestObject('Object Repository/CMS/Page_Master Event/Page_Master Event/year-and-month-switch'))

WebUI.click(findTestObject('Object Repository/CMS/Page_Master Event/Page_Master Event/year-switch',['currentYear':currentYear]))

while(true) {
	String yearRange = WebUI.getText(findTestObject('Object Repository/CMS/Page_Master Event/Page_Master Event/th_2020-2029'))
	String[] yearRangeList = yearRange.split("-")
	System.out.println(yearRangeList)
	if(yearRangeList[1] < year) {
		WebUI.click(findTestObject('Object Repository/CMS/Page_Master Event/Page_Master Event/th_',))
	}
	WebUI.click(findTestObject('Object Repository/CMS/Page_Master Event/Page_Master Event/month-year',['index':year]))
	WebUI.click(findTestObject('Object Repository/CMS/Page_Master Event/Page_Master Event/month-year',['index':month]))
	WebUI.click(findTestObject('Object Repository/CMS/Page_Master Event/Page_Master Event/day',['index':day]))
	break;
}

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 6.5 Master Event(Edit) - Popup Edit Sampai Tanggal') +
	'.png', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/CMS/Page_Master Event/button_SUBMIT'))

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 6.6 Master Event(Edit)') +
	'.png', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/CMS/Page_Master Event/Page_Master Event/button_ok'), 0)

WebUI.click(findTestObject('Object Repository/CMS/Page_Master Event/Page_Master Event/button_ok'))


