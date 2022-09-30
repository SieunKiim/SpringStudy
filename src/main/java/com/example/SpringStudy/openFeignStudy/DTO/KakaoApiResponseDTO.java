package com.example.SpringStudy.openFeignStudy.DTO;

import lombok.*;

import java.util.List;

public class KakaoApiResponseDTO {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class KeyWordSearchResponse{
        private List<Document> documents;
        private Meta meta;
        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        @ToString
        public static class Document{
            protected String address_name;
            protected String category_group_code;
            protected String category_group_name;
            protected String category_name;
            protected String distance;
            protected String id;
            protected String phone;
            protected String place_name;
            protected String place_url;
            protected String road_address_name;
            protected String y;
            protected String x;

        }
        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Meta{
            protected Boolean is_end;
            protected Integer pageable_count;
            protected Integer total_count;
        }
    }
}
