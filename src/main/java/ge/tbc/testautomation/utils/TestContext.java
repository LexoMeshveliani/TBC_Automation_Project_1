package ge.tbc.testautomation.utils;

import org.openqa.selenium.WebDriver;

public class TestContext {
    private static final ThreadLocal<String> DEVICE = new ThreadLocal<>();

    public static void setDevice(String device) {
        DEVICE.set(device == null ? "desktop" : device);
    }

    public static boolean isMobile() {
        return "mobile".equals(DEVICE.get());
    }

    public static void clear() {
        DEVICE.remove();
    }
}


//public class TestContext {
//    public static boolean isMobileOrDesk(WebDriver driver){
//        return driver.manage().window().getSize().getWidth()==430;
//    }
//}
