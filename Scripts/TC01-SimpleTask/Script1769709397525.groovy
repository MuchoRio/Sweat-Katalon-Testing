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

AppManager.launchApp()

def mobileBaseConfig 	= MobileBaseConfig.getMobileConfig()
int delay 				= mobileBaseConfig.DELAY_DURATION

Mobile.waitForElementPresent(findTestObject('Object Repository/Dashboard/01. ViewGroup - userAvatar'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.delay(delay)

Mobile.tap(findTestObject('Object Repository/Dashboard/01. ViewGroup - userAvatar'), delay, FailureHandling.STOP_ON_FAILURE)

boolean isHeaderProfilSayaPresent = Mobile.waitForElementPresent(findTestObject('Object Repository/Dashboard/Profile/02. TextView - Profil saya'), delay, FailureHandling.OPTIONAL)
boolean isHeaderProfilSayaExist = Mobile.verifyElementText(findTestObject('Object Repository/Dashboard/Profile/02. TextView - Profil saya'), 'Profil saya', FailureHandling.OPTIONAL)

if(isHeaderProfilSayaPresent || isHeaderProfilSayaExist) {
	KeywordUtil.markPassed("Berhasil menemukan Header Profil Saya!")
} else {
	KeywordUtil.markFailed("Gagal menemukan Header Profil Saya")
}

Mobile.enhancedScrollToText(findTestObject('Object Repository/Dashboard/Profile/02. TextView - 3-Day Streak'), '3-Day Streak', delay)

Mobile.tap(findTestObject('Object Repository/Dashboard/Profile/02. ViewGroup - Rewards'), delay, FailureHandling.STOP_ON_FAILURE)

Mobile.pressBack()

Mobile.enhancedScrollToText(findTestObject('Object Repository/Dashboard/Profile/02. TextView - Profil saya'), 'Profil saya', delay)

Mobile.tap(findTestObject('Object Repository/Dashboard/Profile/02. ViewGroup - Edit Profile'), delay, FailureHandling.STOP_ON_FAILURE)

boolean isHeaderEditProfilPresent = Mobile.waitForElementPresent(findTestObject('Object Repository/Dashboard/Profile/Edit/03. TextView - Edit profil'), delay, FailureHandling.OPTIONAL)
boolean isHeaderEditProfilExist = Mobile.verifyElementText(findTestObject('Object Repository/Dashboard/Profile/Edit/03. TextView - Edit profil'), 'Edit profil', FailureHandling.OPTIONAL)

if(isHeaderEditProfilPresent || isHeaderEditProfilExist) {
	KeywordUtil.markPassed("Berhasil menemukan Header Edit profil!")
} else {
	KeywordUtil.markFailed("Gagal menemukan Header Edit profil")
}

Mobile.setText(findTestObject('Object Repository/Dashboard/Profile/Edit/03. EditText - Deskripsi'), 'Test', delay, FailureHandling.STOP_ON_FAILURE)

Mobile.pressBack()

Mobile.tap(findTestObject('Object Repository/Dashboard/Profile/Edit/03. ViewGroup - Simpan Perubahan'), delay, FailureHandling.STOP_ON_FAILURE)

if(isHeaderProfilSayaPresent || isHeaderProfilSayaExist) {
	KeywordUtil.markPassed("Berhasil menemukan Header Profil Saya!")
} else {
	KeywordUtil.markFailed("Gagal menemukan Header Profil Saya")
}

