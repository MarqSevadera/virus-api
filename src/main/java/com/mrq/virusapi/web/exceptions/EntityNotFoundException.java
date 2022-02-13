package com.mrq.virusapi.web.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityNotFoundException extends RuntimeException {

    private String[] paths;
    private String title;

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String title, String message) {
        super(message);
        this.title = title;
    }

    public static EntityNotFoundException withPaths(final String... paths) {
        final EntityNotFoundException a = new EntityNotFoundException();
        a.setPaths(paths);
        return a;
    }

    public static EntityNotFoundException withMessageAndPath(String message, String... paths) {
        final EntityNotFoundException a = new EntityNotFoundException(message);
        a.setPaths(paths);
        return a;
    }
}
