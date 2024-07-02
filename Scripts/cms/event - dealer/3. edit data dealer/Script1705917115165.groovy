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
import java.util.concurrent.ThreadLocalRandom;

String baseDir = System.getProperty('user.dir')

WebUI.delay(1)

WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), nama_event)

WebUI.delay(1)

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 10 nama terisi') +
	'.png', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/CMS/Page_Master Event/Page_Master Event/button-edit'))

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 10 edit page') +
		'.png', FailureHandling.STOP_ON_FAILURE)

//WebUI.click(findTestObject('Object Repository/CMS/Page_Event Dealer/edit_data/checkbox_dealer',['index':1]))

String[] dealers = dealer_names.toString().split('\\+')

for(dealer in dealers) {
	WebUI.setText(findTestObject('Object Repository/CMS/Page_Event Dealer/edit_data/input_Nama Dealer_myInputTextField'),dealer)
	WebUI.click(findTestObject('Object Repository/CMS/Page_Event Dealer/edit_data/checkbox_dealer',['index':2]))
	WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 10 checklist dealer-' + dealer.toString()) +
			'.png', FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('Object Repository/CMS/Page_Event Dealer/edit_data/button_Submit'))

WebUI.delay(1)

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 10 data berhasil diubah') +
	'.png', FailureHandling.STOP_ON_FAILURE)

