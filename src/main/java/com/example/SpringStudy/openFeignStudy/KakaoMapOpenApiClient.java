package com.example.SpringStudy.openFeignStudy;

import com.example.SpringStudy.openFeignStudy.DTO.KakaoApiResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(// fallback은 예외처리 (일단 없이 가자)
        name = "KakaoMapAPI",
        url = "https://dapi.kakao.com"
)
public interface KakaoMapOpenApiClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/v2/local/search/keyword.json",
            produces = "application/json")
    KakaoApiResponseDTO.KeyWordSearchResponse findByKeyWord(@RequestHeader("Authorization") String key,
                                                            @RequestParam(name = "query") String query);
}

