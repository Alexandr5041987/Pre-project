package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private static final List<Car> cars = new ArrayList<Car>();

    static {
        cars.add(new Car("Alpharomeo", 1999, "green", 100000.00));
        cars.add(new Car("Benzene", 1999, "red", 20000.00));
        cars.add(new Car("Mazda", 2001, "yellow", 30000.00));
        cars.add(new Car("Toyota", 2008, "white", 40000.00));
        cars.add(new Car("Volkswagen", 2013, "brown", 1_797_000));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count == 0) {
            return cars;
        }

        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
