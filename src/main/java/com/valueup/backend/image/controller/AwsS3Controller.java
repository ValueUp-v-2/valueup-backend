package com.valueup.backend.image.controller;

import com.valueup.backend.image.service.AwsS3Service;
import com.valueup.backend.image.domain.AwsS3;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class AwsS3Controller {

   /* private final AwsS3Service awsS3Service;

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam(value = "data",required = false) MultipartFile multipartFile) throws IOException {
        return awsS3Service.upload(multipartFile,"announcement");
    }

//    @DeleteMapping("/upload")
//    public void removeNewFile(AwsS3 awsS3) {
//        awsS3Service.remove(awsS3);
//    }*/
}