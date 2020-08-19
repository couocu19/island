package com.island;

import com.zhenzi.sms.ZhenziSmsClient;
import netscape.security.UserTarget;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class IslandApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void sendCode(){
        final String apiUrl = "https://sms_developer.zhenzikj.com";
        //榛子云系统上获取
        final String appId = "105272";
        final String appSecret = "09f26479-a1fb-405b-879a-aa9a0061109e";
        String name = "阿旺";
        String code = String.valueOf(new Random().nextInt(999999));
        //将验证码通过榛子云接口发送至手机
        ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
        try {
           client.send("18634587269", "恭喜" + name+",你今天的幸运码为："+code + ",改码祝你今天顺利吃鸡!");
            System.out.println(code);
        } catch (Exception e) {
            System.out.println("发送失败~");
        }


    }

}
