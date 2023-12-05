package dacn.sgublog.services.serviceImpl;

import com.cloudinary.Cloudinary;
import com.cloudinary.api.ApiResponse;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.databind.JsonNode;
import dacn.sgublog.services.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Component
public class ImageService implements IImageService {
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean upload(MultipartFile file, String fileName) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("public_id", fileName));
        return true;
    }

    @Override
    public ApiResponse getFile(String url) throws Exception {
        ApiResponse api = cloudinary.api().resource(url, ObjectUtils.emptyMap());
        return api;
    }
}
