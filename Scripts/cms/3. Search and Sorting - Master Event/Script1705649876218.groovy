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

WebUI.click(findTestObject('CMS/Page_Dashboard/sidebar-dashboard'))

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.1 Dashboard - Sidebar') + 
    '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('CMS/Page_Dashboard/Master Event'))

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.2 Master Event - Search') + 
    '.png', FailureHandling.STOP_ON_FAILURE)

'valid - kode event'
WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), GlobalVariable.kode_event)

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.3 Master Event - Search - Valid kode event') + 
    '.png', FailureHandling.STOP_ON_FAILURE)

'non valid - kode event'
WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), non_valid_kodeEvent)

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.4 Master Event - Search - Non Valid kode event') + 
    '.png', FailureHandling.STOP_ON_FAILURE)

'Valid Nama Event'
WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), nama_event)

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.5 Master Event - Search - Valid nama event') + 
    '.png', FailureHandling.STOP_ON_FAILURE)

'non valid - kode event'
WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), 'testing1')

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.6 Master Event - Search - Non Valid nama event') + 
    '.png', FailureHandling.STOP_ON_FAILURE)

'Valid Lokasi'
WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), lokasi)

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.7 Master Event - Search - Valid lokasi') + 
    '.png', FailureHandling.STOP_ON_FAILURE)

'non valid - lokasi'
WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), 'Jonggol')

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.8 Master Event - Search - Non Valid lokasi') + 
    '.png', FailureHandling.STOP_ON_FAILURE)

'Dari Tanggal'
WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), dari_tanggal)

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.9 Master Event - Search - Dari Tanggal') + 
    '.png', FailureHandling.STOP_ON_FAILURE)

'Sampai Tanggal'
WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), sampai_tanggal)

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.10 Master Event - Search - Sampai Tanggal') + 
    '.png', FailureHandling.STOP_ON_FAILURE)

'Status'
WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), 'Active')

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.10 Master Event - Search - Status (active)') + 
    '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), 'Inactive')

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.10 Master Event - Search - Status (inactive)') +
	'.png', FailureHandling.STOP_ON_FAILURE)

'Sorting'
WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), '')

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.11 Master Event - Before Sorting') + 
    '.png', FailureHandling.STOP_ON_FAILURE)

'Sorting - Kode Event'

WebUI.click(findTestObject('CMS/Page_Master Sorting/sorting_Nama Event'))

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.12 Master Event - Sorting - Kode Event') +
	'.png', FailureHandling.STOP_ON_FAILURE)

'Sorting - Nama Event'

WebUI.click(findTestObject('Object Repository/CMS/Page_Master Sorting/sorting_Nama Event'))

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.13 Master Event - Sorting - Nama Event') +
	'.png', FailureHandling.STOP_ON_FAILURE)

'Sorting - Lokasi'

WebUI.click(findTestObject('Object Repository/CMS/Page_Master Sorting/sorting_Lokasi'))

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.14 Master Event - Sorting - Lokasi') +
	'.png', FailureHandling.STOP_ON_FAILURE)

'Sorting - Dari Tanggal'

WebUI.click(findTestObject('Object Repository/CMS/Page_Master Sorting/sorting_Dari Tanggal'))

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.15 Master Event - Sorting - Dari Tanggal') +
	'.png', FailureHandling.STOP_ON_FAILURE)

'Sorting - Sampai Tanggal'

WebUI.click(findTestObject('Object Repository/CMS/Page_Master Sorting/sorting_Sampai Tanggal'))

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.15 Master Event - Sorting - Sampai Tanggal') +
	'.png', FailureHandling.STOP_ON_FAILURE)

'Sorting - Status'

WebUI.click(findTestObject('Object Repository/CMS/Page_Master Sorting/sorting_Status'))

WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 5.15 Master Event - Sorting - Status') +
	'.png', FailureHandling.STOP_ON_FAILURE)