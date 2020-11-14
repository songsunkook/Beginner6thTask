package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AopService;

@Controller
public class AopController {
    @Autowired
    AopService aopService;

    @RequestMapping(value = "/aop", method = RequestMethod.GET)
    public ResponseEntity aop(){
        return new ResponseEntity(aopService.AopMethod(), HttpStatus.OK);
    }
}
