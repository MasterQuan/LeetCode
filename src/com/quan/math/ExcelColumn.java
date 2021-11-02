package com.quan.math;

public class ExcelColumn {
    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.insert(0, (char) (columnNumber % 26 + 65));
            columnNumber /= 26;
        }
        return sb.toString();
    }

    public int titleToNumber(String columnTitle) {
        char[] charArray = columnTitle.toCharArray();
        int res = 0;
        for(int i = 0; i < charArray.length; i++) {
            res = res*26 + (charArray[i] - 'A' + 1);
        }

        return res;
    }
}
