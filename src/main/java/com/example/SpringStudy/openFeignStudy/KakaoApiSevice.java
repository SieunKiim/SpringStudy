package com.example.SpringStudy.openFeignStudy;

import com.example.SpringStudy.openFeignStudy.DTO.KakaoApiResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KakaoApiSevice {
    private final KakaoMapOpenApiClient kakaoMapOpenApiClient;

    public KakaoApiSevice(KakaoMapOpenApiClient kakaoMapOpenApiClient) {
        this.kakaoMapOpenApiClient = kakaoMapOpenApiClient;
    }

    public KakaoApiResponseDTO.KeyWordSearchResponse searchResult(String query) {
        String key = "KakaoAK fb2ba26e68069bb7df69572e74dafd38";
        KakaoApiResponseDTO.KeyWordSearchResponse result= kakaoMapOpenApiClient.findByKeyWord(key, query);
        log.info(String.valueOf(result));
        return result;
    }
}
