package br.com.fullstack.carapi;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarResourceTest {

	
	@Autowired
	private CarResource carResource;

	@Test
	public void shouldFindByColor() {
		// Sub
		String color = "preto";
		String model = "Polo";
		Car car = new Car();
		car.setColor(color);
		car.setModel(model);
		carResource.save(car);
		
		//Execute
		List<Car> cars = carResource.findByColor(color);
		
		// Assert
		assertEquals(cars.get(0).getColor(), color);
		assertEquals(cars.get(0).getModel(), model);

	}
	
	@Test
	public void testLambda1() {
		
		Truck truck = new Truck() {
			@Override
			public void printColor() {
				System.out.println("preto");
			}
		};
		
		truck.printColor();
		
	}
	

}

interface Truck {
	public void printColor();
}
