package dacn.sgublog.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfigs {
    @Bean
    public Cloudinary cloudinary(){
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "day1lniwb",
                "api_key", "618171718638899",
                "api_secret", "CgUmvpApV600mcV4FM2IvyeKSTo"));
        return cloudinary;
    }
}
