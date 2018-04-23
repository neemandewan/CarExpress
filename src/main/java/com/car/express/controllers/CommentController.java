package com.car.express.controllers;

import com.car.express.models.Car;
import com.car.express.models.Comment;
import com.car.express.models.User;
import com.car.express.services.CarService;
import com.car.express.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Neeman on 18/04/2018.
 */

@RestController
@RequestMapping( value = "/api/comment", produces = MediaType.APPLICATION_JSON_VALUE )
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/{carId}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> addComment(@PathVariable Long carId,
                                        @RequestBody Comment comment,
                                        @AuthenticationPrincipal User user) {

        Car car = carService.findById(carId);
        System.out.println(car);
        comment.setCar(car);

        commentService.add(comment);

        Map<String, String> result = new HashMap<>();
        result.put( "result", "success" );
        return ResponseEntity.accepted().body(result);
    }
}
