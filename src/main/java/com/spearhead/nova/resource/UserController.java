package com.spearhead.nova.resource;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.google.common.hash.Hashing;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.User;
import com.spearhead.nova.model.pojoClasses.CustomerRequest;
import com.spearhead.nova.repository.UserRepository;
import com.spearhead.nova.service.userService;
import com.spearhead.nova.util.MethodUtils;
import com.spearhead.nova.util.PostResponseHelper;
import com.spearhead.nova.util.ValidateEntity;

import org.apache.commons.lang3.ObjectUtils;
import io.swagger.annotations.Api;
import net.bytebuddy.utility.RandomString;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import java.util.Objects;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.URI;

@Api(value = "User Endpoints", tags = {
        "Customer" }, description = "Rest APIs that Returns Information Corncering the Customer")
@RestController
@RequestMapping("/api/customer")
public class UserController {
    @Autowired
    // // Using Rest Template to consume external endpoint
    RestTemplate restTemplate;


    @Autowired
    private userService userServices;

    @Autowired
    private GetKeyContoller getKeyContoller;

    @Autowired
    private UserRepository userRepository;

        @Value("${spearhead.clientkey}")
        private String ClientKey;

        @Value("${spearhead.privatekey}")
        private String PrivateKey;

        @Value("${spearhead.symplusservice}")
        private  String baseDevURL;

 


