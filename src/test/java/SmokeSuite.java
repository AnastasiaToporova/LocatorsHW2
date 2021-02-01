import impl.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddToCartTests.class,
        FeaturesOfProductTests.class,
        HeaderTests.class,
        SearchTests.class,
        SortProductsTests.class

})
public class SmokeSuite {
}
