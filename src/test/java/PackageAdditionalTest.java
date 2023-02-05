import org.junit.platform.suite.api.*;

@SelectPackages("CalculatorTests")
@ExcludePackages("Additional")
@IncludeTags("additionalTests")
@Suite

public class PackageAdditionalTest {
}
