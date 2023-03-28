package ru.chantreck.bot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.chantreck.bot.dto.request.UpdateRequest;
import ru.chantreck.bot.exception.error.BadRequestError;

@RestController
public class RootController {
    @PostMapping(value = "/updates")
    public void update(@RequestBody UpdateRequest body) {
        throw new BadRequestError();
    }
}
