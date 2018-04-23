package com.car.express.common;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Neeman on 16/04/2018.
 */

@Component
public class TimeProvider implements Serializable {

    public Date now() {
        return new Date();
    }

}
