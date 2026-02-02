package keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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
import internal.GlobalVariable

public class MobileBaseConfig {

	static Map<String, Object> getMobileConfig() {
		
		String appPackage 		= GlobalVariable.G_AppPackage?.toString()?.trim()
		Integer delayDuration 	= (GlobalVariable.G_DelayDuration ?: 2) as Integer
		String projectDir 		= RunConfiguration.getProjectDir()
		String screenshotDir 	= GlobalVariable.G_ScreenshotDirectory?.toString()?.trim()
		
		if(!appPackage) {
			KeywordUtil.markWarning("G_AppPackage kosong, pakai default")
			appPackage = 'com.sweatco'
		}
		
		if (!screenshotDir) {
			screenshotDir = "/Screenshot/"
		}
		

		return [
			"APP_PACKAGE"		: appPackage,
			"PROJECT_DIR" 		: projectDir,
			"SCREENSHOT_DIR" 	: screenshotDir,
			"DELAY_DURATION" 	: delayDuration
		]
	}
}
