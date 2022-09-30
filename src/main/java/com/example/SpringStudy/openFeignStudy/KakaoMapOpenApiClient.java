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

// 복습
//public class KakaoMapResponse {
//    @Getter
//    @Setter
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class KeyWordSearchResponse{
//        private List<Document> documents;
//        private Meta meta;
//        @Getter
//        @Setter
//        @AllArgsConstructor
//        @NoArgsConstructor
//        public static class Document{
//            protected String address_name;
//            protected String category_group_code;
//            protected String category_group_name;
//            protected String category_name;
//            protected String distance;
//            protected String id;
//            protected String phone;
//            protected String place_name;
//            protected String place_url;
//            protected String road_address_name;
//            protected String y;
//            protected String x;
//
//        }
//        @Getter
//        @Setter
//        @AllArgsConstructor
//        @NoArgsConstructor
//        public static class Meta{
//            protected Boolean is_end;
//            protected Integer pageable_count;
//            protected Integer total_count;
//        }
//    }
//}