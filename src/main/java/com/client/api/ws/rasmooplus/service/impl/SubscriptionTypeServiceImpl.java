package com.client.api.ws.rasmooplus.service.impl;

import com.client.api.ws.rasmooplus.dto.SubscriptionTypeDTO;
import com.client.api.ws.rasmooplus.exception.BadRequestException;
import com.client.api.ws.rasmooplus.exception.NotFoundException;
import com.client.api.ws.rasmooplus.model.SubscriptionType;
import com.client.api.ws.rasmooplus.repository.SubscriptionTypeRepository;
import com.client.api.ws.rasmooplus.service.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {

    private final SubscriptionTypeRepository subscriptionTypeRepository;

    public SubscriptionTypeServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }

    @Override
    public List<SubscriptionType> findAll() {
        return subscriptionTypeRepository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {
        return getSubscriptionType(id);
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDTO dto) {
        if(Objects.nonNull(dto.getId())) {
            throw new BadRequestException("Id has to be null");
        }
        return subscriptionTypeRepository.save(SubscriptionType.builder().
                id(dto.getId()).name(dto.getName()).accessMonths(dto.getAccessMonth()).
                price(dto.getPrice()).productKey(dto.getProductKey()).build());
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionTypeDTO dto) {
        SubscriptionType current = getSubscriptionType(id);
        return subscriptionTypeRepository.save(SubscriptionType.builder().id(id).name(dto.getName()).
                accessMonths(dto.getAccessMonth()).price(dto.getPrice()).productKey(dto.getProductKey()).build());
    }

    @Override
    public Boolean delete(Long id) {
        getSubscriptionType(id);
        subscriptionTypeRepository.deleteById(id);
        return true;
    }

    private SubscriptionType getSubscriptionType(Long id) {
        Optional<SubscriptionType> current = subscriptionTypeRepository.findById(id);
        if(current.isEmpty()) {
            throw new NotFoundException("SubscriptionType Not Found.");
        }
        return current.get();
    }
}
