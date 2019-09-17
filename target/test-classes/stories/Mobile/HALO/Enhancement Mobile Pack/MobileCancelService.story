Story: Account Creation
Meta:@MobileCancelService
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account
  
  
Scenario:EnhRDisconnect01 HALO R1.0_Mobile_Product and services_TS26_Disconnect a Service
Meta:@EnhRDisconnect01
@FolderName EnhRDisconnect01
@ankita
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithin16Days'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculator'
And Compare Line Items 'ClickNext'
And Enter Disconnection Reason And click Next
And Confirm Order

Scenario:EnhMobileCancelService14 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS14_Future disconnection (raise Service Request) SOU-6219_PAYM_Call Centre_After calculate button was pressed_Account overview
Meta:@EnhMobileCancelService14
@FolderName EnhMobileCancelService14
@Ankita
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculatorFutureDisconnection'
Then Perform for scenario 'SRRowIdCapture' and perform About Record
When ReLogin with 'ADMIN' in 'Env'
And Navigate To Jobs
And Create New Jobs 'PopVFChangesDisconnect'
And Performs 'SRRowID'
And Perform scenario for 'CaptureJobId' in Jobs
And Perform scenario for 'QueryWithJobIDandCheckforSuccessStatus' in Jobs
When ReLogin with 'AGENT01' in 'Env'
When Search The Account ''
When Create new order 'NoNewNoPopUp'


Scenario:EnhMobileCancelService08 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS08_Future disconnection (raise Service Request) SOU-6219_PAYM_Call Centre_Product & services overview
Meta:@EnhMobileCancelService08
@FolderName EnhMobileCancelService08
@Ankita
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'DisconnectionFeeCalculatorFutureDisconnection'
Then Perform for scenario 'SRRowIdCapture' and perform About Record
When ReLogin with 'ADMIN' in 'Env'
And Navigate To Jobs
And Create New Jobs 'PopVFChangesDisconnect'
And Performs 'SRRowID'
And Perform scenario for 'CaptureJobId' in Jobs
And Perform scenario for 'QueryWithJobIDandCheckforSuccessStatus' in Jobs
When ReLogin with 'AGENT01' in 'Env'
When Search The Account ''
When Create new order 'NoNewNoPopUp'

Scenario: MobileCancelService01 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS01_Initiate Disconnection Fee calculation (SOU-6212)_Account overview 
Meta:@MobileCancelService01
@FolderName MobileCancelService01
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'ValidateDisconnectionInViews'

Scenario: MobileCancelService02 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS02_Initiate Disconnection Fee calculation (SOU-6212)_Product & Services overview
Meta:@MobileCancelService02
@FolderName MobileCancelService02
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ValidateDisconnectionInViewsProductServices'

Scenario: MobileCancelService03 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS03_Disconnection options with SR disconnection_Account overview
Meta:@MobileCancelService03
@FolderName MobileCancelService03
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithin16Days'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculatorFutureDisconnection'
Then Perform for scenario 'SRRowIdCapture' and perform About Record
When ReLogin with 'ADMIN' in 'Env'
And Navigate To Jobs
And Create New Jobs 'PopVFChangesDisconnect'
And Performs 'SRRowID'
And Perform scenario for 'CaptureJobId' in Jobs
And Perform scenario for 'QueryWithJobIDandCheckforSuccessStatus' in Jobs
When ReLogin with 'AGENT01' in 'Env'
When Search The Account ''
When Create new order 'NoNewNoPopUp'


Scenario: MobileCancelService05 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS05_Disconnection options with Immediate disconnection_Account overview 
Meta:@MobileCancelService05
@FolderName MobileCancelService05
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithin16Days'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculator'
And Compare Line Items 'ClickNext'
And Enter Disconnection Reason And click Next
And Confirm Order

Scenario: MobileCancelService07 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS07_Future disconnection (raise Service Request) SOU-6219_PAYM_Retail_Account overview
Meta:@MobileCancelService07
@FolderName MobileCancelService07
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithin16Days'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculatorFutureDisconnection'
Then Perform for scenario 'SRRowIdCapture' and perform About Record
When ReLogin with 'ADMIN' in 'Env'
And Navigate To Jobs
And Create New Jobs 'PopVFChangesDisconnect'
And Performs 'SRRowID'
And Perform scenario for 'CaptureJobId' in Jobs
And Perform scenario for 'QueryWithJobIDandCheckforSuccessStatus' in Jobs
When ReLogin with 'AGENT01' in 'Env'
When Search The Account ''
When Create new order 'NoNewNoPopUp'

