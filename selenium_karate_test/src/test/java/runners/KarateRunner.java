package runners;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

@RunWith(Karate.class)
@KarateOptions(features = {"src/test/java/equifax_amazon_test/"})
public class KarateRunner {
}
