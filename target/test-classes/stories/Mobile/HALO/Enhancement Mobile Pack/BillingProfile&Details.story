Story: Bill Overview
Meta:@BillOverViewStory
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account

Scenario: BillingProfile&Details01 HALO R2.0_Billing Profile & Details_TS01_Navigate to Billing Profiles for an Account - By using secondary navigation
Meta:@BillingProfile&Details01
@FolderName BillingProfile&Details01
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Perform 'BillHistoryDrilldown' in Billing View
When Perform 'BillHistory' in Billing View
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckViewAllBills'


Scenario: BillingProfile&Details03 HALO R2.0_Billing Profile & Details_TS03_Enhanced view for Billing Profiles
Meta:@BillingProfile&Details03
@FolderName BillingProfile&Details03
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckViewAllBills'

Scenario: BillingProfile&Details04 HALO R2.0_Billing Profile & Details_TS04_Billing Profiles List
Meta:@BillingProfile&Details04
@FolderName BillingProfile&Details04
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'BillingList'


Scenario: BillingProfile&Details05 HALO R2.0_Billing Profile & Details_TS05_Go to Bill History (SOU-4907)
Meta:@BillingProfile&Details05
@FolderName BillingProfile&Details05
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'ConsFLADSL'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Perform 'BillHistoryDrilldown' in Billing View
When Perform 'BillHistory' in Billing View

Scenario: BillingProfile&Details02 HALO R2.0_Billing Profile & Details_TS02_Navigate to Billing Profiles for an Account - By clicking on View all bill profiles button
Meta:@BillingProfile&Details02
@FolderName BillingProfile&Details02
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckViewAllBills'


Scenario: BillingProfile&Details06 HALO R2.0_Billing Profile & Details_TS06_Create New Billing Profile (SOU-4941) Postpaid 
Meta:@BillingProfile&Details06
@FolderName BillingProfile&Details06
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CompareValuesofBillingandBillingProfiles'
Then Billing Profiles validation for 'CreateNewPostpaid'
Then Billing Profiles validation for 'ValidateActiveStatusofNew'

Scenario: BillingProfile&Details07 HALO R2.0_Billing Profile & Details_TS07_Create New Billing Profile (SOU-4941) Prepaid 
Meta:@BillingProfile&Details07
@FolderName BillingProfile&Details07
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CompareValuesofBillingandBillingProfiles'
Then Billing Profiles validation for 'CreateNewPrepaid'


Scenario: BillingProfile&Details08 HALO R2.0_Billing Profile & Details_TS08_Blocking Message should be thrown If agent does not select the profile type and tries to save the billing profile. 
Meta:@BillingProfile&Details08
@FolderName BillingProfile&Details08
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Billing Profiles validation for 'SaveWithoutselectingBillingType'


Scenario: BillingProfile&Details10 HALO R2.0_Billing Profile & Details_TS10_Billing Profile Details - Prepaid 
Meta:@BillingProfile&Details10
@FolderName BillingProfile&Details10
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CompareValuesofBillingandBillingProfiles'
Then Billing Profiles validation for 'CreateNewPrepaid'

Scenario: BillingProfile&Details11 HALO R2.0_Billing Profile & Details_TS11_Billing Profile Details - Postpaid 
Meta:@BillingProfile&Details11
@FolderName BillingProfile&Details11
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CompareValuesofBillingandBillingProfiles'
Then Billing Profiles validation for 'CreateNewPostpaid'
Then Billing Profiles validation for 'ValidateActiveStatusofNew'


Scenario: BillingProfile&Details14 HALO R2.0_Billing Profile & Details_TS14_Payment Method - Cash
Meta:@BillingProfile&Details14
@FolderName BillingProfile&Details14
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CreateNewPrepaid'



Scenario: BillingProfile&Details15 HALO R2.0_Billing Profile & Details_TS16_Payment Method - Balance
Meta:@BillingProfile&Details15
@FolderName BillingProfile&Details15
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'BillingProfileForPrepaidBalance'


