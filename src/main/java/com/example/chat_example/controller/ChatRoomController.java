package com.example.chat_example.controller;

import com.example.chat_example.model.ChatRoom;
import com.example.chat_example.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatService chatService;

    // 채팅 리스트 화면
    @GetMapping("/room")
    public String rooms(Model model) {
        String threadName = Thread.currentThread().getName();
        System.out.println("현재 쓰레드 이름: " + threadName);
        return "/chat/room";
    }
    // 모든 채팅방 목록 반환
    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
        String threadName = Thread.currentThread().getName();
        System.out.println("현재 쓰레드 이름: " + threadName);
        return chatService.findAllRoom();
    }
    // 채팅방 생성
    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {
        String threadName = Thread.currentThread().getName();
        System.out.println("현재 쓰레드 이름: " + threadName);
        return chatService.createRoom(name);
    }
    // 채팅방 입장 화면
    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
        String threadName = Thread.currentThread().getName();
        System.out.println("현재 쓰레드 이름: " + threadName);
        model.addAttribute("roomId", roomId);
        return "/chat/roomdetail";
    }
    // 특정 채팅방 조회
    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomId) {
        String threadName = Thread.currentThread().getName();
        System.out.println("현재 쓰레드 이름: " + threadName);
        return chatService.findById(roomId);
    }
}
