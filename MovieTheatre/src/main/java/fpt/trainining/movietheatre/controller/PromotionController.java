package fpt.trainining.movietheatre.controller;

import fpt.trainining.movietheatre.dto.ResponseHandler;
import fpt.trainining.movietheatre.dto.promotion.PromotionReq;
import fpt.trainining.movietheatre.dto.promotion.PromotionRes;
import fpt.trainining.movietheatre.service.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promotion")
@AllArgsConstructor
public class PromotionController {
    private final PromotionService promotionService;

    @GetMapping
    public ResponseEntity getAll() {
        List<PromotionRes> res = promotionService.getAll();
        return ResponseHandler.generateResponse("Get all promotions successfully!", HttpStatus.OK, res);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        PromotionRes res = promotionService.getById(id);
        return ResponseHandler.generateResponse("Get promotion by id successfully!", HttpStatus.OK, res);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody PromotionReq req) {
        PromotionRes res = promotionService.create(req);
        return ResponseHandler.generateResponse("Created promotion successfully!", HttpStatus.CREATED, res);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody PromotionReq req) {
        PromotionRes res = promotionService.update(id,req);
        return ResponseHandler.generateResponse("Update promotion successfully!", HttpStatus.OK, res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        promotionService.deleteById(id);
        return ResponseHandler.generateResponse("Delete promotion successfully!", HttpStatus.OK, null);
    }

}