Scenario: BillingProfile&Details16 HALO R2.0_Billing Profile & Details_TS17_Payment Method - Bill Me
Meta:@BillingProfile&Details16
@FolderName BillingProfile&Details16
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'BillingProfileForPrepaidBillMe'


Scenario: BillingProfile&Details19 HALO R2.0_Billing Profile & Details_TS24_Payment Method - Direct Debit_Update Bank Details
Meta:@BillingProfile&Details19
@FolderName BillingProfile&Details19
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'UpdateBankDetails'



Scenario: BillingProfile&Details20 HALO R2.0_Billing Profile & Details_TS25_Payment Method - Credit Account
Meta:@BillingProfile&Details20
@FolderName BillingProfile&Details20
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CreateNewPostpaidCreditAccount'


Scenario: BillingProfile&Details05 HALO R2.0_Billing Profile & Details_TS05_Go to Bill History (SOU-4907)
Meta:@BillingProfile&Details05
@FolderName BillingProfile&Details05
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'ConsFLADSL'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Perform 'BillHistory' in Billing View


Scenario: BillingProfile&Details34 HALO R2.0_Billing Profile & Details_TS39_Postpaid - Change Payment Method 
		  - Bill Me to Credit_Debit Card 
Meta:@BillingProfile&Details34
@Vaishnavi
@FolderName BillingProfile&Details34
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'BillMetoCredit/Debit_Card'
When Execute query 'Tokenization'


Scenario: BillingProfile&Details35 HALO R2.0_Billing Profile & Details_TS40_Postpaid - Change Payment Method 
		  - Bill Me to Direct Debit 
Meta:@BillingProfile&Details35
@Vaishnavi
@FolderName BillingProfile&Details35
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'BillMetoDirectDebit'


Scenario: BillingProfile&Details36 HALO R2.0_Billing Profile & Details_TS41_Postpaid - Change Payment Method 
		  - Credit_Debit Card to Bill Me
Meta:@BillingProfile&Details36
@Vaishnavi
@FolderName BillingProfile&Details36
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerCreditCard'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'Credit/Debit_CardtoBillMe'


Scenario: BillingProfile&Details37 HALO R2.0_Billing Profile & Details_TS41_Postpaid - Change Payment Method 
		  - Credit_Debit Card to Direct Debit
Meta:@BillingProfile&Details37
@Vaishnavi
@FolderName BillingProfile&Details37
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create New 'NewPostpaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PostpaidPromotion4G'
And Select Menu 'PromotionEditPackage'
And Add Product 'InseExc60gbp'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'Credit/Debit_CardtoDirectDebit'


Scenario: BillingProfile&Details38 HALO R2.0_Billing Profile & Details_TS41_Postpaid - Change Payment Method 
		  - Credit_Debit Card to Bill Me
Meta:@BillingProfile&Details38
@Vaishnavi
@FolderName BillingProfile&Details38
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerDirectDebit'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'DirectDebittoCredit/Debit_Card'
When Execute query 'Tokenization'


Scenario: BillingProfile&Details39 HALO R2.0_Billing Profile & Details_TS44_Prepaid - Change Payment Method 
		  - Cash to Credit_Debit Card
Meta:@BillingProfile&Details39
@Vaishnavi
@FolderName BillingProfile&Details39
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CashtoCredit/Debit_Card'
When Execute query 'Tokenization'

Scenario: BillingProfile&Details40 HALO R2.0_Billing Profile & Details_TS41_Postpaid - Change Payment Method 
		  - Cash to Debit Card
Meta:@BillingProfile&Details40
@Vaishnavi
@FolderName BillingProfile&Details40
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CashtoDirectDebit'


Scenario: BillingProfile&Details41 HALO R2.0_Billing Profile & Details_TS41_Postpaid - Change Payment Method 
		  - Debit Card to Cash
Meta:@BillingProfile&Details41
@Vaishnavi
@FolderName BillingProfile&Details41
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'DirectDebittoCash'

Scenario: BillingProfile&Details27 HALO R2.0_Billing Profile & Details_TS32_Legal Group Details (SOU-4906) Prepaid 
Meta:@BillingProfile&Details27
@FolderName BillingProfile&Details27
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'ValidateActiveStatusNotPopulated'

