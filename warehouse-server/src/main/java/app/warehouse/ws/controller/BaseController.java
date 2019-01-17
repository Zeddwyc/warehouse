package app.warehouse.ws.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weddini.throttling.Throttling;
import com.weddini.throttling.ThrottlingType;

@RestController
@RequestMapping("test")
public class BaseController {

	@GetMapping
	@Throttling(type = ThrottlingType.RemoteAddr, limit = 2, timeUnit = TimeUnit.SECONDS)
	public String testHello() {
		System.out.println("Call>");
		return "hello";
	}
	
}
