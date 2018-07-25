package exercises;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.testng.annotations.Test;

public class Controles {

    @Test
    public void assertUserInfo() {
        String accountInformation = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertThat(accountInformation).as("Text has size 89").hasSize(89);
        Assertions.assertThat(accountInformation).as("Text contains: personal information").contains("personal information");
    }

    @Test
    public void assertPriceReduction() {
        int price = -18;
        Assertions.assertThat(price).isBetween(-20, 0);
        Assertions.assertThat(price).isCloseTo(-25, Offset.offset(10));
    }

    @Test
    public void isElementVisible() {
        Boolean isElementPresent = true;
        Assertions.assertThat(isElementPresent).isNotEqualTo(false);
    }
}
