package com.otuzikibit.finance_portal.repository;

import com.otuzikibit.finance_portal.model.entity.ChatConversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChatConversationRepository extends JpaRepository<ChatConversation, UUID> {

    /** Kullanıcının sohbetleri (en son etkileşilen en üstte). */
    List<ChatConversation> findByUser_IdOrderByUpdatedAtDesc(UUID userId);
}
