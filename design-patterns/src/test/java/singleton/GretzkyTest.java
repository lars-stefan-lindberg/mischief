package singleton;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GretzkyTest {

    @Test
    public void checkShootingPower() {
        NHL2017.initGame();
        assertThat(Gretzky.INSTANCE.getShootingPower())
                .isEqualTo(100);
        NHL2018.initGame();
        assertThat(Gretzky.INSTANCE.getShootingPower())
                .isEqualTo(90);
    }
}
