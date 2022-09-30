package com.example.SpringStudy.openFeignStudy;


import com.example.SpringStudy.openFeignStudy.DTO.KakaoApiResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/")
public class KakaoApiConroller {
    private final KakaoApiSevice kakaoApiSevice;

    public KakaoApiConroller(KakaoApiSevice kakaoApiSevice) {
        this.kakaoApiSevice = kakaoApiSevice;
    }

    @GetMapping("/openFeignHome")
    public String home() {
        return "/openFeignHome";
    }

    @PostMapping("/openFeignHome")
    public String list(@RequestParam("keyword") String keyword, Model model) {

        log.info(keyword);
        if (keyword != null) {
            KakaoApiResponseDTO.KeyWordSearchResponse temp = kakaoApiSevice.searchResult(keyword);
            log.info(String.valueOf(temp.getDocuments()));
            model.addAttribute("documents", temp.getDocuments());
        }
        return "/openFeignHome";
    }
}
