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

    public static boolean StringCheck_isDefaultSeparator(String str) {
        return str.equals(",") || str.equals(":");
    }

    public static boolean StringCheck_isSeparatorLength1(String str) {
        return str.length() != 1;
    }

    public static String[] SplitString(String str, String sep) {
        int index = str.indexOf("n");
        str = str.substring(index + 1);
        return str.split("[," + sep + ":]");
    }

    public static boolean StringCheck_isNotNumber(String[] splitstr) {
        for (String s : splitstr) {
            try {
                Integer.parseInt(s);
            }
            catch (NumberFormatException e) {
                return true;
            }
        }
        return false;
    }

    public static Integer[] ChangeToNumber(String[] splitstr) {
        Integer[] numberarr = new Integer[splitstr.length];

        for (int i = 0; i < splitstr.length; i++) {
            if (splitstr[i].isEmpty()) {
                numberarr[i] = 0;
                continue;
            }
            int realNumber = Integer.parseInt(splitstr[i]);
            numberarr[i] = realNumber;
        }
        return numberarr;
    }

    public static boolean IntegerCheck_isNegativeNumber(Integer[] numberarray) {
        for (Integer n : numberarray) {
            if (n < 0) {
                return true;
            }
        }
        return false;
    }

    public static Integer Total(Integer[] numberarray) {
        Integer total = 0;
        for (Integer n : numberarray) {
            total += n;
        }
        return total;
    }
}
