package com.company.test;


import org.robovm.apple.foundation.NSError;
import org.robovm.apple.storekit.SKProductsRequest;
import org.robovm.apple.storekit.SKProductsRequestDelegateAdapter;
import org.robovm.apple.storekit.SKRequest;

import java.util.HashSet;

public class SomeTestClass {

    public SomeTestClass () {
        HashSet<String> skuSet = new HashSet<String>();
        skuSet.add("Nonsense");
        SKProductsRequest req = new SKProductsRequest(skuSet); //breakpoint hit is ok
        req.setDelegate(new SKProductsRequestDelegateAdapter() {
            @Override
            public void didFinish(SKRequest request) {
                super.didFinish(request);
            }

            @Override
            public void didFail(SKRequest request, NSError error) {
                super.didFail(request, error); //breakpoint here not initialized on startup
            }
        });

        req.start();

    }

}
