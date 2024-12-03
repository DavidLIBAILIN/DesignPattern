package com.demo.StructuralPatterns.AdapterPattern;


import org.w3c.dom.ls.LSOutput;

interface CelsiusTemperature {
    public double getCTemperature();
}

class FahrenheitTemperate {
    private final double temperature;

    public FahrenheitTemperate(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }
}

class FahrenheitToCelsiusAdapter implements CelsiusTemperature {
    private final FahrenheitTemperate fahrenheit;

    public FahrenheitToCelsiusAdapter(FahrenheitTemperate fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    @Override
    public double getCTemperature() {
        return (this.fahrenheit.getTemperature() - 32) * 5 / 9;
    }
}
public class ObjectAdapterDemo {

    public static void main(String[] args) {
        FahrenheitTemperate fahrenheitTemperate = new FahrenheitTemperate(100);
        FahrenheitToCelsiusAdapter adapter = new FahrenheitToCelsiusAdapter(fahrenheitTemperate);

        System.out.println("The temperature is " + adapter.getCTemperature() + " degrees Celsius.");
    }
}
