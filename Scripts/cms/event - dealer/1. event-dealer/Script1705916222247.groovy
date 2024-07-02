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

String baseDir = System.getProperty('user.dir')

WebUI.click(findTestObject('CMS/Page_Dashboard/sidebar-dashboard'))
WebUI.takeScreenshot((((baseDir + GlobalVariable.sspathP17) + '\\') + 'Skenario 12.1 Dashboard - Sidebar') +
		'.png', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/CMS/event_kanwil/sub_menu_dinamis',['index':'event_mapping_dealer']))

WebUI.takeScreenshot((((baseDir + GlobalVariable.sspathP17) + '\\') + 'Skenario 12.1 Menu - Event - kanwil') +
	'.png', FailureHandling.STOP_ON_FAILURE)