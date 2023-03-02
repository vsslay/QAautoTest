package common;

@SuppressWarnings("ALL")
public class config {

//________________________________________________ Browser and Platform _________________________________________________
    /**
     * Active constant will be used for driver
     * and platform configuration and setup.
     * Due to webdriver restrictions, "win_firefox" doesn't have a download folder set-up method
     */
    public static final String PLATFORM_AND_BROWSER = "win_chrome";
    //public static final String PLATFORM_AND_BROWSER = "win_firefox";
    //public static final String PLATFORM_AND_BROWSER = "win_edge";
    //public static final String PLATFORM_AND_BROWSER = "mac_safari";

    //public static final String PLATFORM_AND_BROWSER = "win_chrome_headless";
    //public static final String PLATFORM_AND_BROWSER = "win_firefox_headless";
    //public static final String PLATFORM_AND_BROWSER = "win_edge_headless";

//____________________________________________________ Window Size _____________________________________________________
    /**
     * Active constant will be used for setting up window size
     */
//    public static final String SET_WINDOW_SIZE = "maximize";
    public static final String SET_WINDOW_SIZE = "minimize";
    //public static final String SET_WINDOW_SIZE = "default";

//____________________________________________________ Wait timeout ____________________________________________________
    /**
     * Active constant will be used for setting up wait timeout
     */
    //public static final String SET_WAIT_TIMEOUT = "fast";
    public static final String SET_WAIT_TIMEOUT = "middle";
    //public static final String SET_WAIT_TIMEOUT = "slow";

//_________________________________________ Clear cookies and storage on exit __________________________________________
    /**
     * Clear session cookies and clears storage
     * if true - cookies and storage will be cleared
     */
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;
    //public static final Boolean CLEAR_COOKIES_AND_STORAGE = false;

//_______________________________________________ Close Browser After Tests ____________________________________________
    /**
     * To keep browser opened after test suite
     * if true - browser will be closed
     */
    public static final Boolean CLOSE_BROWSER_AFTER_TESTS = true;
    //public static final Boolean CLOSE_BROWSER_AFTER_TESTS = false;

//______________________________________________ Screenshot on test failure ____________________________________________
    /**
     * To make screenshot on test failure
     * if true - screenshot will be taken on test failure
     */
    public static final Boolean SCREENSHOT_ON_TEST_FAILURE = true;
    //public static final Boolean SCREENSHOT_ON_TEST_FAILURE = false;

//______________________________________________________________________________________________________________________
}