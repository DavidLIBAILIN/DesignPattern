package com.demo.StructuralPatterns.BridgePattern;

interface Payment {
    void processPayment();
}

class CreditCardPayment implements Payment {
    public void processPayment() {
        System.out.println("Process Credit Card Payment");
    }
}

class WechatPayment implements Payment {
    public void processPayment() {
        System.out.println("Process Wechat Payment");
    }
}

abstract class Product {
    protected Payment payment;

    public Product(Payment payment) {
        this.payment = payment;
    }

    public abstract void purchase();
}

class Book extends Product {
    public Book(Payment payment) {
        super(payment);
    }

    @Override
    public void purchase() {
        this.payment.processPayment();
        System.out.println("Purchase Book");
    }

}

class Electronics extends Product {
    public Electronics(Payment payment) {
        super(payment);
    }

    @Override
    public void purchase() {
        this.payment.processPayment();
        System.out.println("Purchase Electronics");
    }
}


public class OnlineStore2 {
    public static void main(String[] args) {
        Payment creditCardPayment = new CreditCardPayment();
        Payment wechatPayment = new WechatPayment();

        Book book = new Book(creditCardPayment);
        Electronics electronics = new Electronics(wechatPayment);
        book.purchase();
        electronics.purchase();

    }

}
