package com.kodlanir.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class OutUtils {

    // Screenshots page or element (4.0)
    private static final Logger log = LogManager.getLogger(OutUtils.class);

    public static String takeScreenShotPage(String testName) {
        TakesScreenshot ss = (TakesScreenshot) Driver.getDriver();
        File src = ss.getScreenshotAs(OutputType.FILE);
        String destFile = "./src/test/resources/images/" + testName + ".png";
        try {
            FileUtils.copyFile(src, new File(destFile));
        } catch (Exception ex) {
            System.out.println("Ss Error : " + ex);
        }

        return relativeToAbsolutePath("src/test/resources/images", testName + ".png"); // ./src/test/resources/images/abc.png -> relative path
    }

    public static String takeFullScreenshot(String fileName)//Ashot
    {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(Driver.getDriver());

        String dynFileName = "screenshot-" + System.currentTimeMillis() + "-" + fileName + ".png";
        // File ssPath = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\images\\" + fileName);
        File ssPath = new File(relativeToAbsolutePath("src/test/resources/images", dynFileName));

        try {
            ImageIO.write(screenshot.getImage(), "PNG", ssPath);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return ssPath.toString();
    }

    // Reports, ExtentReport or Allure

    //static ExtentReports extent;


    public static ExtentReports getExtentReportObject() {
        // ExtentReports, ExtentSparkReporter
        //String path = System.getProperty("user.dir") + "\\src\\test\\resources\\reports\\extent_index.html";

        String fileName = DateUtils.getCurrentDateTimeCustom("_")+ "_extent_report" +  ".html";
        // gives you absolute path :
        String path = relativeToAbsolutePath("src/test/resources/reports", fileName);

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

        reporter.config().setReportName("Web Automation Test Results");
        reporter.config().setDocumentTitle("Web Automation Test Results"); // page title
        reporter.config().setTheme(Theme.STANDARD);

        reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        reporter.config().setEncoding("UTF-8");


        /*
        try {
            //reporter.loadXMLConfig("src/test/resources/config/extent-config.xml");
            reporter.loadJSONConfig("src/test/resources/config/extent-config.json");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }

         */

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        // pdf - from "pdfextentreporter" dependency by tech.grasshopper
        // TODO Extent Report PDF Option not working
 /*       ExtentPDFReporter pdf = new ExtentPDFReporter("src/test/resources/reports/ExtentPdfReport.pdf");
        try {
            pdf.loadJSONConfig(new File("src/test/resources/pdf-config.json")); // config file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extent.attachReporter(pdf);
        //*****/


        extent.setSystemInfo("Tester", Config.getProperty("tester"));  //devami:setSystemInfosToExtentReports()

        setSystemInfosToExtentReports(extent);

        return extent;
    }

    private static void setSystemInfosToExtentReports(ExtentReports extent)
    {
        String browserType = Driver.getBrowserType();
        extent.setSystemInfo("Browser : ", browserType);
        extent.setSystemInfo("Operating System : ", System.getProperty("os.name"));
        extent.setSystemInfo("OS Version : ", System.getProperty("os.version"));
        extent.setSystemInfo("Java Version : ", System.getProperty("java.version"));
        // Driver invoke olmadan once extent report memory ye alindigindan asagidaki kod null donuyor (as.kod driver.in browser versionunu return ediyor)
        // Listener class inda baslangicta global olarak extent objesini getExtentReportObject() metodunu kullanarak
        // olusturuyoruz. onTestStart da olustursam dedim bu sefer testlerin sonuclari dogru gelmedi
        //TODO Son care olarak Systemdeki browser larin versiyonunu okuyacak bir kod aklima geliyor ama zaman kalmadi
        String desktopProperty = (String) Toolkit.getDefaultToolkit().getDesktopProperty("browser.version");

        extent.setSystemInfo("Browser Version : ", desktopProperty);
    }

    private static Path createDirectory(String relativePath) { // src/test/resources/reports
        Path path = Paths.get(relativePath); // src\test\resources\reports
        if (!Files.exists(path)) // what if folder is not
        {
            try {
                Files.createDirectories(path);
            } catch (Exception ex) {
                System.out.println("Directory cannot created");
            }
        }
        return path;
    }

    // This method also check that if the directory is exist or not, if not it created
    public static String relativeToAbsolutePath(String relativePath, String fileName) // dynamic absolute path
    {
        final String OUTPUT_FOLDER = relativePath; // "src/test/resources/reports"; // relative path
        final String FILE_NAME = fileName; //"extent_index.html";
        Path halfAbsolutePath = createDirectory(OUTPUT_FOLDER); // src\test\resources\reports"
        String path = System.getProperty("user.dir") + "\\" + halfAbsolutePath + "\\" + FILE_NAME;
        return path;
    }



}

// relative path kabul etmiyorsa
// String destFile = System.getProperty("user.dir") + "\\outs\\"+testCaseName + ".png";