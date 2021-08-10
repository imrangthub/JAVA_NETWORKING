package com.imran.sampleChat;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SimpleChat extends TextWebSocketHandler {

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {
		String payload = message.getPayload();
		JSONObject jsonObject = new JSONObject(payload);

		String userMsg = jsonObject.get("userMsg").toString();

		if (userMsg != null) {
			if (userMsg.toLowerCase().equals("hi")) {
				session.sendMessage(new TextMessage("Hello.."));
			} else if (userMsg.toLowerCase().equals("hello")) {
				session.sendMessage(new TextMessage("Hi.."));
			} else if (userMsg.toLowerCase().equals("no")) {
				session.sendMessage(new TextMessage("Okey, have a nice day !"));
			} else {
				session.sendMessage(new TextMessage("Hi how may we help you ?"));

			}
		}

	}

}