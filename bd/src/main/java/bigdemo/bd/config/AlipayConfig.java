package bigdemo.bd.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000116670038";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCxkyQD+CJsFxQ/WyRHIRrD1KG1PPdWjqGGAjZs9JPjtwW5ZgA3wqeq86PqkpYnRt31M4eIk5iii9RAgRsRwzA5VNf+tBIWJ2eXm24xoS3QBtJePBMtWr37AjZw8n2X5Qt/344d0c/S/8tGj3+62MF+hVVi4paybfaLBYrET9gSQ4u6zozTCIKUZ0XSjmS7pHHDYerZvtfH46zTMoVMdfpaT5ts17qokfrDSf4e4PkauMDhpVtKabEYQg7fnUBoh9ZKKKAKopiserN+mPL/PUGIKq7pSNL8EEjpNe9iaIf955M0r1KjE/V4Ox3plpEQGSSe3/vVRTJnYmKimiBokc5hAgMBAAECggEBAInhTVrDpb62IOOc2ktcmhKqnLFEWGzeLO8H8sihE+ABsbEmUU76lwP3UDSIg4yVyyxkSX2z1RWJa1J2rNUa8OvjRB+iJFUNXbNrXaGtnAvl8Bx5mw5hYhhvvGPw9bImh8pPhGMFEdCtC2KLc8taGMwrrYQtmoOLPJ7vu7L4qDZs7ThzuT9m3lovKeCc7mIilFvjKHkY8dQhopvWz4WDsxx2WmA/UahDwnnaD+LM3sXb30TQy3ahQ0e9IHIn0SCeabq35Bgm+wwnYkkWKSICqvhacyWRQEYfIJqUqxsrOZf9mZmajC7ZeyrWnHnISDE3mZMt4nhPr4SbFse8pJUVMR0CgYEA7M+n8voDAoRh1MFCHhH7Nzm0ovXkpKSPnl1ubqZuD8SdelCgxP8Yc92oA+q11MI6BgrGbI8AIpkcdgAr7sYTZgW8yFWMHG5BU7eXK1qksUAN6cHtUJ9aqdRwG/DaAoafTXGnJC7/1ktyLuio4gBr93E1nzk2i95CBoLSkZ5HOFcCgYEAv/azoS6UNXnyO+N6kva/W0FnB5DHA0j7MIQOZVus3dnhXSjIdabKjbczgNj7d7jD7V6rsqw8ZWAR4XXM7rpO1kFN2aYmsYNW6FCQzuGgAlvlbzFyeGtkaALNMUsKI2Pq/9VVRhiSJGAIyEjzMAby+/lDSIp6nxay518LTiqgXAcCgYAVmsBMx4hcw20VdugsTCGqISacs2g/qQ+9N/LqP17NK3fef9qa/lbhwzgf21rpZSrcAEGoB8fQYD2belqHtyRv61gUwtE8isaE97vf5a4eyaQ7TkjzUQZ5dfsgYXHSRyvjadoA0BThHRL2up0luTogYgCtXQ/f5NALPgYt6M3AkwKBgQCpLOT/7snlGxSVHRQgQt8/sDL5oukRBxeAmVEKmLGPTv5jGJcZwKWQIV19dzyfNTFOl3lf3JTZjsITXbr+xSjHgAP5BYniNWq5EI+eE4/tpEleJkjIwXRaieWGRKipqdwoHT2qqerZrdzvjgLsV6N61yEp5AjO/bUrXULcX4q1rwKBgA3SkBfyuJl/cUB6CNVFTFDwXOLkua47RNfS0SKF0mAHyFpRYMYy3VaCmUouo8Knxn2WgiNEN9h0sWYzmhQfzpwdCcn2/DVbyQ7TxmZ0SbMbDjl95cxNmrZgArqrNCQ5uwxptGlT185s2HLU9XI654/w9WKFeJx9iMayi4+Acbga";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsJB8TKEOXZSZdpyBXzVjk7pcwWpkB8lkTZarb1s7G4syEEBfpNNrcMqErmdlIAyT8NELhdt7+xB+appw/rTTUYMzpgbXITf+gD/1oU36HfvesVbGQht9dfLdsWoqEx1D1S17sCDQn5aKeKN9PcuUEcHBGkdePTeqm3+fLMkI4L5+6dBCHNIr742xSUzJkBPBS3R5alKxsYSaD1uyUf9iFbWbgYR/6IybDj+n1jI1iAm1xSeKWQXT5Avuc+7Dv+a++deZGOMmEMAEx1NLgzhw+lcVY46IC63f+x3Obyf8HjmwZ+1xXwl3FnaJqP5k6jfxwS0ENuw7T4eGu1qwQ/COmwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/Pay/return_url";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
