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

def uncheckOrCheckList(int kcuPertama) {
	WebUI.scrollToElement(findTestObject('Object Repository/CMS/event_kanwil/Page_Edit Event Kanwil KCU/span_KCU_body',['kanwil':kcuPertama.toString()]),0)
	int noKcu = ThreadLocalRandom.current().nextInt(1, 7)
	for(def i =0; i<noKcu; i++) {
		int randomUncheck = ThreadLocalRandom.current().nextInt(1, 7) + kcuPertama
				WebUI.click(findTestObject('Object Repository/CMS/event_kanwil/Page_Edit Event Kanwil KCU/span_KCU_body',['kanwil':randomUncheck.toString()]))
	}
}
int[] kcuIndex = [1,12,25,38,51,62,72,83,94,107,117,125,136]
String[] subSkenario = ['a','b','c']

for(def i = 0;i<3;i++) {
	WebUI.delay(1)
	
	WebUI.setText(findTestObject('CMS/Page_Dashboard/search bar'), nama_event)
	
	WebUI.delay(1)
	
	WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 13.1.' + subSkenario[i] + ' nama terisi') +
		'.png', FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('Object Repository/CMS/Page_Master Event/Page_Master Event/button-edit (1)'))
	
	
	WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 13.1.' + subSkenario[i] + ' default edit page') +
		'.png', FailureHandling.STOP_ON_FAILURE)
	
	switch(i) {
		case 0:
			int noKanwil = 1
			WebUI.click(findTestObject('Object Repository/CMS/event_kanwil/Page_Edit Event Kanwil KCU/span_Kanwil_body',['kanwil':noKanwil]))
		
			WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 13.2.' + subSkenario[i] + ' checklist 1 kanwil') +
				'.png', FailureHandling.STOP_ON_FAILURE)
		
			uncheckOrCheckList(kcuIndex[noKanwil-1])
			WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 13.3.' + subSkenario[i] +' unchecklist beberapa kcu') +
				'.png', FailureHandling.STOP_ON_FAILURE)
			break;
		case 1:
			int randomNum = ThreadLocalRandom.current().nextInt(1, 3);
			def randKcu = []
			for(def j = 0;j<randomNum;j++) {
				int randNum = ThreadLocalRandom.current().nextInt(1, 13);
				randKcu.add(randNum);
				WebUI.click(findTestObject('Object Repository/CMS/event_kanwil/Page_Edit Event Kanwil KCU/span_Kanwil_body',['kanwil':randNum]))
			}
			WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 13.2.' + subSkenario[i] +' checklist beberapa kanwil') +
				'.png', FailureHandling.STOP_ON_FAILURE)
			for(j in randKcu) {
				uncheckOrCheckList(kcuIndex[j-1])
			}
			WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 13.3.' + subSkenario[i] +' unchecklist beberapa kcu') +
				'.png', FailureHandling.STOP_ON_FAILURE)
			break;
		break;
		case 2:
			WebUI.click(findTestObject('Object Repository/CMS/event_kanwil/Page_Edit Event Kanwil KCU/span_Kanwil_cbx'))
			
			WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 13.2.' + subSkenario[i] +' checklist semua kanwil') +
				'.png', FailureHandling.STOP_ON_FAILURE)
			
			randomNum = ThreadLocalRandom.current().nextInt(1, 7);
			for(def j = 0;j<12;j++) {
				uncheckOrCheckList(kcuIndex[j])
				WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 13.3.'+subSkenario[i]+' unchecklist beberapa kcu ' + j) +
					'.png', FailureHandling.STOP_ON_FAILURE)
			}
		break;
	}
	WebUI.click(findTestObject('Object Repository/CMS/event_kanwil/submit-edit-data'))
	
	WebUI.delay(1)
	
	WebUI.takeScreenshot((((((baseDir + GlobalVariable.sspathP17) + '\\') + matriks) + '\\') + 'Skenario 13.4.' + subSkenario[i] + ' data berhasil diubah') +
		'.png', FailureHandling.STOP_ON_FAILURE)
}