package authentication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test/hello")
@RestController
public class TestController {

	@RequestMapping(method = RequestMethod.GET)
	public String firstService() {
		return "Hello World";
	}
}
