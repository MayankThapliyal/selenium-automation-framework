package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;
    private static String runFolder;
    
    public synchronized static String initRunFolder() {
    	if(runFolder==null) {
    		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    		runFolder = System.getProperty("user.dir") + File.separator + "reports"+ File.separator+ "run_" + timestamp;
    		File f = new File(runFolder);
    		if(!f.exists()) f.mkdirs();
    	}
    	return runFolder;
    }

    public synchronized static ExtentReports getExtentReports(){
        if(extent==null){
//            String reportPath = "src\\test\\resources\\ExtentReport.html";
        	String reportPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "ExtentReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

//            File cfg = new File("extent-config.xml");
            File cfg = new File(System.getProperty("user.dir") + File.separator + "extent-config.xml");
            if(cfg.exists()){
                try {
					spark.loadXMLConfig(cfg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Author","Mayank Thapliyal");
            extent.setSystemInfo("Environment","Local");
        }
        return extent;
    }
    
    public static String getRunFolder() {
    	if(runFolder==null) initRunFolder();
    	return runFolder;
    }
}
