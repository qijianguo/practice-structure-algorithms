package com.qijianguo.algorithms.test;

public class HeadDecorator extends Decorator {

    public HeadDecorator(Invoice ticket) {
        super(ticket);
    }

    @Override
    public void printInvoice() {
        System.out.println("This is the header of the invoice!");
        super.printInvoice();
    }
}
