package keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil
import keywords.MobileBaseConfig

import internal.GlobalVariable

public class AppManager {

	@Keyword
	static void launchApp() {
		def config = MobileBaseConfig.getMobileConfig()
		String appPackage = config.APP_PACKAGE
		Integer delayDuration = config.DELAY_DURATION as Integer
		
		KeywordUtil.logInfo("Sedang menjalankan aplikasi: " + appPackage)
		Mobile.delay(delayDuration)
		
		try {
			Mobile.startExistingApplication(appPackage, FailureHandling.STOP_ON_FAILURE)
			KeywordUtil.markPassed("Aplikasi Berjalan Sempurna, melanjutkan ke Test Casenya!")
		} catch (Exception e) {
			KeywordUtil.markError("Aplikasi Tidak Ditemukan: " + appPackage + e.message)
		}
	}
}
