Story: Epic_8395
Meta:@Epic_8395
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account
 

Scenario: AppDirectBilling_12 VFUKE-8395 VFUS-1593_TS05_TC03_Validate that agent able to place future Disconnection in Enablement if no active subscriptions are present in App Direct for Account type-Major
Meta:@AppDirectBilling_12
@FolderName AppDirectBilling_12
@Bushra
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


Scenario: AppDirectBilling_13 VFUKE-8395 VFUS-1593_TS06_TC01_Validate that agent able to place Immediate Disconnection in Enhancement if no active subscriptions are present in App Direct for Account type-Regional
Meta:@AppDirectBilling_13
@Bushra
@FolderName AppDirectBilling_13
Given Place screenshots in Folder 'FolderName'
Given Login with 'CUSTREL' in 'Env'
When Create the account type 'SmallBusinessPostRegionalCharityOnline'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
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


Scenario: AppDirectBilling_14 VFUKE-8395 VFUS-1593_TS06_TC02_Validate that agent able to place Future Disconnection in Enhancement if no active subscriptions are present in App Direct for Account type-Major
Meta:@AppDirectBilling_14
@Bushra
@FolderName AppDirectBilling_14
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


Scenario: AppDirectBilling_15 VFUKE-8395 VFUS-1593_TS07_TC01_Validate that agent should not able to add more than one App Direct plan
Meta:@AppDirectBilling_15
@Bushra
@FolderName AppDirectBilling_15
Given Place screenshots in Folder 'FolderName'
Given Login with 'CUSTREL' in 'Env'
When Create OUI account type 'SmallBusEnhMajorPartnership'
And Update Promotion 'VCSMProduct111902' for 'AddAppDirectPromofromSoftwareAndDonotNavigate' in OUI
And Update Promotion 'VCSMProduct111902' for 'AddSecondAppDirectPromValidatePopUpClickNext' in OUI
When Check for Columns in 'CheckforAppDirectPromo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete


Scenario: AppDirectBilling_18 VFUKE-6934 _AppDirect Integration Phase 2B_Drop6_TS01_Validate that CreateCustomerSystemUserAccount should be called for New acquisition journey
Meta:@AppDirectBilling_18
@Bushra
@FolderName AppDirectBilling_18
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


Scenario: AppDirectBilling_19 VFUKE-6934 _AppDirect Integration Phase 2B_Drop6_TS01_Validate that CreateCustomerSystemUserAccount should be called for New acquisition journey
Meta:@AppDirectBilling_19
@Bushra
@FolderName AppDirectBilling_19
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


Scenario: AppDirectBilling_18_Part1 - VFUKE-8395 VFUS-1593_TS08_Validate that agent should able to update email address of Major and Regional account
Meta:@AppDirectBilling_18_Part1
@Zeba
@FolderName AppDirectBilling_18_Part1
Given Place screenshots in Folder 'FolderName'
Given Login with 'CUSTREL' in 'Env'
When Create the account type 'SmallBusinessPostMajorCharityOnline'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'SoftwareAndServicesAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveRootPSoftwareAndServices'
When Search The Account ''
When Update Email Account
Then Validate Cust Comms Message 'EmailValidationInCustomerComms'


Scenario: AppDirectBilling_18_Part2 - VFUKE-8395 VFUS-1593_TS08_Validate that agent should able to update email address of Major and Regional account
Meta:@AppDirectBilling_18_Part2
@FolderName AppDirectBilling_18_Part2
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'CUSTREL' in 'Env'
When Create the account type 'SmallBusinessRegionalPublicOnline'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'SoftwareAndServicesAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveRootPSoftwareAndServices'
When Search The Account ''
When Update Email Account
Then Validate Cust Comms Message 'EmailValidationInCustomerComms'

Scenario: AppDirectBilling_19_Part1 - VFUKE-8395 VFUS-1593_TS09_Validate that VF Account Secondary DPA Check View must be present for Major and Regional accouny types
Meta:@AppDirectBilling_19_Part1
@Zeba
@FolderName AppDirectBilling_19_Part1
Given Place screenshots in Folder 'FolderName'
Given Login with 'CUSTREL' in 'Env'
When Create the account type 'SmallBusinessPostMajorCharityOnline'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'SoftwareAndServicesAdd'
When Search The Account ''
And Retrieve Promotion 'VCSMProduct111902'
When Validate the rows in different views 'SecondaryDPATabClick'

Scenario: AppDirectBilling_19_Part2 - VFUKE-8395 VFUS-1593_TS09_Validate that VF Account Secondary DPA Check View must be present for Major and Regional accouny types
Meta:@AppDirectBilling_19_Part2
@Zeba
@FolderName AppDirectBilling_19_Part2
Given Place screenshots in Folder 'FolderName'
Given Login with 'CUSTREL' in 'Env'
When Create the account type 'SmallBusinessRegionalPublicOnline'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'SoftwareAndServicesAdd'
When Search The Account ''
And Retrieve Promotion 'VCSMProduct111902'
When Validate the rows in different views 'SecondaryDPATabClick'

