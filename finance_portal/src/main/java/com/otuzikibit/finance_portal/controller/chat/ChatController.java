package com.otuzikibit.finance_portal.controller.chat;

import com.otuzikibit.finance_portal.model.dto.chat.ChatMessageDto;
import com.otuzikibit.finance_portal.model.dto.chat.ChatRequestDto;
import com.otuzikibit.finance_portal.model.dto.chat.ChatResponseDto;
import com.otuzikibit.finance_portal.model.dto.chat.ConversationDto;
import com.otuzikibit.finance_portal.service.chat.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@Tag(name = "Chatbot", description = "FinansPortal asistanı — sohbetler ve mesajlar")
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/conversations")
    @Operation(summary = "Kullanıcının sohbetlerini listele")
    public ResponseEntity<List<ConversationDto>> listMine() {
        return ResponseEntity.ok(chatService.listMyConversations());
    }

    @GetMapping("/conversations/{id}/messages")
    @Operation(summary = "Bir sohbetin mesajları")
    public ResponseEntity<List<ChatMessageDto>> getMessages(@PathVariable UUID id) {
        return ResponseEntity.ok(chatService.getMessages(id));
    }

    @PostMapping("/messages")
    @Operation(summary = "Yeni mesaj gönder (conversationId null ise yeni sohbet açılır)")
    public ResponseEntity<ChatResponseDto> send(@RequestBody ChatRequestDto req) {
        return ResponseEntity.ok(chatService.sendMessage(req));
    }

    @DeleteMapping("/conversations/{id}")
    @Operation(summary = "Sohbeti sil")
    public ResponseEntity<Map<String, String>> delete(@PathVariable UUID id) {
        chatService.deleteConversation(id);
        return ResponseEntity.ok(Map.of("message", "Sohbet silindi."));
    }
}
