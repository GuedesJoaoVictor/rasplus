package com.client.api.ws.rasmooplus.mapper;

import com.client.api.ws.rasmooplus.dto.SubscriptionTypeDTO;
import com.client.api.ws.rasmooplus.model.SubscriptionType;

public class SubscriptionTypeMapper {

    public static SubscriptionType fromDtoToEntity(SubscriptionTypeDTO dto) {
        return SubscriptionType.builder().
                id(dto.getId()).name(dto.getName()).accessMonths(dto.getAccessMonth()).
                price(dto.getPrice()).productKey(dto.getProductKey()).build();
    }
}