Scenario: MobileCancelService08 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS08_Future disconnection (raise Service Request) SOU-6219_PAYM_Call Centre_Product & services overview
Meta:@MobileCancelService08
@FolderName MobileCancelService08
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithin16Days'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'DisconnectionFeeCalculatorFutureDisconnection'
Then Perform for scenario 'SRRowIdCapture' and perform About Record
When ReLogin with 'ADMIN' in 'Env'
And Navigate To Jobs
And Create New Jobs 'PopVFChangesDisconnect'
And Performs 'SRRowID'
And Perform scenario for 'CaptureJobId' in Jobs
And Perform scenario for 'QueryWithJobIDandCheckforSuccessStatus' in Jobs
When ReLogin with 'AGENT01' in 'Env'
When Search The Account ''
When Create new order 'NoNewNoPopUp'

Scenario: MobileCancelService09 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS09_Future disconnection (raise Service Request) SOU-6219_To show invalid date pop-up
Meta:@MobileCancelService09
@FolderName MobileCancelService09
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculatorInvalidateDate'


Scenario: MobileCancelService10 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS10_Future disconnection (raise Service Request) SOU-6219_Click of Next - Blocking message for Insufficient permission level 
Meta:@MobileCancelService10
@FolderName MobileCancelService10
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContactforStoreCollection'
When Search The OUI Account 'GoToAccountLinkforPermissionStoreCollection' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionInsufficientPopupValidationFutureDisc'

Scenario: MobileCancelService11 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS11_Future disconnection (raise Service Request) SOU-6219_Click of Next - Blocking message for Open Order Check 
Meta:@MobileCancelService11
@FolderName MobileCancelService11
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithin16Days'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Execute query 'Tokenization'
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculator'
And Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
And Click on Next Button
When Confirm Order
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionOpenOrderPopupValidationFutureDisc'

Scenario: MobileCancelService15 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS15_Future disconnection (raise Service Request) SOU-6219_PAYM_Call Centre_After Disconnection fee calculator - Go Back.
Meta:@MobileCancelService15
@FolderName MobileCancelService15
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculatorGoBack'

Scenario: MobileCancelService21 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS\21_Port-out request (provide PAC) (SOU-6217)_PAYM_Call Centre_Account overview
Meta:@MobileCancelService21
@FolderName MobileCancelService21
@SumiT
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionPortOutPAC'

Scenario: MobileCancelService26  HALO R2.0_Sprint 33_Mobile_Cancel Service_TS26_Immediate disconnection (SOU-6220)_
		  PAYM - MBB_Retail_Product & services overview
Meta:@MobileCancelService26
@Vaishnavi
@FolderName MobileCancelService26
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerMBB'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Execute query 'Tokenization'
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculator'
And Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
And Click on Next Button
When Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete

Scenario: MobileCancelService27  HALO R2.0_Sprint 33_Mobile_Cancel Service_TS27_Immediate disconnection (SOU-6220)_
		  PAYG_Retail_Account overview
Meta:@MobileCancelService27
@Vaishnavi
@FolderName MobileCancelService27
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Execute query 'Tokenization'
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculator'
And Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
And Click on Next Button
When Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete

Scenario: MobileCancelService25  HALO R2.0_Sprint 33_Mobile_Cancel Service_TS25_Immediate disconnection (SOU-6220)_PAYM - Mobile_Retail_Account overview
Meta:@MobileCancelService25
@Vaishnavi
@FolderName MobileCancelService25
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithin16Days'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Execute query 'Tokenization'
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculator'
And Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
And Click on Next Button
When Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete

Scenario: MobileCancelService28 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS28_Immediate disconnection (SOU-6220)_PAYM - Mobile_Call Centre_Product & services overview 
Meta:@MobileCancelService28
@FolderName MobileCancelService28
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithin16Days'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'DisconnectionFeeCalculatorImmediateDisc'
When Compare Line Items 'ClickNext'
And Enter Disconnection Reason And click Next
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete


Scenario: MobileCancelService31 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS31_Immediate disconnection (SOU-6220)_Click of Next on disconnect_ETF pop up applet - Blocking message for Insufficient permission level 
Meta:@MobileCancelService31
@FolderName MobileCancelService31
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContactforStoreCollection'
When Search The OUI Account 'GoToAccountLinkforPermissionStoreCollection' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionInsufficientPopupValidationImmediateDisc'

Scenario: MobileCancelService32 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS32_Immediate disconnection (SOU-6220)_Click of Next on disconnect_ETF pop up applet - Blocking message for Open Order Check 
Meta:@MobileCancelService32
@FolderName MobileCancelService32
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculator'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionOpenOrderPopupValidationImmediateDisc'

Scenario: MobileCancelService35 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS35_Cancel Service - Discard Order 
Meta:@MobileCancelService35
@FolderName MobileCancelService35
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithin16Days'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculator'
And Compare Line Items 'ClickNext'
And Discard Order

Scenario: MobileCancelService36 HALO R2.0_Sprint 33_Mobile_Cancel Service_TS36_Error Modal if Disconnection Reason not selected 
Meta:@MobileCancelService36
@FolderName MobileCancelService36
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculator'
And Compare Line Items 'ClickNext'
And Validate Disconnection Popup for no reason mentioned
