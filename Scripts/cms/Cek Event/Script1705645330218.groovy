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

'Get directory project'
String baseDir = System.getProperty('user.dir')

//Event - Dealer
WebUI.click(findTestObject('CMS/Page_Dashboard/sidebar-dashboard'))

WebUI.click(findTestObject('CMS/Page_Dashboard/click-Event - Dealer'))

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 4.1 Event - Dealer') +
	'.png', FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), nama_event)

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 4.2 Event - Dealer - Search') +
	'.png', FailureHandling.STOP_ON_FAILURE)

//Event - Kanwil
WebUI.click(findTestObject('CMS/Page_Dashboard/sidebar-dashboard'))

WebUI.click(findTestObject('CMS/Page_Dashboard/span_Master Data'))

WebUI.click(findTestObject('Object Repository/CMS/Page_Dashboard/click-Event - Kanwil - KCU'))

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 4.3 Event - Kanwil') +
	'.png', FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), nama_event)

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 4.4 Event - Kanwil - Search') +
	'.png', FailureHandling.STOP_ON_FAILURE)
