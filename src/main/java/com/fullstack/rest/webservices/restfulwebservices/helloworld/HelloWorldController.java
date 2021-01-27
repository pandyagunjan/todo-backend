package com.fullstack.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {


  //@RequestMapping(method= RequestMethod.GET,path="/hello-world")
  @GetMapping(path = "/hello-world")
    public String helloWorld()
    {
        return "Hello World";
    }
    //hello-world-bean
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean()
    {
      //throw new RuntimeException("Some Error occured");
        return new HelloWorldBean("Hello World");
    }
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
    {
       return new HelloWorldBean(String.format("Hello World %s",name));
    }
}

