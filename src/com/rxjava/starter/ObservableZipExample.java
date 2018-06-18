package com.rxjava.starter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class ObservableZipExample {
    static List<String> zippedStrings = new ArrayList<>();

    public static void main(String []s) {
    Observable.zip(
            Observable.fromArray(new String[] { "Simple", "Moderate", "Complex" }), 
            Observable.fromArray(new String[] { "Solutions", "Success", "Hierarchy"}),
            (str1, str2) -> str1 + " " + str2).subscribe(onNext -> zippedStrings.add(onNext));
    
    System.out.println("the size of the ZippedStrings :" + zippedStrings.size());
    System.out.println("the values of the ZippedStrings :" + zippedStrings);
    }
    
}
