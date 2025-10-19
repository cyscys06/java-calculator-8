package calculator.Controller;

import camp.nextstep.edu.missionutils.Console;

public class StringController {
    public static String Input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static boolean StringCheck_ContainCustomSeparator(String str) {
        return str.startsWith("//") &&  str.contains("\\n");
    }

    public static String AddCustomSeparator(String str) {
        int index = str.indexOf("n");
        return str.substring(2, index - 1);
    }
}
