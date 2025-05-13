package com.example.Reactive;

import com.example.Reactive.service.FluxLearnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FluxLearnTest {

   @Autowired
   private FluxLearnService fluxLearnService;

   @Test
   void testing(){
       this.fluxLearnService.fluxTestingService();
   }

//   @Test
//   public void simpleFluxTest(){
//       this.fluxLearnService.getFlux().subscribe(data->{
//           System.out.println(data);
//           System.out.println("Done with flux data");
//       });
//   }

//   @Test
//   public void fruitsTestEvery(){
//       fluxLearnService.fruitsFlux().subscribe(System.out::println);
//   }

//   @Test
//   public void covvertcaps(){
//       fluxLearnService.mapExampleFlux().subscribe(data->{
//           System.out.println(data);
//       });
//   }

    @Test
    public void filterIt(){
       fluxLearnService.filterExampleFlux().subscribe(data->{
           System.out.println(data);
       });
    }



}
