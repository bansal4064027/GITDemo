Story: Epic_8395
Meta:@Epic_8395
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account


Scenario: AppDirectPhase2B_02 VFUKE-6934 _AppDirect Integration Phase 2B_Drop6_TS01_Validate that CreateCustomerSystemUserAccount should be called for New acquisition journey
Meta:@AppDirectPhase2B_02
@Bushra
@FolderName AppDirectPhase2B_02
Given Place screenshots in Folder 'FolderName'
Given Login with 'CUSTREL' in 'Env'
When Create OUI account type 'LtdCompany'
And Update Promotion 'VCSMProduct111902' for 'AddAppDirectPromofromSoftware' in OUI
And Create Personal Detail and Adress for 'LtdCompany'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Check for Columns in 'CheckforAppDirectPromo'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete



Scenario: AppDirectPhase2B_03 VFUKE-6934 _AppDirect Integration Phase 2B_Drop6_TS02_Validate that CreateCustomerSystemUserAccount should be called for New acquisition journey on existing account
Meta:@AppDirectPhase2B_03
@Bushra
@FolderName AppDirectPhase2B_03
Given Place screenshots in Folder 'FolderName'
Given Login with 'CUSTREL' in 'Env'
When Create OUI account type 'LtdCompany'
And Update Promotion 'VCSMProduct111902' for 'AddAppDirectPromofromSoftware' in OUI
And Create Personal Detail and Adress for 'LtdCompany'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Check for Columns in 'CheckforAppDirectPromo'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete


Scenario: AppDirectPhase2B_08 VFUKE-6934 _AppDirect Integration Phase 2B_Drop1_TS01_Immediate Disconnection in Enablement if no active subscriptions are present in App Direct 
Meta:@AppDirectPhase2B_08
@Payel
@FolderName AppDirectPhase2B_08
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusinessOnline'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'VCSMProduct111902'
Then Perform the action 'DisconnectWithPromotion'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'VCSMDelete'
When Perform the CustomerAccount
Then Verify the Product and Services for 'Null'


Scenario: AppDirectPhase2B_09 VFUKE-6934 _AppDirect Integration Phase 2B_Drop1_TS03_Immediate Disconnection in Enhancement or Halo if no active subscriptions are present in App Direct 
Meta:@AppDirectPhase2B_09
@Payel
@FolderName AppDirectPhase2B_09
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusinessOnline'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculator'
And Compare Line Items 'ClickNext'
And Enter Disconnection Reason And click Next
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete


Scenario: AppDirectPhase2B_10_VFUKE-6934 _AppDirect Integration Phase 2B_Drop1_TS05_Future Disconnection in Enhancement or Halo if no active subscriptions are present in App Direct  
Meta:@AppDirectPhase2B_10
@Payel
@FolderName AppDirectPhase2B_10
Given Place screenshots in Folder 'FolderName'
Given Login with 'CUSTREL' in 'Env'
When Create the account type 'SmallBusinessPostMajorCharityOnline'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculatorFutureDisconnection'
Then Perform for scenario 'SRRowIdCapture' and perform About Record
Then Perform validation in Service Request screen for scenario 'AddNextDateAsSLA'
When ReLogin with 'ADMIN' in 'Env'
And Navigate To Jobs
And Create New Jobs 'PopVFChangesDisconnect'
And Performs 'SRRowID'
And Perform scenario for 'CaptureJobId' in Jobs
And Perform scenario for 'QueryWithJobIDandCheckforSuccessStatus' in Jobs
When ReLogin with 'AGENT01' in 'Env'
When Search The Account ''
When Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete



Scenario: AppDirectPhase2B_11_VFUKE-6934 _AppDirect Integration Phase 2B_Drop1_TS07_TC01_Future Disconnection in Enablement if NO active subscriptions are present in App Direct-Service Request from account summary view  
Meta:@AppDirectPhase2B_11
@Payel
@FolderName AppDirectPhase2B_11
Given Place screenshots in Folder 'FolderName'
Given Login with 'CUSTREL' in 'Env'
When Create the account type 'SmallBusinessPostMajorCharityOnline'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'QPBO' in 'Env'
When Search The Account ''
And Create Service Request Type LOV for scenario 'CreateSRforFutureDisconnection' in Account Service Request path
Then Perform for scenario 'SRRowIdCapture' and perform About Record
Then Perform validation in Service Request screen for scenario 'AddNextDateAsSLA'
When ReLogin with 'ADMIN' in 'Env'
And Navigate To Jobs
And Create New Jobs 'PopVFChangesDisconnect'
And Performs 'SRRowID'
And Perform scenario for 'CaptureJobId' in Jobs
And Perform scenario for 'QueryWithJobIDandCheckforSuccessStatus' in Jobs
When ReLogin with 'RETAIL' in 'Env'
When Search The Account ''
When Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete




Scenario: AppDirectPhase2B_12_VFUKE-6934 _AppDirect Integration Phase 2B_Drop1_TS07_TC02_Future Disconnection in Enablement if NO active subscriptions are present in App Direct-Service request button below Billing profile  
Meta:@AppDirectPhase2B_12
@Payel
@FolderName AppDirectPhase2B_12
Given Place screenshots in Folder 'FolderName'
Given Login with 'CUSTREL' in 'Env'
When Create the account type 'SmallBusinessPostMajorCharityOnline'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'QPBO' in 'Env'
When Search The Account ''
And Create Service Request for scenario 'CreateSRforFutureDisconnection' in Account Summary view
Then Perform for scenario 'SRRowIdCapture' and perform About Record
Then Perform validation in Service Request screen for scenario 'AddNextDateAsSLA'
When ReLogin with 'ADMIN' in 'Env'
And Navigate To Jobs
And Create New Jobs 'PopVFChangesDisconnect'
And Performs 'SRRowID'
And Perform scenario for 'CaptureJobId' in Jobs
And Perform scenario for 'QueryWithJobIDandCheckforSuccessStatus' in Jobs
When ReLogin with 'RETAIL' in 'Env'
When Search The Account ''
When Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete


