Story: Cancel Order
Meta:@VFUKE-8602_FTTH_HALO
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to perform Cancel Order
  
Scenario: FLProgHALO01 Agent Places a FTTH new connection order through HALO(Enhancement). 
Meta:@FLProgHALO01
@FolderName FLProgHALO01
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'QP' in 'Env'
When Create OUI account type 'PostpaidConsumerFixLine'
And Get Address 'BlankStandardFTTH'
And Click on Fixed Line Check Avilibility for 'BlankStandardFTTH'
And Filter Promotion for Enhancement 'BlankStdFTTHGigafast100unlmtdBroad'
And Create Personal Detail and Adress for 'PostpaidConsumerFixLine'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Click on Generate New Number
And Click on Book Appointment
And Click on Terms and Condition
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: FLProgHALO02 Agent Places a FTTH new connection order through HALO(Enhancement). 
Meta:@FLProgHALO02
@FolderName FLProgHALO02
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'QP' in 'Env'
When Create OUI account type 'PostpaidConsumerFixLine'
And Get Address 'BlankExtendedStandardFTTH'
And Click on Fixed Line Check Avilibility for 'BlankExtendedStandardFTTH'
And Filter Promotion for Enhancement 'BlankExtdStdFTTHGigafast500unlmtdBroad'
And Create Personal Detail and Adress for 'PostpaidConsumerFixLine'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Click on Generate New Number
And Click on Book Appointment
And Click on Terms and Condition
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: FLProgHALO03 Agent Places a FTTH port-in new connection  order through HALO(Enhancement).
Meta:@FLProgHALO03
@FolderName FLProgHALO03
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'QP' in 'Env'
When Create OUI account type 'PostpaidConsumerFixLine'
And Get Address 'BlankStandardFTTHPortIn'
And Click on Fixed Line Check Avilibility for 'BlankStandardFTTHPortIn'
And Filter Promotion for Enhancement 'BlankStandardFTTHPortInGigafast100unlmtdBroad'
And Create Personal Detail and Adress for 'PostpaidConsumerFixLine'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Click on Generate New Number
And Click on Book Appointment
And Click on Terms and Condition
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order


Scenario: FLProgHALO04 Agent Places a FTTH port-in new connection  order through HALO(Enhancement).
Meta:@FLProgHALO04
@FolderName FLProgHALO04
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'QP' in 'Env'
When Create OUI account type 'PostpaidConsumerFixLine'
And Get Address 'BlankStandardFTTHPortIn'
And Click on Fixed Line Check Avilibility for 'BlankStandardFTTHPortIn'
And Filter Promotion for Enhancement 'BlankStandardFTTHPortInGigafast900unlmtdBroad'
And Create Personal Detail and Adress for 'PostpaidConsumerFixLine'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Click on Generate New Number
And Click on Book Appointment
And Click on Terms and Condition
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: FLProgHALO05DU Agent Places a FTTH new connection order through HALO(Enhancement). 
Meta:@FLProgHALO05DU
@FolderName FLProgHALO05DU
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'QP' in 'Env'
When Create OUI account type 'PostpaidConsumerFixLine'
And Get Address 'BlankExtendedStandardFTTH'
And Click on Fixed Line Check Avilibility for 'BlankExtendedStandardFTTH'
And Filter Promotion for Enhancement 'BlankExtdStdFTTHGigafast500unlmtdBroad18mnth'
And Create Personal Detail and Adress for 'PostpaidConsumerFixLine'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Click on Generate New Number
And Click on Book Appointment
And Click on Terms and Condition
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: FLProgHALO05 Agent Delete Static IP For FTTH order via HALO and check that order is completed in Siebel and in OSM
Meta:@FLProgHALO05
@FolderName FLProgHALO05
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithGigaFast500'
Given Login with 'QP' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'Customise'
When Econfig Item 'FixBroadServStaticIPOn'
And Compare Line Items 'FixBroadServStaticIPAdd'
And Order Details Capture in Order Summary page
And Confirm Order

Scenario: FLProgHALO06DU Agent Places a FTTH new connection order through HALO(Enhancement). 
Meta:@FLProgHALO06DU
@FolderName FLProgHALO06DU
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'QP' in 'Env'
When Create OUI account type 'PostpaidConsumerFixLine'
And Get Address 'BlankExtendedStandardFTTH'
And Click on Fixed Line Check Avilibility for 'BlankExtendedStandardFTTH'
And Filter Promotion for Enhancement 'BlankExtdStdFTTHGigafast900unlmtdBroad18mnth'
And Create Personal Detail and Adress for 'PostpaidConsumerFixLine'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Click on Generate New Number
And Click on Book Appointment
And Click on Terms and Condition
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: FLProgHALO06 Agent modifies Directory enquiry from DIRECTORY_ENQUIRIES_ONLY to EX_DIRECTORY_NO_CALLS_OFFERED for FTTH via HALO
Meta:@FLProgHALO06
@FolderName FLProgHALO06
@Zeba
!-- Need to select dropdown validation
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithGigaFast900'
Given Login with 'QP' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'Customise'
When Econfig Item 'Int300On'
And Compare Line Items 'FixLineInt300Add'
And Order Details Capture in Order Summary page
And Confirm Order

Scenario: FLProgHALO07 Agent modify Fixed Line Service to add International 300  Bundle.
Meta:@FLProgHALO07
@FolderName FLProgHALO07
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithGigaFast900'
Given Login with 'QP' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'Customise'
When Econfig Item 'Int300On'
And Compare Line Items 'FixLineInt300Add'
And Order Details Capture in Order Summary page
And Confirm Order

Scenario: FLProgHALO08 Agent places a immediate disconnection for ftth order via Halo 
Meta:@FLProgHALO08
@FolderName FLProgHALO08
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithGigaFast900'
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