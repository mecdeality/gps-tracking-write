package com.team2.gpstrackingwrite;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RestMapController {
    @Autowired
    private LocationServiceClass locationService;

    public static class RestResponse {
        private float latitude;
        private float longitude;

        public float getLatitude() {
            return latitude;
        }

        public float getLongitude() {
            return longitude;
        }

        public void setLatitude(float latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(float longitude) {
            this.longitude = longitude;
        }
    }

    public RestResponse globalRes;

    @RequestMapping(value = "/add-tracking", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse addTracking(@RequestParam Map<String,String> requestParams){
        RestResponse res = new RestResponse();

        float latitude = Float.parseFloat(requestParams.get("latitude"));
        float longitude = Float.parseFloat(requestParams.get("longitude"));

        res.setLatitude(latitude);
        res.setLongitude(longitude);

        LocationDomain location = new LocationDomain();
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        LocationDomain newLocation = this.locationService.create(location);
//        model.addAttribute("newName", newName);

        return res;
    }

//    @GetMapping(value = "/get-last-tracking", produces = MediaType.APPLICATION_JSON_VALUE)
//    public RestResponse lastTracking(Model model) throws JsonProcessingException {
////        String json = new ObjectMapper().writeValueAsString(globalRes);
//
//
//        return globalRes;
//    }
}
