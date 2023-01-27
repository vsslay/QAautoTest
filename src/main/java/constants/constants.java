package constants;

public class constants {

    public static class RetryAttemptsNumber{
        public static final int MAX_RETRY = 3;
    }

//_________________________________________________________URLs_________________________________________________________
    public static class Urls{
        public static final String BASE_MERCHANT_URL = "https://merchant.armenotech.dev/";
        public static final String LOGIN_PAGE_MERCHANT_URL = BASE_MERCHANT_URL + "login";
        public static final String REG_SUCCESS_MERCHANT_URL = BASE_MERCHANT_URL + "registration-is-successfully";
        public static final String QUESTIONNAIRE_MERCHANT_URL = BASE_MERCHANT_URL + "questionnaire";
        public static final String DASHBOARD_MERCHANT_URL = BASE_MERCHANT_URL + "dashboard";

        public static final String PRIVACY_POLICY_MERCHANT_URL = "https://tempo.eu.com/privacy-policy";
}
}

