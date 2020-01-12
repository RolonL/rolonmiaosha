package com.rolonmiaosha;

import com.rolonmiaosha.dao.UserMapper;
import com.rolonmiaosha.pojo.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */

/*@EnableAutoConfiguration*/
@SpringBootApplication(scanBasePackages = {"com.rolonmiaosha"})
@RestController
@MapperScan("com.rolonmiaosha.dao")
public class App
{
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public  String home(){
        User user=userMapper.selectByPrimaryKey(1);
        if (user==null){
            return "用户不存在";
        }else {
            return user.getName();
        }

    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
