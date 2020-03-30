package com.zxxj.main;

import com.zxxj.utils.AES;
import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * @author shkstart
 * @create 2020-03-30 11:04
 */
public class AESUDF extends UDF {
//    String password = "zmbd";

    public String evaluate(String type, String content) throws Exception {
        if (content == null) return null;

        if (!type.equals("encode") && !type.equals("decode")) {
            throw new Exception("Parmeter one is needed encode/decode");
        }

        if (type.equals("encode")) {
            //进行加密
            return AES.encrypt(content);
        } else {
            //进行解密
            return AES.decrypt(content);
        }
    }

//    public static void main(String[] args) {
//
//        try {
//            System.out.println(new AESUDF().evaluate("encode","罗纳尔多"));
//            System.out.println(new AESUDF().evaluate("decode","911AF6013296918534E0D049A76D50D0"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
