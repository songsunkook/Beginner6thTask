package service;

import org.springframework.stereotype.Service;

@Service
public class AopServiceImpl implements AopService{
    @Override
    public String AopMethod(){
        System.out.println("AopMethod() 실행!!");
        return "AOP!";
    }
}
