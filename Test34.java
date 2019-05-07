package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test34 
{
	public static void main(String[] args) throws InterruptedException
	{
		//Get test data
		Scanner s=new Scanner(System.in);
		System.out.println("Eneter useid");
		String u=s.nextLine();
		System.out.println("Enetr userid criteria");     
		String uc=s.nextLine();
		String p=null;
		String pc=null;
		if(uc.equals("valid"))
		{
			System.out.println("Eneter password");
			p=s.nextLine();
			System.out.println("Enetr password criteria");     
			pc=s.nextLine();
		}
		//Launch site
		WebDriver obj=new FirefoxDriver();
		obj.get("http://www.gmail.com");
		Thread.sleep(5000);
		//User-id testing
		obj.findElement(By.xpath("//input[@id='Email']")).sendKeys(u);
		obj.findElement(By.xpath("//input[@id='next']")).click();
		Thread.sleep(5000);
		if(uc.equals("valid") && 
				obj.findElement(By.xpath("//input[@id='Passwd']")).isDisplayed())
		{
			System.out.println("Userid test passed");
			//Password testing
			obj.findElement(By.xpath("//input[@id='Passwd']")).sendKeys(p);
			obj.findElement(By.xpath("//input[@id='signIn']")).click();
			Thread.sleep(5000);
			if(pc.equals("valid") && obj.findElement(By.xpath("//div[@gh='cm']")).isDisplayed() || obj.findElement(By.xpath("//a[@href='https://mail.google.com/mail/u/0/#inbox']")).isDisplayed())
			{
				System.out.println("Password test passed");
			}
			else if(pc.equals("invalid") && obj.findElement(By.xpath("//span[@class='error-msg']")).isDisplayed() || obj.findElement(By.xpath("//span[@color='red']")).isDisplayed())
			{
				System.out.println("Password test passed");
			}
			else
			{
				System.out.println("Password test failed");
			}
		}
		else if(uc.equals("invalid") && obj.findElement(By.xpath("//span[@id='errormsg_0_Email']")).isDisplayed())
		{
			System.out.println("Userid test passed");
		}
		else
		{
			System.out.println("Userid test failed");
		}
		//Close site
		obj.close();
	}
}





