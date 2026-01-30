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
	static String getScreenshotDirectory(String parentFolder = "", String customName = "", String childFolder = "", String subFolder1 = "", String subFolder2 = "", String subFolder3 = "") {
		def config 					= MobileBaseConfig.getMobileConfig()
		String baseDir 				= config.SCREENSHOT_PATH?.toString()?.trim() ?: "${RunConfiguration.getProjectDir()}/Screenshots/"
		if (!baseDir.startsWith("/")) baseDir = "/" + baseDir
		if (!baseDir.endsWith("/")) baseDir = baseDir + "/"

		String projectDir 			= RunConfiguration.getProjectDir()
		String currentTestCaseName 	= RunConfiguration.getExecutionSourceName()
		String filteredTestCaseName = currentTestCaseName.split("/")[-1]

		String parentSegment 		= parentFolder	? 	"${parentFolder}/" 	: ""
		String customSegment 		= customName	? 	"${customName}/" 	: ""
		String childSegment 		= childFolder	? 	"${childFolder}/" 	: ""
		String subFolder1Segment 	= subFolder1	? 	"${subFolder1}/" 	: ""
		String subFolder2Segment 	= subFolder2	? 	"${subFolder2}/" 	: ""
		String subFolder3Segment	= subFolder3	?	"${subFolder3}/" 	: ""

		String path 				= "${projectDir}${baseDir}${parentSegment}${customSegment}${childSegment}${subFolder1Segment}${subFolder2Segment}${subFolder3Segment}${filteredTestCaseName}/"
		path 						= path.replaceAll(/[\/]+/, "/")

		try {
			Path directoryPath = Paths.get(path)
			Files.createDirectories(directoryPath)
		} catch (Exception e) {
			println "! ERROR create screenshot folder: ${e.message}"
		}

		return path.endsWith("/") ? path : path + "/"
	}
}