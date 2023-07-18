package com.dailycodelearner.springboot;

import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

@SpringBootApplication
public class SpringbootRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestApiApplication.class, args);

	}

}
