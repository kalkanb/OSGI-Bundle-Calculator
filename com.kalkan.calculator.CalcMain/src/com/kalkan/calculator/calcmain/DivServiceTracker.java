package com.kalkan.calculator.calcmain;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import com.kalkan.calculator.calculatorcore.Div;

public class DivServiceTracker extends ServiceTracker {
    public DivServiceTracker(BundleContext context) {
        super(context, Div.class.getName(),null);
    }
    public Object addingService(ServiceReference reference) {
        return super.addingService(reference);
    }
    public void removedService(ServiceReference reference, Object service) {
        System.out.println("Inside DivServiceTracker.removedService " + reference.getBundle());
        super.removedService(reference, service);
    }
}