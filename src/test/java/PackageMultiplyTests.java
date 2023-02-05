import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@SelectPackages("CalculatorTests")
@ExcludePackages("Multiply")
@IncludeTags("multiplyTests")
@Suite

public class PackageMultiplyTests {
}
