import java.util.Objects;

interface Car{
    void getType();
}

class PremiumSedan implements  Car{
    @Override
    public void getType(){
        System.out.println("p sedan");
    }
}
class PremiumHatch implements  Car{
    @Override
    public void getType(){
        System.out.println("p hatch");
    }
}
class EconomicalSedan implements  Car{
    @Override
    public void getType(){
        System.out.println("E sedan");
    }
}
class EconomicalHatch implements  Car{
    @Override
    public void getType(){
        System.out.println("E hatch");
    }
}

interface AbstractFactory{
    Car getInstance(double size);
}

class EconomicCarFactory implements AbstractFactory {
    @Override
    public Car getInstance(double size){
        if(size < 2.5){
            return new EconomicalHatch();
        }else{
            return new EconomicalSedan();
        }
    }
}

class PremiumCarFactory implements AbstractFactory {
    @Override
    public Car getInstance(double size){
        if(size < 2.5){
            return new PremiumHatch();
        }else{
            return new PremiumSedan();
        }
    }
}

class AbstractFactoryProducer{
    public AbstractFactory getFactoryInstance(String type){
        if(Objects.equals(type, "Economical")){
            return new EconomicCarFactory();
        }
        else if(Objects.equals(type, "Premium")){
            return new PremiumCarFactory();
        }
        return null;
    }
}



public class Main {
    public static void main(String[] args) {
        AbstractFactoryProducer producer = new AbstractFactoryProducer();
        AbstractFactory factory = producer.getFactoryInstance("Premium");
        Car car = factory.getInstance(3D);
        car.getType();
    }
}
