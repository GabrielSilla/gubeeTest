package com.gubee.gubee;

import com.gubee.gubee.model.entity.product.Product;
import com.gubee.gubee.product.ProductReaderTests;
import com.gubee.gubee.product.ProductTests;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GubeeApplicationTests {
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(ProductTests.class, ProductReaderTests.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}