    @GetMapping("/alluser")
    public List<User> fetchUserList() {
        return userServices.fetchUserList();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{customerid}")
    public ResponseEntity<StandardResponse> fetchUserByCustomerId(@PathVariable("customerid") String customerId) {

        try {

            Object data = userServices.fetchUserByCustomerId(customerId);

            StandardResponse sr = new StandardResponse();
            sr.setData(data);
            sr.setMessage("Get Users By Customer Id");
            sr.setStatus(true);
            sr.setStatuscode("200");

            return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            StandardResponse sr = new StandardResponse();
            sr.setStatus(false);
            return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
        }
        // return userServices.fetchUserByCustomerId(customerId);
    }

  

    @GetMapping("/validateOTP/{oneTimePassword}")
    public ResponseEntity<StandardResponse> valateOTP(@PathVariable("oneTimePassword") String oneTimePassword,
            User user) {

        try {

            Object data = userServices.fetchByOneTimePassword(oneTimePassword);

            StandardResponse sr = new StandardResponse();
            sr.setData(data);
            sr.setMessage("Otp Validate");
            sr.setStatus(true);
            sr.setStatuscode("200");

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String email = authentication.getName();
            Object datas = userRepository.findByOneTimePassword(oneTimePassword).get();

            if (ObjectUtils.isNotEmpty(datas)) {
                System.out.println("Hello");
                String OTP = RandomString.make(4);
                userRepository.sendNotificationByEmail(OTP, new java.util.Date(), email);
                return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
            } else {
                sr.setMessage("Otp Invalidated");
                sr.setStatus(false);

                return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            // TODO: handle exception
            StandardResponse sr = new StandardResponse();
            sr.setStatus(false);
            return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
        }

  
    }

  
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/CustomerRegistration")
    public ResponseEntity<String> DoIndividual(@RequestBody CustomerRequest customerRequest) throws URISyntaxException {

    

        String PublicKey = getKeyContoller.getKey();

        String Auth = PublicKey + ClientKey + PrivateKey;
 
        System.out.println("Customer Request .......... " + customerRequest);

        String Authorization = Hashing.sha256()
                .hashString(Auth, StandardCharsets.UTF_8)
                .toString();

        System.out.println(
                "Autorizatonssss .... " + Authorization + "\n   PulicKey .... " + PublicKey + "\n   PrivateKey ..."
                        + PrivateKey);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Authorization-Key", Authorization);
        headers.add("Client-Key", ClientKey);

        String path = baseDevURL + "/DoNewIndividual/";

        HttpEntity<String> entity = new HttpEntity<>(customerRequest.toString(), headers);
        System.out.println("HTTP ENTITY: " + entity + "Path is " + path);
        URI uri = new URI(path);
        ResponseEntity<String> resultr = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
        System.out.println("Hello " + uri);
        return resultr;

    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/CustomerRegister")
    public ResponseEntity<StandardResponse> DoCustomer(@RequestBody CustomerRequest customerRequest) throws URISyntaxException {

                
                        String path = baseDevURL + "/DoNewIndividual/";
                
                        StandardResponse sr = new StandardResponse();
                        HttpEntity<String> entity = ValidateEntity.getentity(customerRequest.toString());
                        
                        URI uri = new URI(path);
                        ResponseEntity<String> resultr = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
                        return PostResponseHelper.postResponse(sr, resultr);
                       
    

    }

    @PutMapping("user/signature/{customerid}")
    public ResponseEntity<StandardResponse> saveSignature(@ModelAttribute User user, HttpServletRequest request,
            @PathVariable("customerid") String customerId, @RequestParam("file") MultipartFile[] extramultipartFile)
            throws IOException {

        try {
            Object data = userServices.updateUserSignature(user, request, customerId, extramultipartFile);

            StandardResponse sr = new StandardResponse();
            sr.setStatus(true);
            sr.setStatuscode("200");
            sr.setMessage("User Signature Have Been Successfully Updated");
            sr.setData(data);

            return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            StandardResponse sr = new StandardResponse();
            sr.setStatus(false);
            return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
        }

        // @ModelAttribute Kyc kyc,

        // User userDB = UserRepository.findByCustomerId(customerId).get();

        // String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
        // .replacePath(null)
        // .build()
        // .toUriString();

        // System.out.println(baseUrl);
        // //Kyc kyc = new Kyc();
        // System.out.println("Hello");
        // System.out.println(extramultipartFile);
        // int count = 0;
        // for(MultipartFile extramultipart : extramultipartFile ) {
        // String fileName =
        // StringUtils.cleanPath(extramultipart.getOriginalFilename());

        // System.out.println(fileName);

        // if(count == 0) kyc.setSingature(fileName);
        // if(count == 1) kyc.setUtilityBill(fileName);
        // if(count == 2) kyc.setVoterCard(fileName);

        // count++;

        // }

        // if(Objects.nonNull(user.getSingature()) &&
        // !"".equalsIgnoreCase(user.getSingature())) {
        // userDB.setSingature(baseUrl);
        // }

        // userRepository.save(userDB);
        // //Kyc saveKy = kycService.saveKyc(kyc);

        // String uploadDir = "./kyc-doc/" + userDB.getCustomerId();

        // for(MultipartFile extramultipart : extramultipartFile ) {
        // String fileName =
        // StringUtils.cleanPath(extramultipart.getOriginalFilename());
        // FileUploadUtil.saveFile(uploadDir, extramultipart, fileName);
        // }

        // return "File Has been Succesfully Uploaded";

    }

    @PutMapping("user/Usersignature/{customerid}")
    public String UsersaveSignature(@ModelAttribute User user, HttpServletRequest request,
            @PathVariable("customerid") String customerId, @RequestParam("file") MultipartFile[] extramultipartFile)
            throws IOException {

        // @ModelAttribute Kyc kyc,

        User userDB = userRepository.findByCustomerId(customerId).get();

        String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath(null)
                .build()
                .toUriString();

        System.out.println(baseUrl);
        // Kyc kyc = new Kyc();
        System.out.println("Hello");
        System.out.println(extramultipartFile);
        int count = 0;
        for (MultipartFile extramultipart : extramultipartFile) {
            String fileName = StringUtils.cleanPath(extramultipart.getOriginalFilename());

            System.out.println(fileName);

            if (count == 0)
                user.setSingature(fileName);
            if (count == 1)
                user.setUtility_bill(fileName);
            if (count == 2)
                user.setVoter_card(fileName);

            count++;

        }

        if (Objects.nonNull(user.getSingature()) && !"".equalsIgnoreCase(user.getSingature())) {
            userDB.setSingature(baseUrl);
        }

        userRepository.save(userDB);
       
        String uploadDir = "./kyc-doc/" + userDB.getCustomerId();

        for (MultipartFile extramultipart : extramultipartFile) {
            String fileName = StringUtils.cleanPath(extramultipart.getOriginalFilename());
            FileUploadUtil.saveFile(uploadDir, extramultipart, fileName);
        }

        return "File Has been Succesfully Uploaded";

    }

    @PutMapping("user/signatureUpload/{customerid}")
    public ResponseEntity<StandardResponse> signatureUpload(@ModelAttribute User user,
            @PathVariable("customerid") String customerId, @RequestParam("file") MultipartFile extramultipartFile)
            throws IOException {

        // @ModelAttribute Kyc kyc,

        try {
            Object data = userServices.storeSignature(user, customerId, extramultipartFile);

            StandardResponse sr = new StandardResponse();
            sr.setStatus(true);
            sr.setStatuscode("200");
            sr.setMessage("User Signature Have Been Successfully Updated");
            sr.setData(data);

            return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            StandardResponse sr = new StandardResponse();
            sr.setStatus(false);
            return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
        }

    }

    @PutMapping("/user/{customerid}")
    public ResponseEntity<StandardResponse> updateUser(@PathVariable("customerid") String customerId,
            @RequestBody User user) {

        try {

            Object data = userServices.updateUser(customerId, user);

            StandardResponse sr = new StandardResponse();
            sr.setStatus(true);
            sr.setStatuscode("200");
            sr.setMessage("User Have Been Successfully Updated");
            sr.setData(data);

            return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            StandardResponse sr = new StandardResponse();
            sr.setStatus(false);
            return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
        }
        // return userServices.updateUser(customerId, user);

    }

    @GetMapping("/details")
    public ResponseEntity<String> getAllUsers() {

        System.out.println("Hello ");
        // RestTemplate restTemplate = new RestTemplate();
        String path = "https://bloomerapi.azurewebsites.net/api/getusers";
        System.out.println("Hello ");

        try {

            String allUsers = restTemplate.getForObject(path, String.class);

            JSONObject apiResponse = new JSONObject(allUsers);
            System.out.println("API " + apiResponse);
            JSONObject response = apiResponse.getJSONObject("data");// .getJSONObject("data");//.getJSONArray("allUsers");
            System.out.println("API " + response);

            // ResponseEntity<String> resp = restTemplate.exch(path, HttpMethod.GET, null,
            // null, null );

            // re
            return ResponseEntity.ok().body(response.toString());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(
                    MethodUtils.prepareResponseJSON(HttpStatus.BAD_REQUEST, "Returned Something"),
                    HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/TestingKey")
    public String getKey() {
        String uripath = "http://10.0.240.75:8181/apex/api/core/v3/GetKey/MXDZDGSECDLMSEOIYCZH/";
        String result = restTemplate.getForObject(uripath, String.class);
        JSONObject apiResponse = new JSONObject(result);
        String technology = apiResponse.getString("status");
        System.out.println("Response is ....... " + technology);

        String PublicKey = apiResponse.getJSONArray("result").getJSONObject(0).getJSONArray("Security")
                .getJSONObject(0).getString("PublicKey");
        System.out.println("API 1...... " + PublicKey);

        return result;

    }

    // get image by filename

    @GetMapping("/TestingDetails")
    public ResponseEntity<String> getDetails() {

        // System.out.println();
        // RestTemplate restTemplate = new RestTemplate();
        // String path = "https://bloomerapi.azurewebsites.net/api/getusers";
        // System.out.println("Hello ");

        String uripath = "http://10.0.240.75:8181/apex/api/core/v3/GetKey/MXDZDGSECDLMSEOIYCZH/";

        try {

            // String allUsers = restTemplate.getForObject(uripath, String.class);

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");

            HttpEntity<String> entity = new HttpEntity<String>("", headers);
            System.out.println("HTTP ENTITY" + entity);

            URI uri = new URI(uripath);
            System.out.println(uri);

            ResponseEntity<String> resultr = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
            JSONObject apiResponse = new JSONObject(resultr);
            // JSONObject response = apiResponse.getJSONObject("result");

            System.out.println("API GGGGGGGG " + apiResponse);

            // JSONObject apiResponse = new JSONObject(allUsers);
            // System.out.println("API " + apiResponse);
            // JSONObject response = apiResponse.getJSONObject("data");//
            // .getJSONObject("data");//.getJSONArray("allUsers");
            // System.out.println("API " + response);

            // ResponseEntity<String> resp = restTemplate.exch(path, HttpMethod.GET, null,
            // null, null );

            // re
            // return resultr.getBody();
            return ResponseEntity.ok().body(resultr.toString());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(
                    MethodUtils.prepareResponseJSON(HttpStatus.BAD_REQUEST, "Returned Something"),
                    HttpStatus.BAD_REQUEST);
        }

    }

}
