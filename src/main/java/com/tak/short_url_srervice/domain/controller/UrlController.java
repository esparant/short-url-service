package com.tak.short_url_srervice.domain.controller;

import com.tak.short_url_srervice.domain.entity.Url;
import com.tak.short_url_srervice.domain.entity.dto.UrlDto;
import com.tak.short_url_srervice.domain.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UrlController {

    private final UrlService urlService;

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/short-url-service")
    public String shortUrlService(@ModelAttribute("url") UrlDto url, Model model) {
        return "/url";
    }

    @PostMapping("/short-url-service")
    public String shortUrlService(@Valid @ModelAttribute("url") UrlDto urlDto,
                                  BindingResult bindingResult,
                                  Model model, RedirectAttributes redirectAttributes,
                                  HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("url", urlDto);
            log.info("errors: {}", bindingResult.getAllErrors());
            return "/url";
        }

        Url url = urlService.saveUrl(new Url(urlDto));

        redirectAttributes.addFlashAttribute("url", new UrlDto(url, request));

        return "redirect:/short-url-service";
    }


}
