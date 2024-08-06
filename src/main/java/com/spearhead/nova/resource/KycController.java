package com.spearhead.nova.resource;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spearhead.nova.model.Kyc;
import com.spearhead.nova.service.KycService;

import io.swagger.annotations.Api;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@Api(value = "User Endpoints", tags = {
"Customer" }, description = "Rest APIs that Returns Information Corncering the Customer")

@RestController
@RequestMapping("/api/customer/kyc")
public class KycController {
	
	@Autowired KycService kycService;

	
	@PostMapping("/savekyc")
	
	public String saveKyc(@ModelAttribute Kyc kyc, @RequestParam("file") MultipartFile[] extramultipartFile) throws IOException {

		
		System.out.println(extramultipartFile);
		int count = 0;
		for(MultipartFile extramultipart : extramultipartFile ) {
			String fileName = StringUtils.cleanPath(extramultipart.getOriginalFilename());
			
			System.out.println(fileName);
			
			if(count == 0) kyc.setSingature(fileName);
			if(count == 1) kyc.setUtilityBill(fileName);
			if(count == 2) kyc.setVoterCard(fileName);
			
			count++;
			
		}
		
		Kyc saveKy = kycService.saveKyc(kyc);
		
		String uploadDir = "./kyc-doc/" + saveKy.getKycId();
		
		for(MultipartFile extramultipart : extramultipartFile ) {
			String fileName = StringUtils.cleanPath(extramultipart.getOriginalFilename());
			FileUploadUtil.saveFile(uploadDir, extramultipart, fileName);
		}
		
		return "File Has been Succesfully Uploaded";
	
	}
}
