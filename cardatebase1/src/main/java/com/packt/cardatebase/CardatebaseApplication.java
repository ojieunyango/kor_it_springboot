package com.packt.cardatebase;


import com.packt.cardatebase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.packt.cardatebase.domain.CarRepository;

import java.util.Arrays;


@SpringBootApplication
public class CardatebaseApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CardatebaseApplication.class);
    // 생성자 주입을 통한 CarRepository
	private final CarRepository repository; //여기서는 CardatabaseApplication의 필드로 repository선언

	private final OwnerRepository oRepository;

	public CardatebaseApplication(CarRepository repository, OwnerRepository oRepository){
		this.oRepository=oRepository;
		this.repository = repository;
	}


	public static void main(String[] args) {

		SpringApplication.run(CardatebaseApplication.class, args);
		logger.info("어플리케이션 실행");
	}

	@Override
	public void run(String... args) throws Exception {
		//Owner 객체를 생성하고 DB에 저장할겁니다.
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		Owner owner3 = new Owner("근수", "안");
		oRepository.saveAll(Arrays.asList(owner1, owner2, owner3));


		repository.save(new Car("Ford", "Mustang", "Red", "ADF-11121", 2023, 59000, owner1));
		repository.save(new Car("Nissan", "Leaf", "white", "SSJ-3002", 2020, 29000, owner1));
		repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000, owner2));
		repository.save(new Car("Kia", "Seltos", "Chacoal", "360수5690", 2020, 28000, owner3));

		// 모든 자동차 엔티티를 다 찾아내서 console창에 로깅

		for (Car car : repository.findAll()){
			logger.info("브랜드: {}, 모델명: {}", car.getBrand(), car.getModel());
		}

	}
}
