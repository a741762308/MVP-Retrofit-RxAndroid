package com.jsqix.dq.mvp.retrofit.rxjava.data.api;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Md5 {

    public static String getMD5(String str, String charset) {
        String ret = null;
        if (str != null) {
            byte[] data = null;
            try {
                data = str.getBytes(charset);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            ret = getMD5(data);
        }
        return ret;
    }

    public static String getMD5(byte[] source) {
        String s = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest();
            char str[] = new char[16 * 2];

            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            s = new String(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String getSign(Map<String, Object> argMap, String key) {
        String sign = "";
        TreeMap<String, Object> treeMap = new TreeMap<>();
        if (!(argMap instanceof TreeMap)) {
            for (Entry<String, Object> tMap : argMap.entrySet()) {
                treeMap.put(tMap.getKey(), tMap.getValue());
            }
        } else {
            treeMap = (TreeMap<String, Object>) argMap;
        }
        StringBuffer ret = new StringBuffer();
        for (Entry<String, Object> map : treeMap.entrySet()) {
            ret.append(map.getKey());
            ret.append("=");
            String value = (String) map.getValue();
            if (value == null)
                value = "";
            ret.append(value);
            ret.append("&");
        }
        if (ret.toString().endsWith("&")) {
            ret.delete(ret.toString().length() - 1, ret.toString().length());
        }
        sign = Md5.getMD5(ret + key, Api.UTF_8);
        return sign;
    }

}
