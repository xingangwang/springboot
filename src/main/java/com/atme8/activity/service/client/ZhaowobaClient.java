package com.atme8.activity.service.client;

import com.atme8.activity.service.dto.AreaDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Administrator on 2015/11/12.
 */
@FeignClient("zhaowobaRestSever")
public interface ZhaowobaClient {

//    @Cacheable(value = "test", key = "areas")
    @RequestMapping(value = "/area/getAreaList", method = RequestMethod.GET)
    List<AreaDto> getAreas();

}
