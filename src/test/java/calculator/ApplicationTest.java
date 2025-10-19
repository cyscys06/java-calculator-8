package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static calculator.Controller.StringController.StringCheck_ContainCustomSeparator;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자_생성_요청_테스트1() {
        boolean result = StringCheck_ContainCustomSeparator("1,2,3");
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 커스텀구분자_생성_요청_테스트2() {
        boolean result = StringCheck_ContainCustomSeparator("//1\\n");
        assertThat(result).isEqualTo(true);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
