package core.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.InputStream;
import java.util.Properties;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest extends AbstractBaseTest {
    protected static String baseUrl;

    @Override
    protected void configure() {
        Configuration.browser= "chrome";
        Configuration.browserSize = "1920x1080";
    }
}
