package com.colossus.homeserver.validator;

import com.colossus.homeserver.model.Album;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

@Component
public class AlbumValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Album.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Album album = (Album) o;
        if(StringUtils.isEmpty(album.getTitle())) {
            errors.rejectValue("title", "제목을 입력하세요.");
        }
    }
}
