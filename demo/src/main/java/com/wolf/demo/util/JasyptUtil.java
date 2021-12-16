package com.wolf.demo.util;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

/**
 * @Author zhangle
 * @CreateTime 2021-12-16 15:15:14
 * @Description
 */
public class JasyptUtil {
    /**
     * Jasypt生成加密结果
     * @param password 配置文件中设定的加密盐值
     * @param value 加密值
     * @return
     */
    public static String encyptPwd(String password,String value){
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(cryptor(password));
        String result = encryptor.encrypt(value);
        return result;
    }

    /**
     * 解密
     * @param password 配置文件中设定的加密盐值
     * @param value 解密密文
     * @return
     */
    public static String decyptPwd(String password,String value){
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(cryptor(password));
        String result = encryptor.decrypt(value);
        return result;
    }

    public static SimpleStringPBEConfig cryptor(String password){
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        return config;
    }


    public static void main(String[] args) {
        String salt = "adjkfjen12?@123";
        // 加密
        String encUseName = encyptPwd(salt, "zl");
        String encPwd = encyptPwd(salt, "zl123");
        // 解密
        String decUseName = decyptPwd(salt,encUseName);
        String decPwd = decyptPwd(salt, encPwd);
        System.out.println(encUseName+"||"+encPwd);
        System.out.println(decUseName+"||"+decPwd);
    }

}
