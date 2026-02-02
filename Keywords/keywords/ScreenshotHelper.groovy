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
import keywords.MobileBaseConfig
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path
import internal.GlobalVariable

public class ScreenshotHelper {

	@Keyword
	static String getScreenshotDirectory(String parentFolder = "", String customName = "", String childFolder = "") {
		def config 					= MobileBaseConfig.getMobileConfig()
		
		String projectDir 			= RunConfiguration.getProjectDir()
		String screenshotDir 		= config.SCREENSHOT_DIR?.toString()?.trim() ?: "/Screenshots/"
		
		String currentTestCaseName 	= RunConfiguration.getExecutionSourceName()
		String filteredTestCaseName = currentTestCaseName.split("/")[-1] ?: "UnknownTestCase"

		Path path = Paths.get(
			projectDir,
			screenshotDir,
			parentFolder,
			customName,
			childFolder,
			filteredTestCaseName
		).normalize()

		try {
			Files.createDirectories(path)
		} catch (Exception e) {
			println "! ERROR create screenshot folder: ${e.message}"
		}

		return path.toString()
	}
}