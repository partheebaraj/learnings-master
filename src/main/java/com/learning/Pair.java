package com.learning;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Pair {

    static final Pair SEED = new Pair(1,1);

    final int index;

    final  double value;

    public  Pair(int index,double value){
        this.index = index;
        this.value = value;
    }


    public Pair next() {
        return new Pair(getIndex()+1,Math.pow(getIndex()+1,2));
    }


}