Scenario: BillingProfile&Details28 HALO R2.0_Billing Profile & Details_TS33_Legal Group Details (SOU-4906) Postpaid 
Meta:@BillingProfile&Details28
@FolderName BillingProfile&Details28
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'ValidateActiveStatusofNew'

Scenario: BillingProfile&Details29 HALO R2.0_Billing Profile & Details_TS34_Bill Format (SOU-4926_4939_4940) To show bill formats with one option selected for Postpaid billing profile 
Meta:@BillingProfile&Details29
@FolderName BillingProfile&Details29
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CompareValuesofBillingandBillingProfiles'
Then Billing Profiles validation for 'CreateNewPostpaid'
Then Billing Profiles validation for 'ValidateSMSCheckBox'

Scenario: BillingProfile&Details30 HALO R2.0_Billing Profile & Details_TS35_Bill Format (SOU-4926_4939_4940) To show multiple bill format option selected for Postpaid billing profile 
Meta:@BillingProfile&Details30
@FolderName BillingProfile&Details30
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CompareValuesofBillingandBillingProfiles'
Then Billing Profiles validation for 'CreateNewPostpaid'
Then Billing Profiles validation for 'ValidateSMSCheckBox'

Scenario: BillingProfile&Details31 HALO R2.0_Billing Profile & Details_TS36_Bill Format (SOU-4926_4939_4940) To show disable bill format for Prepaid billing profile 
Meta:@BillingProfile&Details31
@FolderName BillingProfile&Details31
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CompareValuesofBillingandBillingProfiles'
Then Billing Profiles validation for 'CreateNewPrepaid'
Then Billing Profiles validation for 'ValidateActiveStatusNotPopulated'
Then Billing Profiles validation for 'ValidateSMSCheckBoxNotEnabled'


Scenario: BillingProfile&Details17 HALO R2.0_Billing Profile & Details_TS19_Payment Method - Credit_Debit Card (Postpaid)
Meta:@BillingProfile&Details17
@FolderName BillingProfile&Details17
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CreateNewPostpaidCreditDebit'



Scenario: BillingProfile&Details18 HALO R2.0_Billing Profile & Details_TS23_Payment Method - Direct Debit
Meta:@BillingProfile&Details18
@FolderName BillingProfile&Details18
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CreateNewPostpaidDirectDebit'


Scenario: BillingProfile&Details23 HALO R2.0_Billing Profile & Details_TS28_Payment Method - Debit Card
Meta:@BillingProfile&Details23
@FolderName BillingProfile&Details23
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CreateNewPrepaidDebitCard'


Scenario: BillingProfile&Details25 HALO R2.0_Billing Profile & Details_TS30_Update_Remove Email from Billing Profile (SOU-4942)
Meta:@BillingProfile&Details25
@FolderName BillingProfile&Details25
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'UpdateAndRemoveEmailForBillingProfile'


Scenario: BillingProfile&Details33 HALO R2.0_Billing Profile & Details_TS38_Enhanced View for Audit Trail (SOU-4927)
Meta:@BillingProfile&Details33
@FolderName BillingProfile&Details33
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'RETAIL' in 'Env'
When Search The Account ''
Then Perform Audit Trail for Account View 'VerifyColumnsForOperation'
When Search The OUI Account 'AdvanceSearch' ''
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'AuditTrailEnh'
Then Perform Audit Trail for Account View 'VerifyColumnsForOperationforEnh'

Scenario: BillingProfile&Details26 HALO R2.0_Billing Profile & Details_TS31_Update contact on Billing Profile (SOU-4943)
Meta:@BillingProfile&Details26
@FolderName BillingProfile&Details26
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContact'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'UpdateContactForBillingProfile'



Scenario: BillingProfile&Details09 HALO R2.0_Billing Profile & Details_TS09_New Billing Profile modal
Meta:@BillingProfile&Details09
@FolderName BillingProfile&Details09
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CreateNewPostpaidBillingProfile'

