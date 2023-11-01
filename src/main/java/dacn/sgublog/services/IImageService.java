package dacn.sgublog.services;

import com.cloudinary.api.ApiResponse;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface IImageService {
    public boolean upload(MultipartFile file, String fileName) throws IOException;
    public ApiResponse getFile(String url) throws Exception;
}
