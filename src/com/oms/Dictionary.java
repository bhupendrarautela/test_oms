package com.oms;

 class Dictionary {
	 
	 //Testing Domains
	
	 public static String OMS_Test_URL="http://localhost/css/angular-inventory/#/login/";

	//Login page Locaters
	public static String xPath_UserNameTextBox="//input[@type='text']";
	public static String xPath_PasswordTextBox="//input[@type='password']";
	public static String xPath_LoginSubmitButton="//button[@type='submit']";
	public static String xPath_UserNameValidation="//button[@type='submit']";
	public static String xPath_PasswordValidation="//button[@type='submit']";

	//Reset Password
	public static String LinkName_ForgrtPasswordLink="Forgot password";
	public static String PageText_ForgrtPasswordScreen="Please enter your registered email id below";
	public static String xPath_ResetPasswordTextBox = "//input[@type='text']";
	public static String xPath_ResetPasswordButton = "//button[@type='submit']";
	
	//Register User
	public static String LinkName_RegisterNewUser="Sign Up";
	public static String PageText_RegisterTitle="Register";
	public static String xPath_RegisterEmailTextBox="//*[contains(@placeholder,'Email')]";
	public static String xPath_RegisterMobileTextBox="//*[contains(@placeholder,'Mobile')]";
	public static String xPath_RegisterFirstNameTextBox="//*[contains(@placeholder,'First')]";
	public static String xPath_RegisterLastNameTextBox="//*[contains(@placeholder,'Last')]";
	public static String xPath_RegisterPasswordTextBox="//*[contains(@placeholder,'Password')]";
	public static String xPath_RegisterPassword2TextBox="//*[contains(@placeholder,'Confirm')]";
	public static String xPath_RegisterCheckBox="//i[@class='cr-icon fa fa-check']]";
	
	//Header
	public static String xPath_Hedaer_Links ="//a[@class='ng-binding']";
	
	
	
	public static String Add_New_Order="//button[@type='button' and contains(., 'Add New User')]";
  
}
