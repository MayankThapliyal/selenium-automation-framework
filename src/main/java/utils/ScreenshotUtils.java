package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils{
    public static String takeScreenshot(WebDriver driver, String testName, String runFolder) {
    	try{
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String destFolder = runFolder + File.separator + "screenshots";
            File folder = new File(destFolder);
            if(!folder.exists()) folder.mkdirs();

            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String destPath = destFolder + File.separator + testName+"_"+timeStamp+".png";
            FileUtils.copyFile(srcFile, new File(destPath));
            return destPath;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}