package com.snda.sysdev.gplusshop.web.util;

import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;


public class StringUtil {
    private static Random randGen = null;
    private static char[] numbersAndLetters = null;

    public static String stringToUnicode(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            if (ch > 255)
                str += "\\u" + Integer.toHexString(ch).toUpperCase();
            else
                str += "\\" + Integer.toHexString(ch).toUpperCase();
        }
        return str;
    }

    public static String getMD5Str(String str) throws Exception {
        return getHexString(string2md5(str));
    }

    public static final String randomString(int length) {
        if (length < 1) {
            return null;
        }
        if (randGen == null) {
            randGen = new Random();
            numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" +
                    "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
            //numbersAndLetters = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
            //randBuffer[i] = numbersAndLetters[randGen.nextInt(35)];
        }
        return new String(randBuffer);
    }

    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }


    private static byte[] string2md5(String str) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        return messageDigest.digest(str.getBytes("UTF-8"));
    }

    private static String getHexString(byte[] tmp) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char str[] = new char[16 * 2];
        int k = 0;
        for (int i = 0; i < 16; i++) {

            byte byte0 = tmp[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }

}
