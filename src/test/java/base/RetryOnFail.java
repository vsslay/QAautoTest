package base;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static constants.constants.RetryAttemptsNumber.MAX_RETRY;

public class RetryOnFail implements IRetryAnalyzer {
    private int actualRetry = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (actualRetry < MAX_RETRY) {
            actualRetry++;
            return true;
        } else {
            return false;
        }
    }
}