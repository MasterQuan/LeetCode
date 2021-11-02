package com.quan.tow_pointers;

public class BackSpaceCompare {

    public static boolean backspaceCompare(String s, String t) {
        return backSpace(s).equals(backSpace(t));
    }

    private static String backSpace(String s){
        if (s == null || s.length() < 1) return new String();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#'){
                if (sb.length() >= 1){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
