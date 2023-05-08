![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
![mavensurefire Version](https://img.shields.io/badge/maven--surefire-3.0.0--M6-yellow.svg)
![mavenCompiler Version](https://img.shields.io/badge/maven--compiler-3.11.0-blue.svg)
![seleniumJava Version](https://img.shields.io/badge/selenium--java-4.9.0-success.svg)
![testng Version](https://img.shields.io/badge/testng-7.7.1-red.svg)
![apachePoiOoxml Version](https://img.shields.io/badge/apache--poi--ooxml-5.2.3-green.svg)
![apachePoi Version](https://img.shields.io/badge/apache--poi-5.2.3-orange.svg)
![jackson-databind Version](https://img.shields.io/badge/jackson--databind-2.14.2-brightgreen.svg)
![log4j Version](https://img.shields.io/badge/log4j-2.20.0-yellow.svg)
![extentreports Version](https://img.shields.io/badge/extentreports-5.0.9-blueviolet.svg)
![allurereports Version](https://img.shields.io/badge/allurereports-2.21.0-yellow.svg)
![javafaker Version](https://img.shields.io/badge/javafaker-1.0.2-blue.svg)
## Selenium Java - TestNG Test Automation Framework by Esma Yilmaz

![lambdaecommerceui](https://user-images.githubusercontent.com/118256580/236697889-eb7fbc64-2b2b-4e80-a108-00feb7386356.JPG)


**SOME FEATURES IN FRAMEWORK**

1. Run tests as parallel and sequential by using testng.xml suites
2. Run tests by Maven Commands
3. Supports Jenkins 
4. <ins>Local and Remote Driver supports</ins>
5. <ins> Docker compose supports</ins> 
6. Supports Maven Profiles
7. Supports Maven and Jenkins Parameter
8. Extent Report
9. Allure Report
10. <ins>Send Mail after the run test (Report information and HTML file attachment)</ins>
11. <ins>Telegram bot
12. <ins>Record video </ins>
13. Logging to Console, File and Rolling File
14. Screenshot test case and attached screenshots to Reports
15. Read data test from Excel and Json file (xlsx, csv, json,...)
16. Supports TestNG Listener for all critical actions
17. Supports global variables on properties files
18. Many configuration files for log4j and report tools
19. Utils files for BrowserUtils, DataDriven, Reports, Screenshots, Driver
20. Supports many software design patterns like 
    1. Page Object Model
    2. Singleton Pattern
    3. Dependency Injection
    4. PageFactory Design
    5. Thread Safe Mode for Driver and Reports
    6. Supports OOP Principles (Inheritance, Polymorphism, Abstraction, Encapsulation)

### **SYSTEM REQUIREMENTS**

- **JDK All version**
- Chrome , Firefox,  Edge, Safari Browser and their headless modes
- Setup **Allure**:
  https://mvnrepository.com/artifact/io.qameta.allure/allure-java-commons
  or
  )
  Download jar and setting Variable Environment as Java JDK

  ![image](https://user-images.githubusercontent.com/87883620/161661705-b8706957-5a26-4faf-8ddf-2f9aef78418e.png)

- **IntelliJ** is the best choice (to change JDK version)

![image](https://user-images.githubusercontent.com/87883620/161707184-7ad558f2-0d7d-4851-bfd6-2796d4e46593.png)

### **HOW TO USE**

**1. Run parallel the test case**

- Run Cucumber TestRunner from **src/test/java/anhtester/com/runners**
- Run Feature file (**src/test/resources/features/**)
- Run Feature in suite XML (**src/test/resources/suites/**)
- Run Feature from Maven pom.xml file
  (**mvn clean test**)

  ![image](https://user-images.githubusercontent.com/87883620/161658761-5040e527-b410-46b3-8697-3298523e201d.png)

**2. Cucumber Report**

![image](https://user-images.githubusercontent.com/87883620/194338092-1046970c-2ca4-40da-b0e8-b03f71656c09.png)


**3. Extent Report**

- Config from src/test/resources/extent.properties
- Config PDF from src/test/resources/pdf-config.yaml

![image](https://user-images.githubusercontent.com/87883620/194404333-306a6d53-514a-4229-ba47-f3c42e7cce1f.png)
![image](https://user-images.githubusercontent.com/87883620/194404351-706fb702-6efd-4783-bc1e-2b20c56c902a.png)

![image](https://user-images.githubusercontent.com/87883620/194403666-ad996860-6f53-426d-b606-609cd9689ede.png)
![image](https://user-images.githubusercontent.com/87883620/194403696-2ac21bc5-4855-49fa-8a39-c032f6f59d46.png)
![image](https://user-images.githubusercontent.com/87883620/194403721-96198d1b-b8fe-4058-9b16-403d0437f8ab.png)
![image](https://user-images.githubusercontent.com/87883620/194403743-55aa0e59-39c3-470e-92bf-14275ab2e502.png)


**4. Allure Report**

- Open Terminal: **_allure serve target/allure-results_**

![image](https://user-images.githubusercontent.com/87883620/161662507-9e4dc698-e452-4b43-a4f5-9808c81419a2.png)

- Insert **@Step("title/message")** above **_@Test_** or any **_Method_** in the project
- (As sample picture above step 3)

![image](https://user-images.githubusercontent.com/87883620/161657680-af29973d-4e52-451f-b1d6-40b12d182845.png)

![image](https://user-images.githubusercontent.com/87883620/161657689-10365747-ed8f-4ca8-9d84-8060514f216b.png)

**5. Send Mail after the run test**

- Config **true/false** in config.properties
  (**_src/test/resources/config/config.properties_**)
- send_email_to_users=**true** is enable send mail
- Config mail with email and password in **_src/main/java/anhtester/com/mail/EmailConfig.java_**
- Note: if Gmail, you use Password App

![image](https://user-images.githubusercontent.com/87883620/161658851-2aa41091-ac99-45d9-a79f-aaa828052efb.png)

![image](https://user-images.githubusercontent.com/87883620/194458308-18000685-6785-415f-9e0c-020ae6ed0ebf.png)


**6. Write Log to file**

- Call class: Log.info , Log.pass, Log.error,... (**Log** is a custom global class from Log4j2)
  (**_import anhtester.com.utils.Log.java_**)

![image](https://user-images.githubusercontent.com/87883620/161657858-d333ac1d-9e7b-4c1b-baac-151a237a1fa0.png)

**7. Record video and Screenshot**

- Setup in **_config.properties_** file
  (**_src/test/resources/config/config.properties_**)
- screenshot_passed_steps=yes or no
- screenshot_failed_steps=yes or no
- screenshot_skipped_steps=yes or no
- screenshot_all_steps=yes or no

  ![image](https://user-images.githubusercontent.com/87883620/161657881-5235139a-9982-43c0-ac37-09f22fff1206.png)

**8. Read data test from Excel file**

- Create function with annotaion **DataSupplier** on **_src/main/java/anhtester/com/utils/DataProviderUtils.java_**
- Call the name of **DataSupplier** above in the test cases as DataProvider of TestNG
- Read excel with Map and Hashtable

**9. Base function in the package**

- **_src/main/java/anhtester/com/utils_**
- **_src/main/java/anhtester/com/helpers_**

**10. Read data test from JSON file**

- **JsonUtils** class select the json file path and call **"get"** method with **key**

**11. Main keyword is WebUI**

- WebUI class is main keyword in Framework. It contains common functions
- How to use: WebUI.function_name
- Example: WebUI.setWindowSize(1024, 768), WebUI.screenshotElement(By by, String elementName),...

**12. Call test case sample**

- Run test case TestNG: src/test/java/anhtester/com/projects/website/crm/testcases
- Run test case Gherkin: src/test/resources/suites/RunSuiteFeature.xml
- Or run with maven in **pom.xml** file:  ***mvn clean test***

```
+ src/test/resources/suites/RunSuiteFeature.xml
+ ClientTest
+ SignInTest
+ TestHandle
+ TestSimpleCode
```

### Project structure

```
📦src
 ┣ 📂main
 ┃ ┗ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂kodlanir
 ┃ ┃ ┃ ┃ ┗ 📜App.java
 ┗ 📂test
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂kodlanir
 ┃ ┃ ┃ ┃ ┣ 📂listeners
 ┃ ┃ ┃ ┃ ┃ ┣ 📜AllureReportListener.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜ExtentReportListener.java
 ┃ ┃ ┃ ┃ ┣ 📂pages
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Annotations.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Base.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Homepage.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PomManager.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜RegisterPage.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜SuccessPage.java
 ┃ ┃ ┃ ┃ ┣ 📂tests
 ┃ ┃ ┃ ┃ ┃ ┣ 📜DummyTest.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜RegisterTests.java
 ┃ ┃ ┃ ┃ ┗ 📂utils
 ┃ ┃ ┃ ┃ ┃ ┣ 📜BrowserUtils.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Config.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Driver.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ExcelUtils.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜JsonUtils.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜OutUtils.java
 ┃ ┗ 📂resources
 ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┣ 📜config.properties
 ┃ ┃ ┃ ┗ 📜log4j2.xml
 ┃ ┃ ┣ 📂data
 ┃ ┃ ┃ ┣ 📜data.csv
 ┃ ┃ ┃ ┣ 📜data.json
 ┃ ┃ ┃ ┗ 📜data.xlsx
 ┃ ┃ ┣ 📂files
 ┃ ┃ ┣ 📂images
 ┃ ┃ ┣ 📂logs
 ┃ ┃ ┃ ┣ 📜app.log
 ┃ ┃ ┃ ┗ 📜prints.log
 ┃ ┃ ┣ 📂reports
 ┃ ┃ ┗ 📂suites
 ┃ ┃ ┃ ┣ 📜regression.xml
 ┃ ┃ ┃ ┗ 📜smoke.xml
```

### I shall write document for my Framework. Coming soon...

## Copyright 2022 Anh Tester

> Kodlanir Tester Blog: https://kodlanir.com/

![Alt text](https://anhtester.com/uploads/logo/anhtester_logo_512.png?raw=true "Anh Tester - Automation Testing")
