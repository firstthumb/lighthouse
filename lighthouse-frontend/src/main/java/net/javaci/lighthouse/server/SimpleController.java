package net.javaci.lighthouse.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: eerokoc
 * Date: 26/10/11
 * Time: 10:01
 */
@Controller
public class SimpleController {

    @RequestMapping(value = "/test/", method = RequestMethod.GET)
    public String test() {
        System.out.println("Test method is invoked");
        return "Test invoked...";
    }
}
