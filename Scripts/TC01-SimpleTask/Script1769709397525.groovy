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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import keywords.AppManager
import keywords.MobileBaseConfig
import keywords.ScreenshotHelper

AppManager.launchApp()

def mobileBaseConfig 	= MobileBaseConfig.getMobileConfig()
int delay 				= mobileBaseConfig.DELAY_DURATION
def screenshotPath 		= ScreenshotHelper.getScreenshotDirectory("Sweat", "Test Case", "Positive Test Case")
//
//AtomicInteger screenshotCounter = new AtomicInteger(1)

Mobile.delay(delay)

//Mobile.takeScreenshot(screenshotPath + String.format("%02d.png", screenshotCounter.getAndIncrement()))

Mobile.takeScreenshot(screenshotPath + '01.png')

Mobile.tap(findTestObject('Object Repository/Dashboard/01. ViewGroup - Circle Avatar'), delay, FailureHandling.STOP_ON_FAILURE)

boolean isHeaderProfilSayaPresent = Mobile.waitForElementPresent(findTestObject('Object Repository/Dashboard/Profile/02. TextView - Profil saya'), delay, FailureHandling.OPTIONAL)
boolean isHeaderProfilSayaExist = Mobile.verifyElementText(findTestObject('Object Repository/Dashboard/Profile/02. TextView - Profil saya'), 'Profil saya', FailureHandling.OPTIONAL)

if(isHeaderProfilSayaPresent || isHeaderProfilSayaExist) {
	KeywordUtil.markPassed("Berhasil menemukan Header Profil Saya!")
	
	Mobile.takeScreenshot(screenshotPath + '02.png')
} else {
	KeywordUtil.markFailed("Gagal menemukan Header Profil Saya")
}

Mobile.scrollToText('3-Day Streak')


Mobile.takeScreenshot(screenshotPath + '03.png')

Mobile.tap(findTestObject('Object Repository/Dashboard/Profile/02. ViewGroup - Rewards'), delay, FailureHandling.STOP_ON_FAILURE)


Mobile.takeScreenshot(screenshotPath + '04.png')

Mobile.tap(findTestObject('Object Repository/Dashboard/Profile/02. ViewGroup - Close'), delay, FailureHandling.STOP_ON_FAILURE)


Mobile.takeScreenshot(screenshotPath + '05.png')

Mobile.tap(findTestObject('Object Repository/Dashboard/Profile/02. ViewGroup - Edit Profile'), delay, FailureHandling.STOP_ON_FAILURE)

boolean isHeaderEditProfilPresent = Mobile.waitForElementPresent(findTestObject('Object Repository/Dashboard/Profile/Edit/03. TextView - Edit profil'), delay, FailureHandling.OPTIONAL)
boolean isHeaderEditProfilExist = Mobile.verifyElementText(findTestObject('Object Repository/Dashboard/Profile/Edit/03. TextView - Edit profil'), 'Edit profil', FailureHandling.OPTIONAL)

if(isHeaderEditProfilPresent || isHeaderEditProfilExist) {
	KeywordUtil.markPassed("Berhasil menemukan Header Edit profil!")
	
	Mobile.takeScreenshot(screenshotPath + '06.png')
} else {
	KeywordUtil.markFailed("Gagal menemukan Header Edit profil")
}

Mobile.setText(findTestObject('Object Repository/Dashboard/Profile/Edit/03. EditText - Deskripsi'), 'Test', delay, FailureHandling.STOP_ON_FAILURE)

Mobile.pressBack()


Mobile.takeScreenshot(screenshotPath + '07.png')

Mobile.tap(findTestObject('Object Repository/Dashboard/Profile/Edit/03. ViewGroup - Simpan Perubahan'), delay, FailureHandling.STOP_ON_FAILURE)

if(isHeaderProfilSayaPresent || isHeaderProfilSayaExist) {
	KeywordUtil.markPassed("Berhasil menemukan Header Profil Saya!")
	
	Mobile.takeScreenshot(screenshotPath + '08.png')
} else {
	KeywordUtil.markFailed("Gagal menemukan Header Profil Saya")
}

