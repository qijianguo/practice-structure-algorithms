package com.qijianguo.algorithms.test;

public class FootDecorator extends Decorator {

    public FootDecorator(Invoice ticket) {
        super(ticket);
    }

    @Override
    public void printInvoice() {
        super.printInvoice();
        System.out.println("This is the foot of the invoice!");
    }
}
