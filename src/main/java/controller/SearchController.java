package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.SearchService;

@Controller
public class SearchController {
    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/linear", method = RequestMethod.GET)
    public ResponseEntity linear(){
        return new ResponseEntity(searchService.linear(7999999) , HttpStatus.OK);
    }
    @RequestMapping(value = "/binary", method = RequestMethod.GET)
    public ResponseEntity binary(){
        return new ResponseEntity(searchService.binary(7999999) , HttpStatus.OK);
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ResponseEntity wrong(){
        return new ResponseEntity(searchService.temp(), HttpStatus.OK);
    }
}
