package com.page;

import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.testBase.TestBase;

public class AdduserPage extends TestBase {

	public AdduserPage() {

		PageFactory.initElements(driver, this);
	}

	public static final Logger logger = Logger.getLogger(LoginPage.class.getName());
	@CacheLookup
	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
	WebElement pimMod;

	@FindBy(id = "menu_pim_viewEmployeeList")
	WebElement employeeClick;

	@FindBy(id = "btnAdd")
	WebElement addEMPclick;

	@FindBy(id = "firstName")
	WebElement addFname;

	@FindBy(id = "middleName")
	WebElement addMname;

	@FindBy(id = "lastName")
	WebElement addLname;

	@FindBy(id = "photofile")
	WebElement profilepic;

	@FindBy(id = "chkLogin")
	WebElement checkboxLogin;

	@FindBy(id = "user_name")
	WebElement uname;

	@FindBy(id = "user_password")
	WebElement upass;

	@FindBy(id = "re_password")
	WebElement cuPass;

	@FindBy(id = "btnSave")
	WebElement clickbtnSave;

	@FindBy(xpath = "//h1[normalize-space()='Employee Information']")
	WebElement onEmpInfopageassert;

	@FindBy(xpath = "//input[@value='Edit' and @id='btnSave']")
	WebElement editPdetail;

	@FindBy(id = "personal_optGender_1")
	WebElement male;

	@FindBy(id = "personal_optGender_2")
	WebElement female;

	@FindBy(id = "personal_cmbMarital")
	WebElement openDMstatus;

	@FindBy(xpath = "//option[@value='Married']")
	WebElement statusM;

	@FindBy(xpath = "//option[@value='Single']")
	WebElement statusS;

	@FindBy(xpath = "//option[@value='Other']")
	WebElement statusO;

	@FindBy(id = "personal_cmbNation")
	WebElement nationality;

	@FindBy(xpath = "//option[@value='82']")
	WebElement selectIND;

	@FindBy(id = "personal_DOB")
	WebElement eDOB;

	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement save;

	@FindBy(xpath = "//ul[@id='sidenav']//a[contains(text(),'Job')]")
	WebElement job;

	@FindBy(xpath = "//input[@value='Edit' and @id='btnSave']")
	WebElement ejob;

	@FindBy(xpath = "//select[@id='job_job_title']")
	WebElement jobTitle;

	@FindBy(xpath = "//option[normalize-space()='QA Lead']")
	WebElement selecQAL;

	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement saveJob;

	public void navigateToempinfo() throws InterruptedException {
		Thread.sleep(10000);
		pimMod.click();
	}

	public void verifyEmpPage() {
		if (onEmpInfopageassert.isDisplayed())
			logger.info("Navigated to Emp info page");

	}

	public void createEmployee(String addFname, String addMname, String addLname, String uname, String upass,
			String cuPass, String gender, String mStatus, String sNationality, String dateObirth) {
		try {
			Thread.sleep(10000);

			addEMPclick.click();

			checkboxLogin.click();

			this.addFname.sendKeys(addFname);
			logger.info("first name :" + addFname);

			this.addMname.sendKeys(addMname);
			logger.info("Middle Name" + addMname);

			this.addLname.sendKeys(addLname);
			logger.info("Last Name" + addLname);

			profilepic.sendKeys(
					"D:\\Abhijeet\\WebAutomations\\OrangeHRM\\src\\main\\resources\\configFiles\\download.jpg");
			System.out.println(profilepic);
			logger.info("added profile file");
			this.uname.sendKeys(uname);
			this.upass.sendKeys(upass);
			this.cuPass.sendKeys(cuPass);
			Thread.sleep(3000);

			clickbtnSave.click();

			Thread.sleep(3000);
			editPdetail.click();

			if (gender.equals("Male")) {
				male.click();
				logger.info("Updated as" + gender);
			} else if (gender.equals("female")) {
				female.click();
				logger.info("updated as " + gender);
			} else {
				logger.info("no gender specified ");
			}

			Select maritial = new Select(openDMstatus);
			openDMstatus.click();
			maritial.selectByVisibleText(mStatus);

			Select country = new Select(nationality);
			nationality.click();
			country.selectByVisibleText(sNationality);
			eDOB.clear();
			eDOB.sendKeys(dateObirth);
			Thread.sleep(3000);
			save.click();
			Thread.sleep(3000);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addJobDetals(String Jtitle) throws InterruptedException {
		Thread.sleep(3000);
		job.click();
		ejob.click();
		Select sjobTitle = new Select(jobTitle);
		Thread.sleep(3000);
		jobTitle.click();
		String job = selecQAL.getText();
		System.out.println("Job is " + job);
		sjobTitle.selectByVisibleText(job);
		saveJob.click();
		driver.quit();
	}

}
