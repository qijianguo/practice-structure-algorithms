package com.qijianguo.algorithms.test;

/**
 * @author qijianguo
 */
public class Decorator extends Invoice {

    protected Invoice ticket;

    public Decorator(Invoice ticket) {
        this.ticket = ticket;
    }

    @Override
    public void printInvoice() {
        if (ticket != null) {
            ticket.printInvoice();
        }
    }
}
