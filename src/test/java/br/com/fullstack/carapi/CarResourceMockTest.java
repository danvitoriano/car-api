package br.com.fullstack.carapi;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CarResourceMockTest {
	
	@Mock
	private CarResource carResource;

	@Test
	public void shouldFindByColor() {
		//Sub
		String color = "preto";
		String model = "Polo";
		Car car = new Car();
		car.setColor(color);
		car.setModel(model);
		
		List<Car> cars = Arrays.asList(car);
		
		Mockito.when(carResource.findByColor("preto")).thenReturn(cars);
		
		//Execute
		List<Car> carsResponse = carResource.findByColor(color);
		
		// Assert
		assertEquals(carsResponse.get(0).getColor(), color);
		assertEquals(carsResponse.get(0).getModel(), model);
	}

	@Test
	public void testLambda1() {
		
		Truck truckAnonimousClass = new Truck() {
			@Override
			public void printColor(String color) {
				System.out.println(color);
			}
		};
		
		truckAnonimousClass.printColor("preto");

		Truck truckLambda = System.out::println;

		truckLambda.printColor("preto");

		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

		for (int i = 0; i < numbers.size(); i++) {
			Integer number = numbers.get(i);
			if (number > 5) {
				System.out.println(number);
			}

		}

		for (int number : numbers) {
			if (number > 5) {
				System.out.println("x=" + number);
			}
		}

		numbers.forEach(s -> System.out.println("z=" + s));

		numbers.stream().filter(i -> i > 5).forEach(System.out::println);


		
	}

	interface Truck {
		void printColor(String color);
	}


}



