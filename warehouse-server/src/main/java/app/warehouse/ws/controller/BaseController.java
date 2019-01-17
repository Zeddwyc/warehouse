package app.warehouse.ws.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weddini.throttling.Throttling;
import com.weddini.throttling.ThrottlingType;

import app.warehouse.ws.utils.RandomType;
import app.warehouse.ws.utils.StringUtils;

@RestController
@RequestMapping("test")
public class BaseController {

	@Autowired
	private StringUtils stringUtils;

	@GetMapping
	@Throttling(type = ThrottlingType.RemoteAddr, limit = 2, timeUnit = TimeUnit.SECONDS)
	public String testHello() {
		return stringUtils.generate(0, RandomType.NUMERIC);
	}

}
