package fpt.trainining.movietheatre.service.impl;

import fpt.trainining.movietheatre.dto.promotion.PromotionReq;
import fpt.trainining.movietheatre.dto.promotion.PromotionRes;
import fpt.trainining.movietheatre.entity.Promotion;
import fpt.trainining.movietheatre.exception.ResourceNotFoundException;
import fpt.trainining.movietheatre.repository.PromotionRepository;
import fpt.trainining.movietheatre.service.PromotionService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;
    private final ModelMapper mapper;

    public List<Promotion> findAll() {
        return promotionRepository.findAll();
    }

    public Promotion findById(Integer id) {
        return promotionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot found promotion by id: " + id));
    }

    @Override
    public List<PromotionRes> getAll() {
        return findAll()
                .stream()
                .map(promotion -> {
                    return mapper.map(promotion, PromotionRes.class);
                })
                .collect(Collectors.toList());
    }

    @Override
    public PromotionRes getById(Integer id) {
        Promotion promotion = findById(id);
        return mapper.map(promotion, PromotionRes.class);
    }

    @Override
    public PromotionRes create(PromotionReq req) {
        Promotion promotion = mapper.map(req, Promotion.class);
        promotion = promotionRepository.save(promotion);
        return mapper.map(promotion, PromotionRes.class);
    }

    @Override
    public PromotionRes update(Integer promotionId, PromotionReq req) {
        Promotion promotion = findById(promotionId);
        mapper.map(req, promotion);
        promotion = promotionRepository.save(promotion);
        return mapper.map(promotion, PromotionRes.class);
    }

    @Override
    public void deleteById(Integer id) {
        promotionRepository.deleteById(id);
    }
}
