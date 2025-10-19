package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static calculator.Controller.StringController.*;
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

    @Test
    void 커스텀구분자_생성_테스트() {
        String string = AddCustomSeparator("//1\\n");
        assertThat(string).isEqualTo("1");
    }

    @Test
    void 커스텀구분자가_디폴트구분자인지_검사_테스트1() {
        boolean isDefaultSeparator = StringCheck_isDefaultSeparator(",");
        assertThat(isDefaultSeparator).isEqualTo(true);
    }

    @Test
    void 커스텀구분자가_디폴트구분자인지_검사_테스트2() {
        boolean isDefaultSeparator = StringCheck_isDefaultSeparator(":");
        assertThat(isDefaultSeparator).isEqualTo(true);
    }

    @Test
    void 커스텀구분자가_디폴트구분자인지_검사_테스트3() {
        boolean isDefaultSeparator = StringCheck_isDefaultSeparator(";");
        assertThat(isDefaultSeparator).isEqualTo(false);
    }

    @Test
    void 커스텀구분자_길이_1인지_검사_테스트1() {
        boolean isSeparatorLength1 = StringCheck_isSeparatorLength1(";");
        assertThat(isSeparatorLength1).isEqualTo(true);
    }

    @Test
    void 커스텀구분자_길이_1인지_검사_테스트2() {
        boolean isSeparatorLength1 = StringCheck_isSeparatorLength1(";'");
        assertThat(isSeparatorLength1).isEqualTo(false);
    }

    @Test
    void 문자열_분리_테스트1() {
        String[] splitstring = SplitString("1,2,3", "");
        assertThat(splitstring[0]).isEqualTo("1");
        assertThat(splitstring[1]).isEqualTo("2");
        assertThat(splitstring[2]).isEqualTo("3");
    }

    @Test
    void 문자열_분리_테스트2() {
        String[] splitstring = SplitString("1,2:3", "");
        assertThat(splitstring[0]).isEqualTo("1");
        assertThat(splitstring[1]).isEqualTo("2");
        assertThat(splitstring[2]).isEqualTo("3");
    }

    @Test
    void 문자열_분리_테스트3() {
        String[] splitstring = SplitString("1:2:3", "");
        assertThat(splitstring[0]).isEqualTo("1");
        assertThat(splitstring[1]).isEqualTo("2");
        assertThat(splitstring[2]).isEqualTo("3");
    }

    @Test
    void 문자열_분리_테스트4() {
        String[] splitstring = SplitString("1k;2:3", "1");
        assertThat(splitstring[0]).isEqualTo("");
        assertThat(splitstring[1]).isEqualTo("k;2");
        assertThat(splitstring[2]).isEqualTo("3");
    }

    @Test
    void 문자열_분리_테스트5() {
        String[] splitstring = SplitString("-1;2:3", ";");
        assertThat(splitstring[0]).isEqualTo("-1");
        assertThat(splitstring[1]).isEqualTo("2");
        assertThat(splitstring[2]).isEqualTo("3");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
