package ru.chantreck.scrapper.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.chantreck.scrapper.exception.error.BadRequestError;
import ru.chantreck.scrapper.exception.error.not_found.ChatNotFound;

@Tag(name = "Chats")
@RestController
@RequestMapping("/tg-chat")
public class ChatController {
    @PostMapping("/{id}")
    public void registerChat(@PathVariable("id") Long chatId) {
        throw new BadRequestError();
    }

    @DeleteMapping("/{id}")
    public void getChat(@PathVariable("id") Long chatId) {
        throw new ChatNotFound();
    }
}
