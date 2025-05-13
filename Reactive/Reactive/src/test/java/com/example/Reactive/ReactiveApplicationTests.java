package com.example.Reactive;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

import java.util.Locale;
import java.util.function.Consumer;

@SpringBootTest
class ReactiveApplicationTests {

	@Test
	void contextLoads(){

	}

	@Test
	void workingWithMono(){
		System.out.println("Testing");

		//mono -- > publisher that have 0 or 1 items

//		Mono<String> errorMono= Mono.error(new RuntimeException("Error !!!"));
//
//		Mono<String> m1=Mono
//				.just("Learn with mohit bhai")
//				.log()
//				.then(errorMono);




//


//		Mono<String> m1 = Mono.just("I am Mohit");
//		Mono<String> m2= Mono.just("Relax and take rest");
//		Mono<Integer> m3 =Mono.just(2323);
//
//		Mono<Tuple3<String,String,Integer>> combineMono=Mono.zip(m1,m2,m3);
//
//		combineMono.subscribe(data->{
//			System.out.println(data);
//			System.out.println(data.getT1());
//			System.out.println(data.getT2());
//			System.out.println(data.getT3());
//		});
//
//		Mono<Tuple2<String, Integer>> zipWithMono = m1.zipWith(m3);
//		zipWithMono.subscribe(data->{
//			System.out.println(data.getT1());
//			System.out.println(data.getT2());
//		});

		Mono<String> m1 = Mono.just("I am Mohit");
		Mono<String> m2= Mono.just("Relax and take rest");
		Mono<Integer> m3 =Mono.just(2323);

		Mono<String> map1 = m1.map(item -> item.toUpperCase());
//      or
//		Mono<String>map1=m1.map(String::toUpperCase);
		map1.subscribe(System.out::println);
		Mono<String[]> resultFlatMap = m1.flatMap(value -> Mono.just(value.split(" ")));
		resultFlatMap.subscribe(data->{
			for(String s:data){
				System.out.println(s);
			}
		});


	}




}
