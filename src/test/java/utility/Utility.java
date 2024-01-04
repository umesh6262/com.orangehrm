package utility;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Utility {

	public static boolean fileDownloadWait(String filePath, int waitInSecond) {
		File fileLocation = new File(filePath);
		Wait<File> wait = new FluentWait<File>(fileLocation)
				.pollingEvery(Duration.ofMillis(50))
				.ignoring(FileNotFoundException.class)
				.withTimeout(Duration.ofSeconds(waitInSecond));

		boolean isDownloaded = wait.until(file -> file.exists());
//		if(isDownloaded) {
//			System.out.println("File Downloaded");
//		}else {
//			System.out.println("File Not Downloaded");
//		}
		return isDownloaded;
	}

	public static String getScreenshotAsFile( WebDriver driver, String testName ) {
		File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+ "/screenshots/"+ testName + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS").format(new Date()) + ".PNG" ;
		File destinationFile = new File(destinationFilePath );
		try {
			FileHandler.copy(imageFile, destinationFile );
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationFilePath;
	}
	public static String getScreenshotAsBase64( WebDriver driver) {
		String imageBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return imageBase64;
	}
	
	public static String getConfigurationProperty(String key) {
		String value =null;
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
			prop.load(fis);
			value = prop.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}
}
