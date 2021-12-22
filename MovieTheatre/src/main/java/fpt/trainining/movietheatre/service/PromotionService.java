package fpt.trainining.movietheatre.service;

import fpt.trainining.movietheatre.dto.promotion.PromotionReq;
import fpt.trainining.movietheatre.dto.promotion.PromotionRes;

import java.util.List;

public interface PromotionService {
    List<PromotionRes> getAll();
    PromotionRes getById(Integer id);
    PromotionRes create(PromotionReq req);
    PromotionRes update(Integer promotionId, PromotionReq req);
    void deleteById(Integer id);
}
