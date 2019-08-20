package Methods;

import java.util.Iterator;
import java.util.Set;

public class Navigation extends Basic {

public void switchWindows_close() throws Exception {

	Set<String> handles = driver.getWindowHandles();
	int TotalCountOfWindows = handles.size();
	System.out.println("Totol windows count" + TotalCountOfWindows);
	String image = null;
	if (TotalCountOfWindows > 1) {
		Iterator<String> it = handles.iterator();
		String parentWidnow = it.next();
		System.out.println("Parent window id -" + parentWidnow);
		
		String newWindow = it.next();
		System.out.println("child window id  -" + newWindow);
		driver.switchTo().window(newWindow);
		Thread.sleep(5000);
		driver.close();
		
		driver.switchTo().window(parentWidnow);
		Thread.sleep(2000);
	}	
}


public void switchWindows_Reports() throws Exception {

	Set<String> handles = driver.getWindowHandles();
	int TotalCountOfWindows = handles.size();
	System.out.println("Total windows count" + TotalCountOfWindows);

	if (TotalCountOfWindows > 1) {
		Iterator<String> it = handles.iterator();
		String parentWidnow = it.next();
		System.out.println("Parent window id -" + parentWidnow);
		
		String newWindow = it.next();
		System.out.println("child window id  -" + newWindow);
		driver.switchTo().window(newWindow);
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
		
}


}
